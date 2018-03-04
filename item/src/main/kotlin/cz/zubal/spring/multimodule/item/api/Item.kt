package cz.zubal.spring.multimodule.item.api

import java.math.BigDecimal

data class Item(

        var uuid: String? = null,
        var type: String? = null,
        var name: String? = null,
        var price: BigDecimal? = null,
        var description: String? = null

)
