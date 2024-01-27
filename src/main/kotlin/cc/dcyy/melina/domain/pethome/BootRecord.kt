package cc.dcyy.melina.domain.pethome

import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

/**
 * 启动记录
 *
 * @param ts 启动时间
 */
@Document("petHome_bootRecord")
data class BootRecord @Deprecated("Called by mongodb deserialize.") constructor(val ts: Instant) {

    constructor() : this(Instant.now())

}
