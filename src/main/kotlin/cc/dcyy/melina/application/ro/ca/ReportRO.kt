package cc.dcyy.melina.application.ro.ca

data class ReportRO(
    var cpuRate: Int,
    var cpuTemperature: Int,
    var memoryUsed: Long,
    var memoryTotal: Long,
    var diskUsed: Long,
    var diskTotal: Long,
    var mount: Boolean,
    var smb: Boolean,
    var dns: Boolean
)
