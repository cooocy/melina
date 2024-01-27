package cc.dcyy.melina.infrastructure.kits

import jakarta.servlet.http.HttpServletRequest

object HttpServletKits {

    fun getIp(request: HttpServletRequest): String {
        val xff = request.getHeaders("X-Forwarded-For")
        if (!xff.hasMoreElements()) {
            return ""
        }
        val xffHeader = xff.nextElement()
        return if (xffHeader.contains(",")) xffHeader.substring(0, xffHeader.indexOf(",")) else xffHeader
    }

}