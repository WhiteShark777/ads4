import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        this.graph = graph;
        dijkstra();
    }

    private void dijkstra() {
        Map<V, Double> distances = new HashMap<>();
        for (Vertex<V> vertex : graph.getVertices()) {
            distances.put(vertex.getData(), Double.POSITIVE_INFINITY);
        }
        distances.put(source, 0.0);

        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        priorityQueue.offer(new Vertex<>(source));

        while (!priorityQueue.isEmpty()) {
            Vertex<V> currentVertex = priorityQueue.poll();
            V currentData = currentVertex.getData();

            if (marked.contains(currentData)) {
                continue;
            }
            marked.add(currentData);

            for (Map.Entry<Vertex<V>, Double> neighborEntry : currentVertex.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                V neighborData = neighbor.getData();
                double newDistance = distances.get(currentData) + neighborEntry.getValue();

                if (newDistance < distances.get(neighborData)) {
                    distances.put(neighborData, newDistance);
                    edgeTo.put(neighborData, currentData);
                    priorityQueue.offer(neighbor);
                }
            }
        }
    }
}
