package cc.dcyy.melina.application.ro.pethome

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

class ReportStateRO(
    var temperature: Float,
    @field:Max(value = 100, message = "relativeHumidity 不能大于 100")
    @field:Min(value = 1, message = "relativeHumidity 不能小于 1")
    var relativeHumidity: Int
)