package graph

/**
 * @author Hojat Ghasemi,
 * 2022-03-17
 * https://github.com/hojat72elect
 *
 * @param index a unique integer referring to this unique Vertex.
 * @param data just the data value that this vertex is containing,
 * it can be anything.
 */

data class Vertex<T>(val index: Int, val data: T)