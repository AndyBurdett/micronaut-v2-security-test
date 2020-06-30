package test

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.core.convert.format.MapFormat

@ConfigurationProperties("credentials")
class UserStore {

    @MapFormat
    lateinit var users : Map<String, String>
    @MapFormat
    lateinit var roles: Map<String, String>

}
