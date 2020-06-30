package test

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Controller
@Secured(SecurityRule.IS_AUTHENTICATED)
class TestController {

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Get("/person")
    fun getPerson() :Person{
        return Person("bernie", 55)
    }

    @Get("/persons")
    @Secured("ADMIN")
    fun getPersons() :List<Person>{

        return listOf(Person("bernie", 55), Person("Barbie", 23))
    }

    @Get("/men")
    @Secured("USER")
    fun getMen() :List<Person>{

        return listOf(Person("bernie", 55), Person("Barry", 23))
    }

}

data class Person (val name: String, val age: Int)