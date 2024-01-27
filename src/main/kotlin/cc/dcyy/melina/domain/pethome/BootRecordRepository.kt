package cc.dcyy.melina.domain.pethome

import er.rennala.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BootRecordRepository : MongoRepository<BootRecord, Void> {}