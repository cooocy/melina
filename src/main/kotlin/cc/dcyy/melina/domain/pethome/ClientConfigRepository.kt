package cc.dcyy.melina.domain.pethome

import er.rennala.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientConfigRepository : MongoRepository<ClientConfig, Void> {}