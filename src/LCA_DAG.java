import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LCA_DAG {
	/*
	 * Used Sedgewick and Wayne's Digraph java class
	 */
	private final int V;
	private int E;
	private ArrayList<Integer>[] adj;
	private int[] indegree;
	public boolean isDAG;
	public boolean[] marked;
	public boolean[] stack;

	/**
	 * Initializes an empty digraph with <em>V</em> vertices.
	 *
	 * @param V
	 *            the number of vertices
	 * @throws IllegalArgumentException
	 *             if {@code V < 0}
	 */
	public LCA_DAG(int V) {
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();

		}
		isDAG = true;
		marked = new boolean[V];
		stack = new boolean[V];
	}

	/**
	 * Returns the number of vertices in this digraph.
	 *
	 * @return the number of vertices in this digraph
	 */
	public int V() {
		return V;
	}

	/**
	 * Returns the number of edges in this digraph.
	 *
	 * @return the number of edges in this digraph
	 */
	public int E() {
		return E;
	}

	/**
	 * Adds the directed edge v-w to this digraph.
	 *
	 * @param v
	 *            the tail vertex
	 * @param w
	 *            the head vertex
	 * @throws IllegalArgumentException
	 *             unless both {@code 0 <= v < V} and {@code 0 <= w < V}
	 */
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);
		indegree[w]++;
		E++;
	}

	// throw an IllegalArgumentException unless {@code 0 <= v < V}
	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));

	}

	/**
	 * Returns the vertices adjacent from vertex {@code v} in this digraph.
	 *
	 * @param v
	 *            the vertex
	 * @return the vertices adjacent from vertex {@code v} in this digraph, as an
	 *         iterable
	 * @throws IllegalArgumentException
	 *             unless {@code 0 <= v < V}
	 */
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}


}
