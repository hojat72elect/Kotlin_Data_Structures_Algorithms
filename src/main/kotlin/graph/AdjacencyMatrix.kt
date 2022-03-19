package graph

/**
 * @author Hojat Ghasemi,
 * 2022-03-19
 * https://github.com/hojat72elect
 */
// Adjacency Matrix representation in Kotlin
class AdjacencyMatrix(private val numVertices: Int) {
    private val adjMatrix: Array<BooleanArray> = Array(numVertices) { BooleanArray(numVertices) }

    // Add edges
    fun addEdge(i: Int, j: Int) {
        adjMatrix[i][j] = true
        adjMatrix[j][i] = true
    }

    // Remove edges
    fun removeEdge(i: Int, j: Int) {
        adjMatrix[i][j] = false
        adjMatrix[j][i] = false
    }

    // Print the matrix
    override fun toString(): String {
        val s = StringBuilder()
        for (i in 0 until numVertices) {
            s.append("$i: ")
            for (j in adjMatrix[i]) {
                s.append((if (j) 1 else 0).toString() + " ")
            }
            s.append("\n")
        }
        return s.toString()
    }
}