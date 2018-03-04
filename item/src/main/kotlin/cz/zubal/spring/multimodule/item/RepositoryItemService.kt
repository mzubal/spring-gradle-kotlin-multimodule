package cz.zubal.spring.multimodule.item

import cz.zubal.spring.multimodule.customer.api.Customer
import cz.zubal.spring.multimodule.item.api.Item
import cz.zubal.spring.multimodule.item.api.ItemService
import org.modelmapper.ModelMapper
import org.modelmapper.TypeToken
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
internal class RepositoryItemService : ItemService {

    @Autowired
    lateinit var itemRepo: ItemRepo

    @Autowired
    lateinit var modelMapper: ModelMapper

    private var customerListType = object : TypeToken<List<Customer>>(){}.type

    override fun list(): List<Item> {
        return modelMapper.map<List<Item>>(itemRepo.findAll(), customerListType)
    }

    override fun findByUuid(uuid: String): Item {
        return modelMapper.map<Item>(itemRepo.findByUuid(uuid), Item::class.java)
    }

    override fun findByUuids(uuids: List<String>): List<Item> {
        return modelMapper.map<List<Item>>(itemRepo.findAllByUuidIn(uuids), customerListType)
    }

    override fun create(item: Item): Item {
        val dbItem = itemRepo.save(modelMapper.map(item, ItemEntity::class.java))
        return modelMapper.map<Item>(dbItem, Item::class.java)
    }
}
