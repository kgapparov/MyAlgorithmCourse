package lessons_from_class.problem10;

import java.util.*;

/**
 * This extension of DFS successfully outputs a topological ordering
 * as long as input graph is a DAG. If every vertex is reachable
 * from the starting vertex, the output will be a topological ordering
 * of the entire graph; if not, it will be a topological ordering
 * of all vertices in the graph that are reachable from the starting
 * vertex.  (As mentioned in the slides, this approach can be improved
 * so that all vertices are output in topologically sorted order.)
 * 
 * IMPLEMENT
 */
public class TopologicalSort extends DepthFirstSearch {
	private Vertex[] sortedVertices;
	private Vertex topSortStartVertex = null;
	public Vertex getTopSortStartVertex() {
		return topSortStartVertex;
	}
	private int size = 0;
	/**
	 * Assumption: g is a DAG. If not, there is no guarantee concerning
	 * the nature of the output.
	 */
	public TopologicalSort(Digraph g) {
		super(g);
		computeTopStartVertex();
		//implement
		size = g.vertices.size();
		sortedVertices = new Vertex[size];
		start(topSortStartVertex);
	}
	public List<Vertex> getTopologicalOrdering() {
		//warning: will return null until this class has been implemented!
		return Arrays.asList(sortedVertices);
	}
	
	/**
	 * Finds, if possible, a vertex that has no in-vertices and sets this value
	 * in topSortStartVertex
	 * If not found, throws an IllegalStateException, indicating that
	 * the input graph is not a DAG. 
	 */
	public void computeTopStartVertex() {
		//implement
		Vertex v = nextUnvisited();
		while (v != null) {
			if (super.graph.getInVertices(v).size() == 0) {
				break;
			}
			v = nextUnvisited();
		}
		topSortStartVertex = v;
	}

	@Override
	protected void processVertex(Vertex w) {
		super.processVertex(w);
		if (size > 0)
			sortedVertices[size-- -1] = w;
	}

	public static void main(String[] args) {
		List<Pair> l = new ArrayList<Pair>();
		l.add(new Pair("A","B"));
		l.add(new Pair("B","C"));
		l.add(new Pair("A","D"));
		//l.add(new Pair("B","D"));
		Digraph g = new Digraph(l);
		TopologicalSort ts = new TopologicalSort(g);
		ts.computeTopStartVertex();
		System.out.println(ts.getTopologicalOrdering());
	}

}
