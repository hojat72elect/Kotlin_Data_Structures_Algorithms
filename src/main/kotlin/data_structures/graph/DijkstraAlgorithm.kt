import data_structures.graph.AdjacencyList
import data_structures.graph.EdgeType

/**
 * In here I have defined Graph as a data class, but I had previously defined Graph as an Interface. So, I think it's better I come back to this implementation later and try to change it in a way that it's possible to define a graph as an object (the class way).
 */
private data class Graph<T>(
    val vertices: Set<T>,
    val edges: Map<T, Set<T>>,
    val weights: Map<Pair<T, T>, Int>
)

private fun <T> dijkstraAlgorithm(graph: Graph<T>, start: T): Map<T, T?> {
    val s: MutableSet<T> = mutableSetOf() //// a subset of vertices, for which we know the true distance
    val delta = graph.vertices.map { it to Int.MAX_VALUE }.toMap().toMutableMap()
    delta[start] = 0
    val previous: MutableMap<T, T?> = graph.vertices.map { it to null }.toMap().toMutableMap()
    while (s != graph.vertices) {
        val v: T = delta
            .filter { !s.contains(it.key) }
            .minByOrNull { it.value }!!
            .key

        graph.edges.getValue(v).minus(s).forEach { neighbor ->
            val newPath = delta.getValue(v) + graph.weights.getValue(Pair(v, neighbor))

            if (newPath < delta.getValue(neighbor)) {
                delta[neighbor] = newPath
                previous[neighbor] = v
            }
        }
        s.add(v)
    }
    return previous.toMap()
}

fun <T> shortestPath(shortestPathTree: Map<T, T?>, start: T, end: T): List<T> {
    fun pathTo(start: T, end: T): List<T> {
        if (shortestPathTree[end] == null) return listOf(end)
        return listOf(pathTo(start, shortestPathTree[end]!!), listOf(end)).flatten()
    }
    return pathTo(start, end)

}

fun main() {
    val myGraph = AdjacencyList<String>()

    // Defining all the vertices
    val singapore = myGraph.createVertex("Singapore")
    val tokyo = myGraph.createVertex("Tokyo")
    val hongKong = myGraph.createVertex("Hong Kong")
    val detroit = myGraph.createVertex("Detroit")
    val sanFrancisco = myGraph.createVertex("San Francisco")
    val washingtonDC = myGraph.createVertex("Washington DC")
    val austinTexas = myGraph.createVertex("Austin Texas")
    val seattle = myGraph.createVertex("Seattle")

    // Adding all the edges
    myGraph.add(EdgeType.UNDIRECTED, singapore, hongKong, 300.0)
    myGraph.add(EdgeType.UNDIRECTED, singapore, tokyo, 500.0)
    myGraph.add(EdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
    myGraph.add(EdgeType.UNDIRECTED, tokyo, detroit, 450.0)
    myGraph.add(EdgeType.UNDIRECTED, tokyo, washingtonDC, 300.0)
    myGraph.add(EdgeType.UNDIRECTED, hongKong, sanFrancisco, 600.0)
    myGraph.add(EdgeType.UNDIRECTED, detroit, austinTexas, 50.0)
    myGraph.add(EdgeType.UNDIRECTED, austinTexas, washingtonDC, 292.0)
    myGraph.add(EdgeType.UNDIRECTED, sanFrancisco, washingtonDC, 337.0)
    myGraph.add(EdgeType.UNDIRECTED, washingtonDC, seattle, 277.0)
    myGraph.add(EdgeType.UNDIRECTED, sanFrancisco, seattle, 218.0)
    myGraph.add(EdgeType.UNDIRECTED, austinTexas, sanFrancisco, 297.0)

    println(myGraph)

}