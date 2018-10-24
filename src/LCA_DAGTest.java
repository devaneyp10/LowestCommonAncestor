import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCA_DAGTest {

	@Test
	void testConstructor() {
		LCA_DAG dag1 = new LCA_DAG(6);
		assertEquals("Testing Constructor", 6, dag1.V);
		try {
			LCA_DAG dag2 = new LCA_DAG(-1);
		} catch (IllegalArgumentException e) {
			// expected
		}

	}

	@Test
	void testV() {
		LCA_DAG dag1 = new LCA_DAG(5);
		int v = dag1.V();
		assertEquals("Testing V()", 5, v);
	}

	@Test
	void testEandAddEdge() {
		LCA_DAG dag1 = new LCA_DAG(4);
		dag1.addEdge(1, 2);
		dag1.addEdge(2, 3);
		dag1.addEdge(3, 1);
		int e = dag1.E();
		assertEquals("Testing E() and addEdge()", e, 3);

		// test validateVertex exception
		try {
			dag1.addEdge(5, 4);
		} catch (IllegalArgumentException e1) {
			// catch exception
		}

	}

	@Test
	void testAcyclic() {
		LCA_DAG dag1 = new LCA_DAG(5);
		dag1.addEdge(1, 3);
		dag1.addEdge(1, 4);
		dag1.addEdge(3, 4);
		dag1.addEdge(2, 3);
		dag1.isAcyclic();
		assertTrue("Check for acyclic", dag1.checkDAG);
		// create cycle and check again
		dag1.addEdge(3, 4);
		dag1.addEdge(4, 1);
		dag1.isAcyclic();
		assertFalse("Confirm cycle has been created(no longer acyclic)", dag1.checkDAG);

	}

	@Test
	void testLCA() {
		//test LCA on empty graph
		LCA_DAG empty = new LCA_DAG(200);
		assertEquals("Testing LCA on empty graph.",empty.LCA(1, 3),-1);

		LCA_DAG dag1 = new LCA_DAG(8);
		dag1.addEdge(1, 2);
		dag1.addEdge(1, 3);
		dag1.addEdge(2, 4);
		dag1.addEdge(2, 5);
		dag1.addEdge(5, 7);
		dag1.addEdge(3, 6);
		assertEquals("Assert LCA(2,3) is 1", dag1.LCA(2, 3), 1);
		assertEquals("Assert LCA(4,7) is 2", dag1.LCA(4, 7), 2);
		assertEquals("Assert LCA(7,6) is 1", dag1.LCA(7, 6), 1);
		
		//try LCA on graph that isn't acyclic
		dag1.addEdge(2, 3);
		dag1.addEdge(3, 1);
		assertEquals("Testing LCA on non-acyclic graph.",dag1.LCA(1, 3),-1);
		
		//Test when there are no common Ancestors
		LCA_DAG dag2 = new LCA_DAG(7);
		dag2.addEdge(1, 5);
		dag2.addEdge(2, 4);
		dag2.addEdge(4, 5);
		dag2.addEdge(3, 6);
		assertEquals("Testing LCA with no common ancestors.",dag2.LCA(1, 3),-1);





		
	}

}
