package cc.dcyy.melina.domain.pethome

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BootRecordRepository : MongoRepository<BootRecord, Void> {}