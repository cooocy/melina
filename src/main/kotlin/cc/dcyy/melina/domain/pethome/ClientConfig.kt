package cc.dcyy.melina.domain.pethome

import org.springframework.data.mongodb.core.mapping.Document

/**
 * 客户端配置
 *
 * @param heartbeatInterval 心跳间隔, s
 * @param monitorInterval 监控上报间隔, s
 */
@Document("petHome_clientConfig")
data class ClientConfig(val heartbeatInterval: Int, val monitorInterval: Int)
