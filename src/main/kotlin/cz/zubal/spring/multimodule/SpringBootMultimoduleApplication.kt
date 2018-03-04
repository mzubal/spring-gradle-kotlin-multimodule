package cz.zubal.spring.multimodule

import org.modelmapper.ModelMapper
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringBootMultimoduleApplication {

    fun main(args: Array<String>) {
        SpringApplication.run(SpringBootMultimoduleApplication::class.java, *args)
    }

    @Bean
    internal fun modelMapper(): ModelMapper {
        return ModelMapper()
    }

}
