package data_structures.graph

/**
 * @author Hojat Ghasemi,
 * 2022-03-18
 * https://github.com/hojat72elect
 */
data class Edge<T>(
    val source: Vertex<T>,
    val destination: Vertex<T>,
    val weight: Double? = null
)
