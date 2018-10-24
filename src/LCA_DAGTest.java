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

}
