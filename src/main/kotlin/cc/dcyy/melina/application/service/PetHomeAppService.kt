package cc.dcyy.melina.application.service

import cc.dcyy.melina.application.ro.pethome.ReportHeartbeatRO
import cc.dcyy.melina.application.ro.pethome.ReportStateRO
import cc.dcyy.melina.domain.global.BizException
import cc.dcyy.melina.domain.global.CodeAndMessage.*
import cc.dcyy.melina.domain.pethome.*
import cn.hutool.core.util.StrUtil
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class PetHomeAppService @Autowired private constructor(
    val bootRecordRepository: BootRecordRepository,
    val clientConfigRepository: ClientConfigRepository,
    val heartbeatRepository: HeartbeatRepository,
    val stateRepository: StateRepository
) {

    private val logger = KotlinLogging.logger {}

    fun reportBootRecord() {
        bootRecordRepository.save(BootRecord())
    }

    fun reportHeartbeat(ro: ReportHeartbeatRO) {
        if (StrUtil.isBlank(ro.ip)) {
            throw BizException(ArgsIllegal, "ip 不能为空")
        }
        heartbeatRepository.save(Heartbeat(ro.ip))
    }

    fun reportState(ro: ReportStateRO) {
        stateRepository.save(State(ro.temperature, ro.relativeHumidity))
    }

    fun findClientConfig(): ClientConfig {
        val configs = clientConfigRepository.findAll()
        if (configs.isEmpty()) {
            val clientConfig = ClientConfig(4, 8)
            clientConfigRepository.save(clientConfig)
            return clientConfig
        }
        return configs[0]
    }

    fun findLatestHeartbeat(): Heartbeat? {
        return heartbeatRepository.findTop1ByOrderByTsDesc()
    }

    fun findLatestState(): State? {
        return stateRepository.findTop1ByOrderByTsDesc()
    }

    fun listStates(from: Instant, to: Instant): List<State> {
        return stateRepository.findAllByTsBetween(from, to)
    }

}