package cc.dcyy.melina.domain.pethome

import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

/**
 * 一个监控状态
 *
 * @param ts               时间戳
 * @param temperature      温度, 摄氏度
 * @param relativeHumidity 相对湿度, 百分号前面的数字
 */
@Document("petHome_state")
data class State @Deprecated("Called by mongodb deserialize.") constructor(
    val ts: Instant,
    val temperature: Float,
    val relativeHumidity: Int
) {
    constructor(temperature: Float, relativeHumidity: Int) : this(Instant.now(), temperature, relativeHumidity)
}
