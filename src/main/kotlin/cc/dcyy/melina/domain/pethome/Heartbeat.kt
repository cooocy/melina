package cc.dcyy.melina.domain.pethome

import er.rennala.repository.AggregateRoot
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

/**
 * 心跳
 *
 * @param ip 客户端 ip
 * @param ts 心跳时间
 */
@Document("petHome_heartbeat")
data class Heartbeat @Deprecated("Called by mongodb deserialize.") constructor(val ip: String, val ts: Instant) :
    AggregateRoot {

    constructor(ip: String) : this(ip, Instant.now())

}
