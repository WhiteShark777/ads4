import java.util.List;

public class Main {

    public static void main(String[] args) {

        WeightedGraph<String> weightedGraph = new WeightedGraph<>();
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");

        System.out.println("Breadth First Paths:");
        Search<String> bfs = new BreadthFirstSearch<>(weightedGraph, "Almaty");
        outputPath(bfs, "Kyzylorda");
        outputPath(bfs, "Atyrau");
        outputPath(bfs, "Kostanay");
    }

    private static void outputPath(Search<String> search, String key) {
        if (search.hasPathTo(key)) {
            System.out.print(key + " <- ");
            for (String v : search.pathTo(key)) {
                System.out.print(v + " ");
            }
            System.out.println();
        } else {
            System.out.println("no path to " + key);
        }
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> shymkent = new Vertex<>("Shymkent");
        Vertex<String> atyrau = new Vertex<>("Atyrau");
        Vertex<String> kostanay = new Vertex<>("Kostanay");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");

        graph.addVertex(almaty);
        graph.addVertex(astana);
        graph.addVertex(shymkent);
        graph.addVertex(atyrau);
        graph.addVertex(kostanay);
        graph.addVertex(kyzylorda);

        graph.addEdge(almaty, astana, 2.1);
        graph.addEdge(shymkent, atyrau, 7.8);
        graph.addEdge(atyrau, astana, 7.1);
        graph.addEdge(almaty, shymkent, 7.2);
        graph.addEdge(shymkent, astana, 3.9);
        graph.addEdge(astana, kostanay, 3.5);
        graph.addEdge(shymkent, kyzylorda, 5.4);
    }
}
