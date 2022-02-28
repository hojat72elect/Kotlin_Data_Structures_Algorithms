package stack

/**
 * @author Hojat Ghasemi,
 * 2022-02-27
 * https://github.com/hojat72elect
 *
 * This interface defines all the important characteristics that a Stack data structure should have. That's why I decided to call it "Stackable".
 */
interface Stackable<out T> {
//    fun push(element: Element)
    fun pop(): T?
}