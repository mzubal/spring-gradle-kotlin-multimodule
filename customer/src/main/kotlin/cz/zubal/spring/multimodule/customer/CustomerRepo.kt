package cz.zubal.spring.multimodule.customer

import org.springframework.data.repository.CrudRepository

internal interface CustomerRepo : CrudRepository<CustomerEntity, Long> {

    fun findByUsername(username: String?): CustomerEntity

}
