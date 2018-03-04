package cz.zubal.spring.multimodule.customer

import cz.zubal.spring.multimodule.customer.api.Customer
import cz.zubal.spring.multimodule.customer.api.CustomerService
import org.modelmapper.ModelMapper
import org.modelmapper.TypeToken
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.reflect.Type

@Component
internal class RepositoryCustomerService : CustomerService {

    @Autowired
    lateinit var customerRepo: CustomerRepo

    @Autowired
    lateinit var modelMapper: ModelMapper

    var customerListType: Type = object : TypeToken<List<Customer>>(){}.type

    override fun list(): List<Customer> {
        return modelMapper.map(customerRepo.findAll(), customerListType)
    }

    override fun findByUsername(username: String?): Customer {
        return modelMapper.map(customerRepo.findByUsername(username), Customer::class.java)
    }

    override fun create(customer: Customer) {
        customerRepo.save(modelMapper.map(customer, CustomerEntity::class.java))
    }
}
