package cc.dcyy.melina.domain.pethome

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientConfigRepository : MongoRepository<ClientConfig, Void> {}