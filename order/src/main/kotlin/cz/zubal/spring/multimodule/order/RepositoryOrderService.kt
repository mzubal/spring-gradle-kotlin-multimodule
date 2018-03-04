package cz.zubal.spring.multimodule.order

import cz.zubal.spring.multimodule.customer.api.CustomerService
import cz.zubal.spring.multimodule.item.api.ItemService
import cz.zubal.spring.multimodule.order.api.Order
import cz.zubal.spring.multimodule.order.api.OrderService
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
internal class RepositoryOrderService : OrderService {

    @Autowired
    lateinit var customerService: CustomerService

    @Autowired
    lateinit var itemService: ItemService

    @Autowired
    lateinit var orderRepo: OrderRepo

    @Autowired
    lateinit var modelMapper: ModelMapper

    override fun list(): List<Order> {
        return orderRepo.findAll().map { it -> mapToApiOrder(it) }
    }

    override fun findByUuid(uuid: String): Order {
        return mapToApiOrder(orderRepo.findByUuid(uuid))
    }

    override fun create(order: Order): Order {
        val orderEntity = modelMapper.map(order, OrderEntity::class.java)
        orderEntity.username = order.customer?.username
        orderEntity.items = order.items.map{it -> it.uuid}.requireNoNulls()
        return mapToApiOrder(orderRepo.save(orderEntity))
    }

    private fun mapToApiOrder(dbOrder: OrderEntity): Order {
        val order = modelMapper.map(dbOrder, Order::class.java)
        order.customer = customerService.findByUsername(dbOrder.username)
        order.items = itemService.findByUuids(dbOrder.items)
        return order
    }

}
