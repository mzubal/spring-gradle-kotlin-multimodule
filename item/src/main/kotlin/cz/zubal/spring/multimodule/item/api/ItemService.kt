package cz.zubal.spring.multimodule.item.api

interface ItemService {

    fun list(): List<Item>
    fun findByUuid(uuid: String): Item
    fun findByUuids(uuids: List<String>): List<Item>
    fun create(item: Item): Item

}
