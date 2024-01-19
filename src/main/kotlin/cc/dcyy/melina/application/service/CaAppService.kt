package cc.dcyy.melina.application.service

import cc.dcyy.melina.application.ro.ca.ReportRO
import cc.dcyy.melina.domain.ca.*
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CaAppService(@Autowired private val statusRepository: CaStatusRepository) {

    private val logger = KotlinLogging.logger {}

    fun report(ro: ReportRO): Status {
        val cpu = CPU(ro.cpuRate, ro.cpuTemperature)
        val memory = Memory(ro.memoryUsed, ro.memoryTotal)
        val disk = Disk(ro.diskUsed, ro.diskTotal)
        val status = Status(cpu, memory, disk, ro.mount, ro.smb, ro.dns)
        statusRepository.save(status)
        logger.info { "[] success. id: ${status.id}" }
        return status
    }

    fun isOk(): Boolean {
        val s = statusRepository.findTop1ByOrderByTsDesc() ?: return false
        return s.isOk()
    }

    fun findTop1ByOrderByTsDesc(): Status? {
        return statusRepository.findTop1ByOrderByTsDesc()
    }

}