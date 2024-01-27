package cc.dcyy.melina.domain.pethome

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
interface StateRepository : MongoRepository<State, Void> {

    fun findTop1ByOrderByTsDesc(): State?

    fun findAllByTsBetween(from: Instant, to: Instant): List<State>

}