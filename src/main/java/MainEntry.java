import graph.AdjacencyMatrix;

/**
 * @author Hojat Ghasemi,
 * 2022-03-11
 * https://github.com/hojat72elect
 */
public class MainEntry {

    public static void main(String[] args) {

        AdjacencyMatrix g = new AdjacencyMatrix(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.print(g.toString());

    }
}
