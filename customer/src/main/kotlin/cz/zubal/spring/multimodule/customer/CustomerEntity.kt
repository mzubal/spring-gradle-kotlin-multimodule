package cz.zubal.spring.multimodule.customer

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
internal data class CustomerEntity (

    @Id
    @GeneratedValue
    var id: Long? = null,
    var username: String? = null,
    var firstName: String? = null,
    var lastName: String? = null

)
