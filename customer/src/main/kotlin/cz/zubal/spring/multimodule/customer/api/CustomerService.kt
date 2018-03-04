package cz.zubal.spring.multimodule.customer.api

interface CustomerService {

    fun list(): List<Customer>
    fun findByUsername(username: String?): Customer
    fun create(customer: Customer)

}
