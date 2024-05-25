import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private Set<Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new HashSet<>();
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        if (!vertices.contains(source) || !vertices.contains(destination)) {
            throw new IllegalArgumentException("Source or destination vertex not found in the graph.");
        }
        source.addAdjacentVertex(destination, weight);
        destination.addAdjacentVertex(source, weight);
    }

    public Set<Vertex<V>> getVertices() {
        return vertices;
    }
}
