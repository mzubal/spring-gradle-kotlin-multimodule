package cz.zubal.spring.multimodule.order.api

import cz.zubal.spring.multimodule.customer.api.Customer
import cz.zubal.spring.multimodule.item.api.Item

data class Order(

        var uuid: String? = null,
        var customer: Customer? = null,
        var items: List<Item> = emptyList()

)
