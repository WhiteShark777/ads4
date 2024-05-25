import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        bfs(graph, new Vertex<>(source)); // Use a dummy vertex to hold source data
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> sourceVertex) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        marked.add(sourceVertex.getData());
        queue.offer(sourceVertex);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            for (Vertex<V> neighbor : currentVertex.getAdjacentVertices().keySet()) {
                V neighborData = neighbor.getData();
                if (!marked.contains(neighborData)) {
                    edgeTo.put(neighborData, currentVertex.getData());
                    marked.add(neighborData);
                    queue.offer(neighbor);
                }
            }
        }
    }
}
