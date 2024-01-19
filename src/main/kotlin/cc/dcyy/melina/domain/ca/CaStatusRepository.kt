package cc.dcyy.melina.domain.ca

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CaStatusRepository : MongoRepository<Status, Long> {

    fun findTop1ByOrderByTsDesc(): Status?

}