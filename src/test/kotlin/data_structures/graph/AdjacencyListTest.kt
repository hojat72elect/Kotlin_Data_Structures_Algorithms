package data_structures.graph

import kotlin.test.Test
import kotlin.test.assertEquals

class AdjacencyListTest() {

    @Test
    fun generalStuff() {
        val sut = AdjacencyList<String>()

        // Defining all the vertices
        val singapore = sut.createVertex("Singapore")
        val tokyo = sut.createVertex("Tokyo")
        val hongKong = sut.createVertex("Hong Kong")
        val detroit = sut.createVertex("Detroit")
        val sanFrancisco = sut.createVertex("San Francisco")
        val washingtonDC = sut.createVertex("Washington DC")
        val austinTexas = sut.createVertex("Austin Texas")
        val seattle = sut.createVertex("Seattle")

        // Adding all the edges
        sut.add(EdgeType.UNDIRECTED, singapore, hongKong, 300.0)
        sut.add(EdgeType.UNDIRECTED, singapore, tokyo, 500.0)
        sut.add(EdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
        sut.add(EdgeType.UNDIRECTED, tokyo, detroit, 450.0)
        sut.add(EdgeType.UNDIRECTED, tokyo, washingtonDC, 300.0)
        sut.add(EdgeType.UNDIRECTED, hongKong, sanFrancisco, 600.0)
        sut.add(EdgeType.UNDIRECTED, detroit, austinTexas, 50.0)
        sut.add(EdgeType.UNDIRECTED, austinTexas, washingtonDC, 292.0)
        sut.add(EdgeType.UNDIRECTED, sanFrancisco, washingtonDC, 337.0)
        sut.add(EdgeType.UNDIRECTED, washingtonDC, seattle, 277.0)
        sut.add(EdgeType.UNDIRECTED, sanFrancisco, seattle, 218.0)
        sut.add(EdgeType.UNDIRECTED, austinTexas, sanFrancisco, 297.0)

        assertEquals(
            sut.toString(), "Detroit ---> [ Tokyo, Austin Texas ]\n" +
                    "Hong Kong ---> [ Singapore, Tokyo, San Francisco ]\n" +
                    "Singapore ---> [ Hong Kong, Tokyo ]\n" +
                    "Washington DC ---> [ Tokyo, Austin Texas, San Francisco, Seattle ]\n" +
                    "Tokyo ---> [ Singapore, Hong Kong, Detroit, Washington DC ]\n" +
                    "Austin Texas ---> [ Detroit, Washington DC, San Francisco ]\n" +
                    "San Francisco ---> [ Hong Kong, Washington DC, Seattle, Austin Texas ]\n" +
                    "Seattle ---> [ Washington DC, San Francisco ]\n"
        )

        val visitedVerticesDFS = sut.depthFirstSearch(seattle)
        assertEquals(visitedVerticesDFS[7].data, "Detroit")
        assertEquals(visitedVerticesDFS[5].data, "San Francisco")
        assertEquals(visitedVerticesDFS[1].data, "Washington DC")
        assertEquals(visitedVerticesDFS[0].data, "Seattle")
        assertEquals(visitedVerticesDFS[2].data, "Tokyo")
        assertEquals(visitedVerticesDFS[4].data, "Hong Kong")
        assertEquals(visitedVerticesDFS[6].data, "Austin Texas")
        assertEquals(visitedVerticesDFS[3].data, "Singapore")


    }
}