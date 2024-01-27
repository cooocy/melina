package cc.dcyy.melina.interfaces.controller

import cc.dcyy.melina.application.ro.pethome.ReportHeartbeatRO
import cc.dcyy.melina.application.ro.pethome.ReportStateRO
import cc.dcyy.melina.application.service.PetHomeAppService
import cc.dcyy.melina.domain.pethome.ClientConfig
import cc.dcyy.melina.domain.pethome.Heartbeat
import cc.dcyy.melina.domain.pethome.State
import cc.dcyy.melina.infrastructure.kits.HttpServletKits
import er.carian.response.R
import er.carian.response.R.ok
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@CrossOrigin
@RequestMapping("/pet-home")
@RestController
class PetHomeController(@Autowired val s: PetHomeAppService, val request: HttpServletRequest) {

    /**
     * 上报启动记录
     */
    @PostMapping("/report-boot-record")
    fun reportBootRecord(): R<Void> {
        s.reportBootRecord()
        return ok()
    }

    /**
     * 上报心跳
     */
    @PostMapping("/report-heartbeat")
    fun reportHeartbeat(): R<Void> {
        val ip = HttpServletKits.getIp(request)
        s.reportHeartbeat(ReportHeartbeatRO(ip))
        return ok()
    }

    /**
     * 上报状态
     */
    @PostMapping("/report-state")
    fun reportState(@Valid @RequestBody ro: ReportStateRO): R<Void> {
        s.reportState(ro)
        return ok()
    }

    /**
     * 查询客户端配置
     */
    @GetMapping("/find-client-config")
    fun findClientConfig(): R<ClientConfig> {
        return ok(s.findClientConfig())
    }

    /**
     * 查询新近心跳
     */
    @GetMapping("/find-latest-heartbeat")
    fun findLatestHeartbeat(): R<Heartbeat> {
        return ok(s.findLatestHeartbeat())
    }

    /**
     * 查询最近状况
     */
    @GetMapping("/find-latest-state")
    fun findLatestState(): R<State?> {
        return ok(s.findLatestState())
    }

    /**
     * 列表查询状态
     */
    @GetMapping("/list-state")
    fun listStates(from: Instant, to: Instant): R<List<State>> {
        // Parameter specified as non-null is null: method cc.dcyy.melina.interfaces.controller.PetHomeController.listStates, parameter from
        // 10001
        return ok(s.listStates(from, to))
    }


}