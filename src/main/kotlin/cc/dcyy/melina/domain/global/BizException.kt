package cc.dcyy.melina.domain.global

import er.carian.response.AbstractBizException

class BizException : AbstractBizException {

    constructor(cm: CodeAndMessage, message: String) : super(cm.code, message)

    constructor(cm: CodeAndMessage) : super(cm.code, cm.message)

}