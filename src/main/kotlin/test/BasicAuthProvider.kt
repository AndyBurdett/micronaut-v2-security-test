package test

import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.reactivex.Maybe
import io.reactivex.MaybeEmitter
import org.reactivestreams.Publisher
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class BasicAuthProvider : AuthenticationProvider {

    @Inject
    lateinit var userStore: UserStore

    override fun authenticate(httpRequest: HttpRequest<*>?, authenticationRequest: AuthenticationRequest<*, *>): Publisher<AuthenticationResponse?>? {

        val user = authenticationRequest.identity.toString()
        return Maybe.create { emitter: MaybeEmitter<AuthenticationResponse?> ->
            if (authenticationRequest.secret == userStore.users[user]) {
                emitter.onSuccess(UserDetails(user, listOf(userStore.roles[user])))
            } else {
                emitter.onError(AuthenticationException(AuthenticationFailed()))
            }
        }.toFlowable()
    }

}


