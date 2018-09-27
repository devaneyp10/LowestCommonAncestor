import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCATest {

	@Test
	void testLCA() {
		LCA tree = new LCA();
		tree.root = new Node(3);
		tree.root.left = new Node(4);
		tree.root.right = new Node(5);
		assertEquals("Assert data value correct:",3,tree.root.data);
		assertEquals("Assert data value correct:",4,tree.root.left.data);
		assertEquals("Assert data value correct:",5,tree.root.right.data);

	}

	

}
