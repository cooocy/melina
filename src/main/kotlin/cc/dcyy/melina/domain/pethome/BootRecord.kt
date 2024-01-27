package cc.dcyy.melina.domain.pethome

import er.rennala.repository.AggregateRoot
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

/**
 * 启动记录
 *
 * @param ts 启动时间
 */
@Document("petHome_bootRecord")
data class BootRecord @Deprecated("Called by mongodb deserialize.") constructor(val ts: Instant) : AggregateRoot {

    constructor() : this(Instant.now())

}
