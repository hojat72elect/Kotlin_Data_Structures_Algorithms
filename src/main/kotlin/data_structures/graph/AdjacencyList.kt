package data_structures.graph

/**
 * @author Hojat Ghasemi,
 * 2022-03-18
 * https://github.com/hojat72elect
 *
 * This class implements the Graph interface, and we define our graphs by
 * extending it.
 */
class AdjacencyList<T> : Graph<T> {
    // key is the vertex and value is an
    // array of edges connected to that vertex.
    private val adjacencies: HashMap<Vertex<T>, ArrayList<Edge<T>>> = HashMap()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), data)
        // an empty ArrayList of edges for this new vertex.
        adjacencies[vertex] = ArrayList()
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        // When the edge is a directed one, it will only be added to the corresponding array of the source vertex (and not the destination vertex).
        adjacencies[source]?.add(edge)
    }

    /**
     * @return either an array of edges going out of this vertex or an empty array (if the vertex is not defined/null).
     */
    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> = adjacencies[source] ?: arrayListOf()

    /**
     * Remember that this implementation returns the weight of the first edge
     * in the list of edges going from source to destination (in case there are
     * more than 1 edge doing so).
     */
    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return edges(source).firstOrNull {
            it.destination == destination
        }?.weight
    }

    /**
     * Simply prints out all the vertices and the destinations that have an edge in common with that specific vertex.
     */
    override fun toString(): String {
        return buildString {
            adjacencies.forEach { (vertex, edges) ->
                val edgeString = edges.joinToString { it.destination.data.toString() }
                append("${vertex.data} ---> [ $edgeString ]\n")
            }
        }
    }

}