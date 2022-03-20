package graph

import java.util.*

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



    /**
     * breadth first search for a graph that was implemented via an
     * adjacency list.
     */
    fun breadthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        val queue = LinkedList<Vertex<T>>()
        val enqueued = ArrayList<Vertex<T>>()
        val visited = ArrayList<Vertex<T>>()

        queue.add(source)
        enqueued.add(source)
        while (true) {
            val vertex = queue.poll() ?: break
            visited.add(vertex)
            val neighborEdges = edges(vertex)
            neighborEdges.forEach {
                if (!enqueued.contains(it.destination)) {
                    queue.add(it.destination)
                    enqueued.add(it.destination)
                }
            }
        }
        return visited
    }

}

enum class EdgeType {
    DIRECTED, UNDIRECTED
}
