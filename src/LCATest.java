import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCATest {

	@Test
	void testLCA() {
		LCA tree = new LCA();
		assertNull("Testing empty tree", tree.root);
		tree.root = new Node(3);
		tree.root.left = new Node(4);
		tree.root.right = new Node(5);
		assertEquals("Assert data value correct:",3,tree.root.data);
		assertEquals("Assert data value correct:",4,tree.root.left.data);
		assertEquals("Assert data value correct:",5,tree.root.right.data);
		
	}
	
	@Test
	void testFindPath() {
		LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        
        assertEquals("Find LCA(4,5). Answer should be 2.",tree.findLCA(4,5),2);
        assertEquals("Find LCA(4,6). Answer should be 1.",tree.findLCA(4,6),1);
        assertEquals("Find LCA(3,4). Answer should be 1.",tree.findLCA(3,4),1);
        assertEquals("Find LCA(2,4). Answer should be 2.",tree.findLCA(2,4),2);
        assertEquals("Find LCA of absent node",tree.findLCA(8, 7),-1);
        
        LCA tree2 = new LCA();
        tree.root.left = new Node(5);
        assertEquals("Find on tree with no root.",tree.findLCA(5, 0),-1);
        
 
	}
	
	
	

}
