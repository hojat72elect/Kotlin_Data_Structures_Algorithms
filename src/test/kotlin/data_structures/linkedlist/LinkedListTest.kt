package data_structures.linkedlist

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LinkedListTest() {

    @Test
    fun generalOperations() {

        val sut = LinkedList<Int>()
        assertEquals(0, sut.size)
        assertTrue { sut.isEmpty() }

        sut
            .push(34)
            .append(23)
            .push(12)
            .append(-12)
            .push(7)

        assertFalse { sut.isEmpty() }
        assertEquals(5, sut.size)
        assertEquals(7, sut.nodeAt(0)!!.value)
        assertEquals(23, sut.nodeAt(3)!!.value)

        sut.insert(100, 2)
        assertEquals(6, sut.size)

        assertEquals(7, sut.pop())
        assertEquals(12, sut.pop())
        assertEquals(4, sut.size)

        assertEquals(-12, sut.removeLast())
        assertEquals(3, sut.size)

        assertTrue { sut.contains(34) }
        assertFalse { sut.contains(46) }
        assertTrue { sut.containsAll(listOf(100, 34, 23)) }
        assertFalse { sut.containsAll(listOf(100, 35, 23)) }

        assertEquals(34, sut.remove(1))
        assertEquals(2, sut.size)
    }

}