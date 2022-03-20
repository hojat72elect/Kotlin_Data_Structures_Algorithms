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

    fun depthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {

        // our path through the graph.
        val stack = Stack<Vertex<T>>()
        // visited vertices in the order they were visited.
        val visited = arrayListOf<Vertex<T>>()
        // Remembers which vertices were already pushed so that you don’t visit
        // the same vertex twice. It's a MutableSet to ensure fast O(1) lookup.
        val pushed = mutableSetOf<Vertex<T>>()

        // The starting point of our algorithm.
        stack.push(source)
        pushed.add(source)
        visited.add(source)

        outer@ while (true) {
            if (stack.isEmpty()) break

            val vertex =
                stack.peek()!! // in here we just peek (we continue checking the top of the stack for a vertex until the stack is empty).
            val neighbors = edges(vertex) // all the neighboring edges for the current vertex.

            // There are no neighboring edges, pop the stack and go for next vertex.
            if (neighbors.isEmpty()) {
                stack.pop()
                continue
            }

            /*
             * Check all the neighbors of the current vertex, the first neighbor that isn't already pushed in, will be pushed into our stack and also visited. Then we go to the outer loop to check out the newly pushed neighbor.
             */

            for (i in 0 until neighbors.size) {
                val destination = neighbors[i].destination
                if (destination !in pushed) {
                    // the vertex is not already pushed in our stacks.
                    stack.push(destination)
                    pushed.add(destination)
                    visited.add(destination)
                    continue@outer
                }
            }
            // If we get to this point, it means that the current vertex doesn't have any unvisited neighbors, so we're in a dead-end  and have to back track by popping the stack.
            stack.pop()
        }



        return visited
    }
}

enum class EdgeType {
    DIRECTED, UNDIRECTED
}
