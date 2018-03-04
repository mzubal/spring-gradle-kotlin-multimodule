package cz.zubal.spring.multimodule

import cz.zubal.spring.multimodule.customer.api.Customer
import cz.zubal.spring.multimodule.customer.api.CustomerService
import cz.zubal.spring.multimodule.item.api.Item
import cz.zubal.spring.multimodule.item.api.ItemService
import cz.zubal.spring.multimodule.order.api.Order
import cz.zubal.spring.multimodule.order.api.OrderService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.math.BigDecimal

@RunWith(SpringRunner::class)
@SpringBootTest
class SpringBootMultimoduleApplicationTests {

    @Autowired
    internal lateinit var orderService: OrderService

    @Autowired
    internal lateinit var customerService: CustomerService

    @Autowired
    internal lateinit var itemService: ItemService

    @Test
    fun simpleIntegrationTest() {
        val customer = Customer()
        customer.username = "milos"
        customer.firstName = "Milos"
        customer.lastName = "Zubal"
        customerService.create(customer)

        val item = Item()
        item.uuid = "item-1"
        item.name = "vim"
        item.description = "Text editor to learn."
        item.type = "Text Editor"
        item.price = BigDecimal(0)
        itemService.create(item)

        val order = Order()
        order.customer = customer
        order.items = listOf(item)
        orderService.create(order)
    }
}
