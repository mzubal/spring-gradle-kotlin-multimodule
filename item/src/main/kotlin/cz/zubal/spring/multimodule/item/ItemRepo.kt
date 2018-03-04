package cz.zubal.spring.multimodule.item

import org.springframework.data.repository.CrudRepository

internal interface ItemRepo : CrudRepository<ItemEntity, Long> {

    fun findByUuid(uuid: String): ItemEntity
    fun findAllByUuidIn(itemUuids: List<String>): List<ItemEntity>

}
