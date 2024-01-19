package cc.dcyy.melina.domain.ca

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class StatusTest {

    @Test
    fun testConstructor() {
        val cpu = CPU(10, 20)
        val memory = Memory(20, 200)
        val disk = Disk(30, 40)
        val s1 = Status(cpu, memory, disk, true, true, false)
        val s2 = Status(cpu, memory, disk, true, true, false)
        val s3 = Status(s1.id, s1.ts, s1.cpu, s1.memory, Disk(2, 3), false, false, false)
        Assertions.assertTrue(s1 == s3)
        Assertions.assertEquals(s1, s3)
        Assertions.assertFalse(s1 == s2)
        Assertions.assertNotEquals(s1, s2)
        Assertions.assertFalse(s1 === s2)
        println(s1.hashCode())
        println(s1)
        s1.cpu
        s1.disk
        s1.id
        s1.memory
        s1.dns
        s1.mount
        s1.ts
        s1.smb
    }

}