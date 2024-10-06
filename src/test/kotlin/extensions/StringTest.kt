package extensions

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringTest {
    @Test
    fun checkIfIsAnagram() {
        val string1 = "dormitory"
        val string2 = "help"

        assertTrue { string1.isAnagramOf("dirtyroom") }
        assertTrue { string2.isAnagramOf("pleh") }
        assertFalse { string2.isAnagramOf("plep") }
    }

    @Test
    fun checkIfIsPangram() {
        val string1 = "The quick brown fox jumps over the lazy dog"
        val string2 = "Hello"

        assertTrue { string1.isPangram() }
        assertFalse { string2.isPangram() }
    }
}