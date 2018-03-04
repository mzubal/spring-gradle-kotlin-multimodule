package cz.zubal.spring.multimodule.order

import org.springframework.data.repository.CrudRepository

internal interface OrderRepo : CrudRepository<OrderEntity, Long> {

    fun findByUuid(uuid: String): OrderEntity

}
