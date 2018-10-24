import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCA_DAGTest {

	@Test
	void testConstructor() {
		LCA_DAG dag1 = new LCA_DAG(6);
		assertEquals("Testing Constructor",6,dag1.V);
		try {
			LCA_DAG dag2 = new LCA_DAG(-1);
		}catch(IllegalArgumentException e) {
			//expected
		} 
		
	} 
	
	@Test
	void testV() {
		LCA_DAG dag1 = new LCA_DAG(5);
		int v = dag1.V();
		assertEquals("Testing V()",5,v);	
	}
 
	@Test
	void testE() {
		LCA_DAG dag1 = new LCA_DAG(4);
		dag1.addEdge(1, 2);
		dag1.addEdge(2, 3);
		dag1.addEdge(3, 1);
		int e = dag1.E();
		assertEquals("Testing E() and addEdge()",e,3);
		
		//test validateVertex exception
		try {
			dag1.addEdge(5, 4);
		}catch(IllegalArgumentException e1) {
			//catch exception
		}
		
	}
}
