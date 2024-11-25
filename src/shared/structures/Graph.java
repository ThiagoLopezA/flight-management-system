package shared.structures;

import java.util.HashMap;
import java.util.Map;

/**
 * A generic implementation of a directed weighted graph.
 * The graph supports adding vertices, edges with costs (weights), retrieving
 * neighbors, and
 * printing the graph in a user-friendly format.
 *
 * @param <T> the type of elements stored in the graph (e.g., cities, flights,
 *            etc.)
 */
public class Graph<T> {
  private final Map<T, Map<T, Integer>> adjacencyList; // Adjacency list representation of the graph

  /**
   * Constructs an empty graph.
   * Initializes the adjacency list for storing vertices and edges.
   */
  public Graph() {
    this.adjacencyList = new HashMap<>();
  }

  /**
   * Adds a vertex to the graph.
   * If the vertex already exists, it will not be added again.
   *
   * @param vertex the vertex to add to the graph
   */
  public void addVertex(T vertex) {
    adjacencyList.putIfAbsent(vertex, new HashMap<>());
  }

  /**
   * Adds a directed edge between two vertices with a specified cost (weight).
   * If the vertices do not exist, they will be added to the graph.
   *
   * @param from the starting vertex of the edge
   * @param to   the ending vertex of the edge
   * @param cost the cost (weight) associated with the edge
   */
  public void addEdge(T from, T to, int cost) {
    adjacencyList.computeIfAbsent(from, k -> new HashMap<>()).put(to, cost);
  }

  /**
   * Retrieves the cost (weight) of the edge between two vertices.
   *
   * @param from the starting vertex of the edge
   * @param to   the ending vertex of the edge
   * @return the cost of the edge, or null if no such edge exists
   */
  public Integer getCost(T from, T to) {
    return adjacencyList.getOrDefault(from, new HashMap<>()).get(to);
  }

  /**
   * Retrieves the neighbors of a specific vertex along with the costs of the
   * edges to those neighbors.
   *
   * @param vertex the vertex whose neighbors are to be retrieved
   * @return a map of neighboring vertices and their associated edge costs
   */
  public Map<T, Integer> getNeighbors(T vertex) {
    return adjacencyList.getOrDefault(vertex, new HashMap<>());
  }

  /**
   * Retrieves all the vertices in the graph.
   *
   * @return a collection of all vertices in the graph
   */
  public Map<T, Map<T, Integer>> getVertices() {
    return adjacencyList;
  }

  /**
   * Prints a user-friendly representation of the graph.
   * Each vertex and its outgoing edges are displayed as a group.
   * The format is:
   * Vertex -> { Destination1 (Cost: X), Destination2 (Cost: Y), ... }
   */
  public void printGraph() {
    System.out.println("Graph Representation:");
    adjacencyList.forEach((from, edges) -> {
      StringBuilder representation = new StringBuilder();
      representation.append(from).append(" -> { ");
      edges.forEach((to, cost) -> {
        representation.append(to).append("), ");
      });

      // Remove the trailing comma and space, then close the braces
      if (!edges.isEmpty()) {
        representation.setLength(representation.length() - 2);
      }
      representation.append(" }");

      System.out.println(representation);
    });
  }
}
