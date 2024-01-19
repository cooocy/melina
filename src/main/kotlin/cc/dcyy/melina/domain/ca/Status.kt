package cc.dcyy.melina.domain.ca

import cn.hutool.core.util.IdUtil
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

/**
 * 表示 树莓派 Cleanrot-Armor 的所有状态
 *
 * @param cpu    cpu
 * @param memory 内存
 * @param disk   磁盘
 * @param mount  挂载目录
 * @param smb    samba 服务
 * @param dns    dns 服务
 */
@Document("ca_status")
class Status @Deprecated("Called by mongodb deserialize.") constructor(
    @Id val id: Long,
    val ts: Instant,
    val cpu: CPU,
    val memory: Memory,
    val disk: Disk,
    val mount: Boolean,
    val smb: Boolean,
    val dns: Boolean
) {

    constructor(
        cpu: CPU, memory: Memory, disk: Disk, mount: Boolean, smb: Boolean, dns: Boolean
    ) : this(IdUtil.getSnowflake().nextId(), Instant.now(), cpu, memory, disk, mount, smb, dns)

    fun isOk(): Boolean {
        return mount && smb && dns && ts.plusSeconds(180).isAfter(Instant.now())
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Status

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}
