package graph

/**
 * @author Hojat Ghasemi,
 * 2022-03-17
 * https://github.com/hojat72elect
 */

interface Graph<T> {
    fun createVertex(data: T): Vertex<T>
    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)

    /**
     * An undirected edge is pretty much like 2 directed edges, one from
     * source to destination and another one from destination to source.
     */
    fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    /**
     * Adds either a directed or undirected edge between 2 vertices of the graph.
     */
    fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        when (edge) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }

    /**
     * Returns a list of all the outgoing edges from a specific vertex.
     */
    fun edges(source: Vertex<T>): ArrayList<Edge<T>>

    /**
     * Returns the weight of the unique edge that starts from "source" and ends at "destination" as a Double? value.
     */
    fun weight(source: Vertex<T>, destination: Vertex<T>): Double?
}

enum class EdgeType {
    DIRECTED, UNDIRECTED
}