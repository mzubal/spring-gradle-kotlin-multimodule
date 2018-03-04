package cz.zubal.spring.multimodule.order.api

interface OrderService {

    fun list(): List<Order>
    fun findByUuid(uuid: String): Order
    fun create(order: Order): Order

}
