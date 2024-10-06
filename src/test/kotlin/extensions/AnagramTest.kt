package extensions

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AnagramTest {
    @Test
    fun checkIfIsAnagram() {
        val string1 = "dormitory"
        val string2 = "help"

        assertTrue { string1.isAnagramOf("dirtyroom") }
        assertTrue { string2.isAnagramOf("pleh") }
        assertFalse { string2.isAnagramOf("plep") }
    }
}