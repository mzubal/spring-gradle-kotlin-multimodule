package cz.zubal.spring.multimodule.order

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
internal data class OrderEntity (

    @Id
    @GeneratedValue
    var id: Long? = null,
    var uuid: String? = null,
    var username: String? = null,

    @ElementCollection
    var items: List<String> = emptyList()

)
