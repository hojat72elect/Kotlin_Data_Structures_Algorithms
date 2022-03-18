import graph.AdjacencyList
import graph.EdgeType

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
    println(myGraph.weight(singapore, tokyo))
println(myGraph.edges(sanFrancisco))
}