package data_structures.stack

import org.junit.Test
import kotlin.test.assertEquals

class StackTest {


    @Test
    fun testBasicOperations() {
        val sut = Stack<Int>()
        sut.push(1).push(2).push(3)

        assertEquals(3, sut.peek())
        assertEquals(3, sut.pop())
        assertEquals(2, sut.peek())

    }

    @Test
    fun testEmptyStack() {
        val sut = Stack<Int>()

        assertEquals(true, sut.isEmpty)
        assertEquals(null, sut.pop())
        assertEquals(null, sut.peek())
    }

    @Test
    fun testMultipleOperations(){
        val stack = Stack<String>()
        stack.push("apple").push("banana").push("cherry")
        stack.pop()

        assertEquals("banana", stack.peek())
        stack.pop()
        stack.pop()

        assertEquals(true, stack.isEmpty)
    }
}
