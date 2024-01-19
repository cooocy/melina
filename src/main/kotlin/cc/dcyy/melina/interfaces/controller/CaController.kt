package cc.dcyy.melina.interfaces.controller

import cc.dcyy.melina.application.ro.ca.ReportRO
import cc.dcyy.melina.application.service.CaAppService
import cc.dcyy.melina.domain.ca.Status
import er.carian.response.R
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/ca")
@RestController
class CaController(@Autowired val s: CaAppService) {

    @PostMapping("/report")
    fun report(@RequestBody ro: ReportRO): R<Status> {
        return R.ok(s.report(ro))
    }

    @GetMapping("/is-ok")
    fun isOk(): R<String> {
        val m = if (s.isOk()) "Cleanrot-Armor OK" else "Cleanrot-Armor Error"
        return R.ok(m)
    }

    @GetMapping("/find-latest")
    fun findLatest(): R<Status?> {
        return R.ok(s.findTop1ByOrderByTsDesc())
    }

}