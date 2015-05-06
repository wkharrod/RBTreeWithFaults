/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbtreewithfaults;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author William
 */
public class RBTreeWithFaultsTest {
    
    public RBTreeWithFaultsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of getRoot() method - 1, of class RBTreeWithFaults.
     */
    @Test
    public void testGetRoot1() {
        System.out.println("getRoot - 1");
        Boolean debugging = false;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode testRoot = tree.getRoot();
        
        if(debugging) System.out.println("root left == "+ tree.Root.Left.Value);
        assertEquals(tree.Root.Left, testRoot);
    }
    
     /**
     * Test of  createInfinityNode() - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testCreateInfinityNodeNoArgument1() {
        System.out.println("createInfinityNode - 1");
        Boolean debugging = false;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        RBTreeWithFaults.RBNode infinityNode =  tree.createInfinityNode();
     
        if(debugging) System.out.println("infinityNode.key == "+infinityNode.Key);
        assertTrue((infinityNode.Key == Integer.MAX_VALUE));
    }
    
     /**
     * Test of  createInfinityNode(RBNode leftchild) - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testCreateInfinityNodeWithArgument1() {
        System.out.println("createInfinityNode - 1");
        Boolean debugging = false;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        RBTreeWithFaults.RBNode node = tree.new RBNode("node", 1, null);
        RBTreeWithFaults.RBNode infinityNode =  tree.createInfinityNode(node);
     
        if(debugging) System.out.println("infinityNode.key == "+infinityNode.Key);
        assertTrue((infinityNode.Key == Integer.MAX_VALUE));
    }
    
    /**
    * Test of  createNullNode(RBNode parent) - 1 method, of class RBTreeWithFaults.
    */
    @Test
    public void testcreateNullNode1() {
        System.out.println("createNullNode - 1");
        Boolean debugging = false;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        RBTreeWithFaults.RBNode nullRoot = tree.createNullNode(tree.Root);
     
        if(debugging) System.out.println("nullRoot.left == null");
        if(debugging) System.out.println("nullRoot.Right == null");
        assertEquals(nullRoot.Right, null);
        assertEquals(nullRoot.Left, null);
        if(debugging) System.out.println("nullRoot.Value == " +nullRoot.Value);
        assertEquals(nullRoot.Value, "N");
        if(debugging) System.out.println("nullRoot.Parent == " +nullRoot.Parent.Value);
        assertEquals(nullRoot.Parent, tree.Root);
    }
    
    /**
    * Test of  empty() - 1 method, of class RBTreeWithFaults.
    */
    @Test
    public void testempty1() {
        System.out.println("empty - 1");
        Boolean debugging = false;
        RBTreeWithFaults tree = new RBTreeWithFaults();
     
        if(debugging) System.out.println("tree.empty() == "+ tree.empty());
        assertTrue(tree.empty());
    }
    
    /**
    * Test of search(int k) - 1 method, of class RBTreeWithFaults.
    */
    @Test
    public void testSearch1() {
        System.out.println("search - 1");
        Boolean debugging = false;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        if(debugging) System.out.println("tree.search(8) = "+ tree.search(8));
        assertEquals(tree.search(8), null);
    }
    /**
    * Test of search(int k) - 2 method, of class RBTreeWithFaults.
    */
    @Test
    public void testSearch2() {
        System.out.println("search - 2");
        Boolean debugging = false;
       
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode zParentParent = tree.new RBNode("zParentParent", i++, root);
        zParentParent.Black = false;
        root.Right = zParentParent;

        
        RBTreeWithFaults.RBNode zParent = tree.new RBNode("zParent", i++, zParentParent);
        zParent.Black = false;
        zParentParent.Right = zParent;
        
        RBTreeWithFaults.RBNode y = tree.new RBNode("y",i++,zParentParent);
        y.Black = true;
        zParentParent.Left = y;
        
        RBTreeWithFaults.RBNode z = tree.new RBNode("z", i++, zParent);
        z.Black = false;
        zParent.Right = z;
        
        if(debugging) System.out.println("tree.search(8) = "+ tree.search(8));
        assertEquals(tree.search(8), null);
    }
    
    /**
    * Test of search(int k) - 3 method, of class RBTreeWithFaults.
    */
    @Test
    public void testSearch3() {
        System.out.println("search - 3");
        Boolean debugging = false;
       
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode zParentParent = tree.new RBNode("zParentParent", i++, root);
        zParentParent.Black = false;
        root.Right = zParentParent;

        
        RBTreeWithFaults.RBNode zParent = tree.new RBNode("zParent", i++, zParentParent);
        zParent.Black = false;
        zParentParent.Right = zParent;
        
        RBTreeWithFaults.RBNode y = tree.new RBNode("y",i++,zParentParent);
        y.Black = true;
        zParentParent.Left = y;
        
        RBTreeWithFaults.RBNode z = tree.new RBNode("z", i++, zParent);
        z.Black = false;
        zParent.Right = z;
        
        if(debugging) System.out.println("tree.search(2) = "+ zParentParent.Value);
        assertEquals(tree.search(2), zParentParent.Value);
    }
    
    /**
    * Test of SearchNode(int k,RBNode node) - 1 method, of class RBTreeWithFaults.
    */
    @Test
    public void testSearchNode1() {
        System.out.println("SearchNode - 1");
        Boolean debugging = false;
       
        RBTreeWithFaults tree = new RBTreeWithFaults();
        RBTreeWithFaults.RBNode infinityNode = tree.createInfinityNode();
        
        RBTreeWithFaults.RBNode result = tree.SearchNode(0, infinityNode);
        
        if(debugging) System.out.println("result == null");
        assertEquals(result, null);
    }
    
    /**
    * Test of SearchNode(int k,RBNode node) - 2 method, of class RBTreeWithFaults.
    */
    @Test
    public void testSearchNode2() {
        System.out.println("SearchNode - 2");
        Boolean debugging = false;
       
        RBTreeWithFaults tree = new RBTreeWithFaults();
        RBTreeWithFaults.RBNode nullNode = tree.createNullNode(tree.Root);
        
        RBTreeWithFaults.RBNode result = tree.SearchNode(0, nullNode);
        
        if(debugging) System.out.println("result == null");
        assertEquals(result, null);
    }
    
    /**
    * Test of SearchNode(int k,RBNode node) - 3 method, of class RBTreeWithFaults.
    */
    @Test
    public void testSearchNode3() {
        System.out.println("SearchNode - 3");
        Boolean debugging = false;
       
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, tree.Root);
        root.Black = true;
        tree.Root.Left = root;
        
        RBTreeWithFaults.RBNode nullNode = tree.createNullNode(root);
        
        RBTreeWithFaults.RBNode result = tree.SearchNode(0, nullNode);
        
        if(debugging) System.out.println("result == " + result.Value);
        assertEquals(result, root);
    }
    
    /**
    * Test of SearchNode(int k,RBNode node) - 4 method, of class RBTreeWithFaults.
    */
    @Test
    public void testSearchNode4() {
        System.out.println("SearchNode - 4");
        Boolean debugging = false;
       
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, tree.Root);
        root.Black = true;
        tree.Root.Left = root;
        
        RBTreeWithFaults.RBNode left = tree.new RBNode("left", i++, root);
        left.Black = true;
        root.Left = left;
        
        RBTreeWithFaults.RBNode result = tree.SearchNode(1, left);
        
        if(debugging) System.out.println("result == " + result.Value);
        assertEquals(result, left);
    }
    
    /**
    * Test of SearchNode(int k,RBNode node) - 5 method, of class RBTreeWithFaults.
    */
    @Test
    public void testSearchNode5() {
        System.out.println("SearchNode - 5");
        Boolean debugging = false;
       
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, tree.Root);
        root.Black = true;
        tree.Root.Left = root;
        
        RBTreeWithFaults.RBNode left = tree.new RBNode("left", i++, root);
        left.Black = true;
        root.Left = left;
        
        RBTreeWithFaults.RBNode result = tree.SearchNode(3, left);
        
        if(debugging) System.out.println("result == " + result.Value);
        assertEquals(result, left);
    }
    
    /**
    * Test of SearchNode(int k,RBNode node) - 6 method, of class RBTreeWithFaults.
    */
    @Test
    public void testSearchNode6() {
        System.out.println("SearchNode - 6");
        Boolean debugging = false;
       
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, tree.Root);
        root.Black = true;
        tree.Root.Left = root;
        
        RBTreeWithFaults.RBNode left = tree.new RBNode("left", i++, root);
        left.Black = true;
        root.Left = left;
        
        RBTreeWithFaults.RBNode result = tree.SearchNode(2, left);
        
        if(debugging) System.out.println("result == " + result.Value);
        assertEquals(result, left);
    }
    
    /**
    * Test of insert(int k, String v) - 1  method, of class RBTreeWithFaults.
    */
    @Test
    public void testInsert1() {
        System.out.println("insert - 1");
        Boolean debugging = false;
       
        RBTreeWithFaults tree = new RBTreeWithFaults();
        int result = tree.insert(1, "result");
        
        if(debugging) System.out.println("result == " + result);
        assertEquals(result, 0);
    }
    
    /**
    * Test of insert(int k, String v) - 2  method, of class RBTreeWithFaults.
    */
    @Test
    public void testInsert2() {
        System.out.println("insert - 2");
        Boolean debugging = false;
       
        RBTreeWithFaults tree = new RBTreeWithFaults();
        tree.insert(1, "firstInsert");
        int result = tree.insert(1, "result");
        
        if(debugging) System.out.println("result == " + result);
        assertEquals(result, -1);
    }
    
    /**
    * Test of insert(int k, String v) - 3  method, of class RBTreeWithFaults.
    */
    @Test
    public void testInsert3() {
        System.out.println("insert - 3");
        Boolean debugging = false;
       
        RBTreeWithFaults tree = new RBTreeWithFaults();
        tree.insert(1, "firstInsert");
        int result = tree.insert(0, "result");
        
        if(debugging) System.out.println("result == " + result);
        assertEquals(result, 0);
    }
    
    /**
    * Test of insert(int k, String v) - 4  method, of class RBTreeWithFaults.
    */
    @Test
    public void testInsert4() {
        System.out.println("insert - 4");
        Boolean debugging = false;
       
        RBTreeWithFaults tree = new RBTreeWithFaults();
        tree.insert(1, "firstInsert");
        int result = tree.insert(2, "result");
        
        if(debugging) System.out.println("result == " + result);
        assertEquals(result, 0);
    }
    
    /**
     * Test of fixUpTree - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testFixUpTree1()
    {
        Boolean debugging = false;
        System.out.println("fixUpTree - 1");
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode zParentParent = tree.new RBNode("zParentParent", i++, root);
        zParentParent.Black = false;
        root.Left = zParentParent;

        
        RBTreeWithFaults.RBNode zParent = tree.new RBNode("zParent", i++, zParentParent);
        zParent.Black = false;
        zParentParent.Left = zParent;
        
        RBTreeWithFaults.RBNode y = tree.new RBNode("y",i++,zParentParent);
        y.Black = false;
        zParentParent.Right = y;
        
        RBTreeWithFaults.RBNode z = tree.new RBNode("z", i++, zParent);
        z.Black = true;
        zParent.Left = z;

        
        int result = tree.fixUpTree(z);
        
        if(debugging) System.out.println("result = "+result);
        int expResult = 4;
        assertEquals(expResult, result);
        
        if(debugging) System.out.println("tree.Root.Value = "+tree.Root.Value);
        assertEquals(tree.Root.Value, "root");
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        
        assertEquals(root.Left.Value, "zParentParent");

        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("zParentParent.Black = "+zParentParent.Black);
        assertEquals(zParentParent.Black, true);
        if(debugging) System.out.println("zParentParent.Left.Value = "+zParentParent.Left.Value);
        if(debugging) System.out.println("zParent.Right.Value = "+zParentParent.Right.Value);
        assertEquals(zParentParent.Left.Value, "zParent");
        assertEquals(zParentParent.Right.Value, "y");
        if(debugging) System.out.println("zParent.Parent = "+zParent.Parent.Value);
        assertEquals(zParentParent.Parent.Value, "root");
 
        if(debugging) System.out.println("zParent.Black = "+zParent.Black);
        assertEquals(zParent.Black, true);
        if(debugging) System.out.println("zParent.Left.Value = "+zParent.Left.Value);
        assertEquals(zParent.Left.Value, "z");

        if(debugging) System.out.println("zParent.Parent = "+zParent.Parent.Value);
        assertEquals(zParent.Parent.Value, "zParentParent");
       
        if(debugging) System.out.println("z.Black = "+z.Black);
        assertEquals(z.Black, true);

        if(debugging) System.out.println("z.Parent = "+z.Parent.Value);
        assertEquals(z.Parent.Value, "zParent");
        
        if(debugging) System.out.println("y.Black = "+y.Black);
        assertEquals(y.Black, true);

        if(debugging) System.out.println("y.Parent = "+y.Parent.Value);
        assertEquals(y.Parent.Value, "zParentParent");
        
    }
    
    /**
     * Test of fixUpTree - 3 method, of class RBTreeWithFaults.
     */
    @Test
    public void testFixUpTree3()
    {
        Boolean debugging = false;
        System.out.println("fixUpTree - 3");
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode zParentParent = tree.new RBNode("zParentParent", i++, root);
        zParentParent.Black = false;
        root.Left = zParentParent;

        
        RBTreeWithFaults.RBNode zParent = tree.new RBNode("zParent", i++, zParentParent);
        zParent.Black = false;
        zParentParent.Left = zParent;
        
        RBTreeWithFaults.RBNode y = tree.new RBNode("y",i++,zParentParent);
        y.Black = true;
        zParentParent.Right = y;
        
        RBTreeWithFaults.RBNode z = tree.new RBNode("z", i++, zParent);
        z.Black = true;
        zParent.Right = z;

        
        int result = tree.fixUpTree(z);
        
        if(debugging) System.out.println("result = "+result);
        int expResult = 2;
        assertEquals(expResult, result);
        
        if(debugging) System.out.println("tree.Root.Value = "+tree.Root.Value);
        assertEquals(tree.Root.Value, "root");
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        assertEquals(root.Left.Value, "z");
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("zParentParent.Black = "+zParentParent.Black);
        assertEquals(zParentParent.Black, false);
        if(debugging) System.out.println("zParentParent.Left.Value = "+zParentParent.Left.Value);
        if(debugging) System.out.println("zParentParent.Right.Value = "+zParentParent.Right.Value);
        assertEquals(zParentParent.Right.Value, "y");
        assertEquals(zParentParent.Left.Value, "N");
        if(debugging) System.out.println("zParentParent.Parent = "+zParentParent.Parent.Value);
        assertEquals(zParentParent.Parent.Value, "z");
 
        
        if(debugging) System.out.println("zParent.Black = "+zParent.Black);
        assertEquals(zParent.Black, false);
        if(debugging) System.out.println("zParent.Left.Value = "+zParent.Left.Value);
        if(debugging) System.out.println("zParent.Right.Value = "+zParent.Right.Value);
        assertEquals(zParent.Right.Value, "N");
        assertEquals(zParent.Left.Value, "N");

        if(debugging) System.out.println("zParent.Parent = "+zParent.Parent.Value);
        assertEquals(zParent.Parent.Value, "z");
       
        if(debugging) System.out.println("z.Black = "+z.Black);
        assertEquals(z.Black, true);
        if(debugging) System.out.println("z.Left.Value = "+z.Left.Value);
        if(debugging) System.out.println("z.Right.Value = "+z.Right.Value);
        assertEquals(z.Right.Value, "zParentParent");
        assertEquals(z.Left.Value, "zParent");
        if(debugging) System.out.println("z.Parent = "+z.Parent.Value);
        assertEquals(z.Parent.Value, "root");
        
        if(debugging) System.out.println("y.Black = "+y.Black);
        assertEquals(y.Black, true);

        if(debugging) System.out.println("y.Parent = "+y.Parent.Value);
        assertEquals(y.Parent.Value, "zParentParent");
        
    }
    /**
    * Test of fixUpTree - 2 method, of class RBTreeWithFaults.
    */
    @Test
    public void testFixUpTree2()
    {
        Boolean debugging = false;
        System.out.println("fixUpTree - 2");
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode zParentParent = tree.new RBNode("zParentParent", i++, root);
        zParentParent.Black = false;
        root.Left = zParentParent;

        
        RBTreeWithFaults.RBNode zParent = tree.new RBNode("zParent", i++, zParentParent);
        zParent.Black = false;
        zParentParent.Left = zParent;
        
        RBTreeWithFaults.RBNode y = tree.new RBNode("y",i++,zParentParent);
        y.Black = true;
        zParentParent.Right = y;
        
        RBTreeWithFaults.RBNode z = tree.new RBNode("z", i++, zParent);
        z.Black = true;
        zParent.Left = z;

        
        int result = tree.fixUpTree(z);
        
        if(debugging) System.out.println("result = "+result);
        int expResult = 2;
        assertEquals(expResult, result);
        
        if(debugging) System.out.println("tree.Root.Value = "+tree.Root.Value);
        assertEquals(tree.Root.Value, "root");
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        assertEquals(root.Left.Value, "zParent");
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("zParentParent.Black = "+zParentParent.Black);
        assertEquals(zParentParent.Black, false);
        if(debugging) System.out.println("zParentParent.Left.Value = "+zParentParent.Left.Value);
        if(debugging) System.out.println("zParentParent.Right.Value = "+zParentParent.Right.Value);
        assertEquals(zParentParent.Right.Value, "y");
        assertEquals(zParentParent.Left.Value, "N");
        if(debugging) System.out.println("zParentParent.Parent = "+zParentParent.Parent.Value);
        assertEquals(zParentParent.Parent.Value, "zParent");
 
        
        if(debugging) System.out.println("zParent.Black = "+zParent.Black);
        assertEquals(zParent.Black, true);
        if(debugging) System.out.println("zParent.Left.Value = "+zParent.Left.Value);
        if(debugging) System.out.println("zParent.Right.Value = "+zParent.Right.Value);
        assertEquals(zParent.Right.Value, "zParentParent");
        assertEquals(zParent.Left.Value, "z");

        if(debugging) System.out.println("zParent.Parent = "+zParent.Parent.Value);
        assertEquals(zParent.Parent.Value, "root");
       
        if(debugging) System.out.println("z.Black = "+z.Black);
        assertEquals(z.Black, true);
        if(debugging) System.out.println("z.Left.Value = "+z.Left.Value);
        if(debugging) System.out.println("z.Right.Value = "+z.Right.Value);
        assertEquals(z.Right.Value, "N");
        assertEquals(z.Left.Value, "N");
        if(debugging) System.out.println("z.Parent = "+z.Parent.Value);
        assertEquals(z.Parent.Value, "zParent");
        
        if(debugging) System.out.println("y.Black = "+y.Black);
        assertEquals(y.Black, true);

        if(debugging) System.out.println("y.Parent = "+y.Parent.Value);
        assertEquals(y.Parent.Value, "zParentParent");
        
    }
    
    /**
     * Test of fixUpTree - 4 method, of class RBTreeWithFaults.
     */
    @Test
    public void testFixUpTree4()
    {
        Boolean debugging = false;
        System.out.println("fixUpTree - 4");
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode zParentParent = tree.new RBNode("zParentParent", i++, root);
        zParentParent.Black = false;
        root.Left = zParentParent;

        
        RBTreeWithFaults.RBNode zParent = tree.new RBNode("zParent", i++, zParentParent);
        zParent.Black = false;
        zParentParent.Right = zParent;
        
        RBTreeWithFaults.RBNode y = tree.new RBNode("y",i++,zParentParent);
        y.Black = false;
        zParentParent.Left = y;
        
        RBTreeWithFaults.RBNode z = tree.new RBNode("z", i++, zParent);
        z.Black = true;
        zParent.Right = z;

        
        int result = tree.fixUpTree(z);
        
        if(debugging) System.out.println("result = "+result);
        int expResult = 4;
        assertEquals(expResult, result);
        
        if(debugging) System.out.println("tree.Root.Value = "+tree.Root.Value);
        assertEquals(tree.Root.Value, "root");
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        assertEquals(root.Left.Value, "zParentParent");
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("zParentParent.Black = "+zParentParent.Black);
        assertEquals(zParentParent.Black, true);
        if(debugging) System.out.println("zParentParent.Left.Value = "+zParentParent.Left.Value);
        if(debugging) System.out.println("zParentParent.Right.Value = "+zParentParent.Right.Value);
        assertEquals(zParentParent.Right.Value, "zParent");
        assertEquals(zParentParent.Left.Value, "y");
        if(debugging) System.out.println("zParentParent.Parent = "+zParentParent.Parent.Value);
        assertEquals(zParentParent.Parent.Value, "root");
 
        
        if(debugging) System.out.println("zParent.Black = "+zParent.Black);
        assertEquals(zParent.Black, true);
        if(debugging) System.out.println("zParent.Left.Value = "+zParent.Left.Value);
        if(debugging) System.out.println("zParent.Right.Value = "+zParent.Right.Value);
        assertEquals(zParent.Right.Value, "z");
        assertEquals(zParent.Left.Value, "N");

        if(debugging) System.out.println("zParent.Parent = "+zParent.Parent.Value);
        assertEquals(zParent.Parent.Value, "zParentParent");
       
        if(debugging) System.out.println("z.Black = "+z.Black);
        assertEquals(z.Black, true);
        if(debugging) System.out.println("z.Left.Value = "+z.Left.Value);
        if(debugging) System.out.println("z.Right.Value = "+z.Right.Value);
        assertEquals(z.Right.Value, "N");
        assertEquals(z.Left.Value, "N");
        if(debugging) System.out.println("z.Parent = "+z.Parent.Value);
        assertEquals(z.Parent.Value, "zParent");
        
        if(debugging) System.out.println("y.Black = "+y.Black);
        assertEquals(y.Black, true);

        if(debugging) System.out.println("y.Parent = "+y.Parent.Value);
        assertEquals(y.Parent.Value, "zParentParent");
        
    }
    
    /**
     * Test of fixUpTree - 5 method, of class RBTreeWithFaults.
     */
    @Test
    public void testFixUpTree5()
    {
        Boolean debugging = false;
        System.out.println("fixUpTree - 5");
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode zParentParent = tree.new RBNode("zParentParent", i++, root);
        zParentParent.Black = false;
        root.Right = zParentParent;

        
        RBTreeWithFaults.RBNode zParent = tree.new RBNode("zParent", i++, zParentParent);
        zParent.Black = false;
        zParentParent.Right = zParent;
        
        RBTreeWithFaults.RBNode y = tree.new RBNode("y",i++,zParentParent);
        y.Black = true;
        zParentParent.Left = y;
        
        RBTreeWithFaults.RBNode z = tree.new RBNode("z", i++, zParent);
        z.Black = false;
        zParent.Left = z;

        
        int result = tree.fixUpTree(z);
        
        if(debugging) System.out.println("result = "+result);
        int expResult = 2;
        assertEquals(expResult, result);
        
        if(debugging) System.out.println("tree.Root.Value = "+tree.Root.Value);
        assertEquals(tree.Root.Value, "root");
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        assertEquals(root.Left.Value, "N");
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Right.Value, "z");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("zParentParent.Black = "+zParentParent.Black);
        assertEquals(zParentParent.Black, false);
        if(debugging) System.out.println("zParentParent.Left.Value = "+zParentParent.Left.Value);
        if(debugging) System.out.println("zParentParent.Right.Value = "+zParentParent.Right.Value);
        assertEquals(zParentParent.Right.Value, "N");
        assertEquals(zParentParent.Left.Value, "y");
        if(debugging) System.out.println("zParentParent.Parent = "+zParentParent.Parent.Value);
        assertEquals(zParentParent.Parent.Value, "z");
 
        
        if(debugging) System.out.println("zParent.Black = "+zParent.Black);
        assertEquals(zParent.Black, false);
        if(debugging) System.out.println("zParent.Left.Value = "+zParent.Left.Value);
        if(debugging) System.out.println("zParent.Right.Value = "+zParent.Right.Value);
        assertEquals(zParent.Right.Value, "N");
        assertEquals(zParent.Left.Value, "N");

        if(debugging) System.out.println("zParent.Parent = "+zParent.Parent.Value);
        assertEquals(zParent.Parent.Value, "z");
       
        if(debugging) System.out.println("z.Black = "+z.Black);
        assertEquals(z.Black, true);
        if(debugging) System.out.println("z.Left.Value = "+z.Left.Value);
        if(debugging) System.out.println("z.Right.Value = "+z.Right.Value);
        assertEquals(z.Right.Value, "zParent");
        assertEquals(z.Left.Value, "zParentParent");
        if(debugging) System.out.println("z.Parent = "+z.Parent.Value);
        assertEquals(z.Parent.Value, "root");
        
        if(debugging) System.out.println("y.Black = "+y.Black);
        assertEquals(y.Black, true);

        if(debugging) System.out.println("y.Parent = "+y.Parent.Value);
        assertEquals(y.Parent.Value, "zParentParent");
        
    }
    
    /**
     * Test of fixUpTree - 6 method, of class RBTreeWithFaults.
     */
    @Test
    public void testFixUpTree6()
    {
        Boolean debugging = false;
        System.out.println("fixUpTree - 6");
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode zParentParent = tree.new RBNode("zParentParent", i++, root);
        zParentParent.Black = false;
        root.Right = zParentParent;

        
        RBTreeWithFaults.RBNode zParent = tree.new RBNode("zParent", i++, zParentParent);
        zParent.Black = false;
        zParentParent.Right = zParent;
        
        RBTreeWithFaults.RBNode y = tree.new RBNode("y",i++,zParentParent);
        y.Black = true;
        zParentParent.Left = y;
        
        RBTreeWithFaults.RBNode z = tree.new RBNode("z", i++, zParent);
        z.Black = false;
        zParent.Right = z;

        
        int result = tree.fixUpTree(z);
        
        if(debugging) System.out.println("result = "+result);
        int expResult = 2;
        assertEquals(expResult, result);
        
        if(debugging) System.out.println("tree.Root.Value = "+tree.Root.Value);
        assertEquals(tree.Root.Value, "root");
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        assertEquals(root.Left.Value, "N");
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Right.Value, "zParent");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("zParentParent.Black = "+zParentParent.Black);
        assertEquals(zParentParent.Black, false);
        if(debugging) System.out.println("zParentParent.Left.Value = "+zParentParent.Left.Value);
        if(debugging) System.out.println("zParentParent.Right.Value = "+zParentParent.Right.Value);
        assertEquals(zParentParent.Right.Value, "N");
        assertEquals(zParentParent.Left.Value, "y");
        if(debugging) System.out.println("zParentParent.Parent = "+zParentParent.Parent.Value);
        assertEquals(zParentParent.Parent.Value, "zParent");
 
        
        if(debugging) System.out.println("zParent.Black = "+zParent.Black);
        assertEquals(zParent.Black, true);
        if(debugging) System.out.println("zParent.Left.Value = "+zParent.Left.Value);
        if(debugging) System.out.println("zParent.Right.Value = "+zParent.Right.Value);
        assertEquals(zParent.Right.Value, "z");
        assertEquals(zParent.Left.Value, "zParentParent");

        if(debugging) System.out.println("zParent.Parent = "+zParent.Parent.Value);
        assertEquals(zParent.Parent.Value, "root");
       
        if(debugging) System.out.println("z.Black = "+z.Black);
        assertEquals(z.Black, false);
        if(debugging) System.out.println("z.Left.Value = "+z.Left.Value);
        if(debugging) System.out.println("z.Right.Value = "+z.Right.Value);
        assertEquals(z.Right.Value, "N");
        assertEquals(z.Left.Value, "N");
        if(debugging) System.out.println("z.Parent = "+z.Parent.Value);
        assertEquals(z.Parent.Value, "zParent");
        
        if(debugging) System.out.println("y.Black = "+y.Black);
        assertEquals(y.Black, true);

        if(debugging) System.out.println("y.Parent = "+y.Parent.Value);
        assertEquals(y.Parent.Value, "zParentParent");
        
    }
    
    /**
    * Test of leftChild(RBNode x,RBNode y) - 1  method, of class RBTreeWithFaults.
    */
    @Test
    public void testLeftChild1() {
        System.out.println("leftChild- 1");
        Boolean debugging = false;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        RBTreeWithFaults.RBNode root = tree.createNullNode(tree.Root);
        tree.leftChild(tree.Root, root);
        
        if(debugging) System.out.println("tree.Root.Left == "+ tree.Root.Left.Value);
        if(debugging) System.out.println("root.Parent == "+ root.Parent.Value);
        assertEquals(tree.Root.Left, root);
        assertEquals(root.Parent, tree.Root);
    }
    
    /**
    * Test of rightChild(RBNode x,RBNode y) - 1  method, of class RBTreeWithFaults.
    */
    @Test
    public void testRighttChild1() {
        System.out.println("rightChild- 1");
        Boolean debugging = false;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        RBTreeWithFaults.RBNode root = tree.createNullNode(tree.Root);
        tree.rightChild(tree.Root, root);
        
        if(debugging) System.out.println("tree.Root.Right == "+ tree.Root.Right.Value);
        if(debugging) System.out.println("root.Parent == "+ root.Parent.Value);
        assertEquals(tree.Root.Right, root);
        assertEquals(root.Parent, tree.Root);
    }
    
    /**
    * Test of transplate(RBNode x, RBNode y)) - 1  method, of class RBTreeWithFaults.
    */
    @Test
    public void testTransplate1() {
        System.out.println("transplate - 1");
        Boolean debugging = false;
        int i=1;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode left = tree.new RBNode("left", i++, tree.Root);
        left.Black = true;
        tree.Root.Left = left;
        
        RBTreeWithFaults.RBNode newLeft = tree.createInfinityNode();
        newLeft.Black = true;
        
        tree.transplate(left, newLeft);
        
        if(debugging) System.out.println("tree.Root.Left == "+ tree.Root.Left.Value);
        assertEquals(tree.Root.Left, newLeft);
        assertEquals(newLeft.Parent, tree.Root);
    }
    
    /**
    * Test of transplate(RBNode x, RBNode y)) - 2  method, of class RBTreeWithFaults.
    */
    @Test
    public void testTransplate2() {
        System.out.println("transplate - 2");
        Boolean debugging = false;
        int i=1;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode right = tree.new RBNode("left", i++, tree.Root);
        right.Black = true;
        tree.Root.Right = right;
        
        RBTreeWithFaults.RBNode newRight = tree.createInfinityNode();
        newRight.Black = true;
        
        tree.transplate(right, newRight);
        
        if(debugging) System.out.println("tree.Root.Right == "+ tree.Root.Right.Value);
        assertEquals(tree.Root.Right, newRight);
        assertEquals(newRight.Parent, tree.Root);
    }
    
    /**
    * Test of leftRotate(RBNode x) - 1  method, of class RBTreeWithFaults.
    */
    @Test
    public void testLeftRotate1() {
        System.out.println("leftRotate - 1");
        Boolean debugging = false;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        int i = 1;
        
        RBTreeWithFaults.RBNode x = tree.new RBNode("x", i++, tree.Root);
        x.Black = true;
        tree.Root.Left = x;
        
        RBTreeWithFaults.RBNode y = tree.new RBNode("y", i++, x);
        y.Black = true;
        x.Right = y;
        
        RBTreeWithFaults.RBNode z = tree.new RBNode("z", i++, y);
        z.Black = true;
        y.Right = z;
        
        tree.leftRotate(x);
        
        if(debugging) System.out.println("tree.Root.Left == "+ tree.Root.Left.Value);
        if(debugging) System.out.println("y.Left == "+ y.Left.Value);
        if(debugging) System.out.println("y.Right == "+ y.Right.Value);
        assertEquals(tree.Root.Left, y);
        assertEquals(y.Left, x);
        assertEquals(y.Right, z);
        
        if(debugging) System.out.println("y.Parent == "+ y.Parent.Value);
        if(debugging) System.out.println("x.Parent == "+ x.Parent.Value);
        if(debugging) System.out.println("z.Parent == "+ z.Parent.Value);
        assertEquals(y.Parent, tree.Root);
        assertEquals(x.Parent, y);
        assertEquals(z.Parent, y);
    }
    
    /**
    * Test of rightRotate(RBNode x) - 1  method, of class RBTreeWithFaults.
    */
    @Test
    public void testRightRotate1() {
        System.out.println("rightRotate - 1");
        Boolean debugging = false;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        int i = 1;
        
        RBTreeWithFaults.RBNode y = tree.new RBNode("y", i++, tree.Root);
        y.Black = true;
        tree.Root.Left = y;
        
        RBTreeWithFaults.RBNode x = tree.new RBNode("x", i++, y);
        x.Black = true;
        y.Left = x;
        
        RBTreeWithFaults.RBNode z = tree.new RBNode("z", i++, x);
        z.Black = true;
        x.Right = z;
        
        tree.rightRotate(y);
        
        if(debugging) System.out.println("tree.Root.Left == "+ tree.Root.Left.Value);
        if(debugging) System.out.println("y.Left == "+ y.Left.Value);
        if(debugging) System.out.println("x.Right == "+ x.Right.Value);
        assertEquals(tree.Root.Left, x);
        assertEquals(y.Left, z);
        assertEquals(x.Right, y);
        
        if(debugging) System.out.println("y.Parent == "+ y.Parent.Value);
        if(debugging) System.out.println("x.Parent == "+ x.Parent.Value);
        if(debugging) System.out.println("z.Parent == "+ z.Parent.Value);
        assertEquals(y.Parent, x);
        assertEquals(x.Parent, tree.Root);
        assertEquals(z.Parent, y);
    }
    
    /**
    * Test of delete(int k) - 1  method, of class RBTreeWithFaults.
    */
    @Test
    public void testDelete1() {
        System.out.println("delete - 1");
        Boolean debugging = false;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        int i = 1;
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, tree.Root);
        root.Black = true;
        tree.Root.Left = root;
        
        root.Left = tree.createNullNode(root);
        root.Right = tree.createNullNode(root);
        
        int result = tree.delete(9);
        
        if(debugging) System.out.println("result = "+ result);
        assertEquals(result, -1);
    }
    
    /**
    * Test of delete(int k) - 2  method, of class RBTreeWithFaults.
    */
    @Test
    public void testDelete2() {
        System.out.println("delete - 2");
        Boolean debugging = false;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        int i = 1;
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, tree.Root);
        root.Black = true;
        tree.Root.Left = root;
        
        RBTreeWithFaults.RBNode right = tree.new RBNode("right", i++, root);
        right.Black = true;
        root.Right = right;
        
        root.Left = tree.createNullNode(root);
        
        int result = tree.delete(1);
        
        if(debugging) System.out.println("result = "+ result);
        assertEquals(result, 0);
    }
    
    /**
    * Test of delete(int k) - 3  method, of class RBTreeWithFaults.
    */
    @Test
    public void testDelete3() {
        System.out.println("delete - 3");
        Boolean debugging = false;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        int i = 1;
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, tree.Root);
        root.Black = true;
        tree.Root.Left = root;
        
        RBTreeWithFaults.RBNode left = tree.new RBNode("left", i++, root);
        left.Black = true;
        root.Left = left;
        
        root.Right = tree.createNullNode(root);
        
        int result = tree.delete(1);
        
        if(debugging) System.out.println("result = "+ result);
        assertEquals(result, 0);
    }
    
    /**
    * Test of delete(int k) - 4  method, of class RBTreeWithFaults.
    */
    @Test
    public void testDelete4() {
        System.out.println("delete - 4");
        Boolean debugging = false;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        int i = 1;
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, tree.Root);
        root.Black = true;
        tree.Root.Left = root;
        
        RBTreeWithFaults.RBNode left = tree.new RBNode("left", i++, root);
        left.Black = true;
        root.Left = left;
        
        RBTreeWithFaults.RBNode right = tree.new RBNode("right", i++, root);
        right.Black = false;
        root.Right = right;
        
        int result = tree.delete(1);
        
        if(debugging) System.out.println("result = "+ result);
        assertEquals(result, 0);
    }
    
    /**
    * Test of delete(int k) - 5  method, of class RBTreeWithFaults.
    */
    @Test
    public void testDelete5() {
        System.out.println("delete - 5");
        Boolean debugging = false;
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        int i = 1;
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, tree.Root);
        root.Black = true;
        tree.Root.Left = root;
        
        RBTreeWithFaults.RBNode left = tree.new RBNode("left", i++, root);
        left.Black = true;
        root.Left = left;
        
        RBTreeWithFaults.RBNode right = tree.new RBNode("right", i++, root);
        right.Black = true;
        root.Right = right;
        
        RBTreeWithFaults.RBNode rightLeft = tree.new RBNode("rightLeft", 0, right);
        rightLeft.Black = false;
        right.Left = rightLeft;
        right.Right = tree.createNullNode(right);
        
        int result = tree.delete(1);
        
        if(debugging) System.out.println("result = "+ result);
        assertEquals(result, 0);
    }
    
    /**
     * Test of deleteFixup - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testDeleteFixup1()
    {
        Boolean debugging = false;
        System.out.println("deleteFixup - 1");
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode xParent = tree.new RBNode("xParent", i++, root);
        xParent.Black = true;
        root.Left = xParent;
        
        RBTreeWithFaults.RBNode x = tree.new RBNode("x", i++, xParent);
        x.Black = true;
        xParent.Left = x;
        
        RBTreeWithFaults.RBNode w = tree.new RBNode("w", i++, xParent);
        w.Black = false;
        xParent.Right = w;
        
        RBTreeWithFaults.RBNode wLeft = tree.new RBNode("wLeft",i++,w);
        wLeft.Black = true;
        w.Left = wLeft;
        
        RBTreeWithFaults.RBNode wLeftLeft = tree.new RBNode("wLeftLeft",i++,wLeft);
        wLeftLeft.Black = true;
        wLeft.Left = wLeftLeft;
        
        RBTreeWithFaults.RBNode wLeftRight = tree.new RBNode("wLeftRight",i++,w);
        wLeftRight.Black = true;
        wLeft.Right = wLeftRight;
        
        RBTreeWithFaults.RBNode wRight = tree.new RBNode("wRight",i++,w);
        wRight.Black = true;
        w.Right = wRight;
        
        int result = tree.deleteFixup(x);
        
        if(debugging) System.out.println("result = "+result);
        int expResult = 4;
        assertEquals(expResult, result);
        
        if(debugging) System.out.println("tree.Root.Value = "+tree.Root.Value);
        assertEquals(tree.Root.Value, "root");
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Left, w);
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left, x);
        assertEquals(xParent.Right, wLeft);
        if(debugging) System.out.println("xParent.Parent = "+xParent.Parent.Value);
        assertEquals(xParent.Parent, w);
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left, xParent);
        assertEquals(w.Right, wRight);
        if(debugging) System.out.println("w.Parent = "+w.Parent.Value);
        assertEquals(w.Parent, root);
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        if(debugging) System.out.println("x.Parent = "+x.Parent.Value);
        assertEquals(x.Parent, xParent);
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, false);
        if(debugging) System.out.println("wLeft.Left.Value = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right.Value = "+wLeft.Right.Value);
        assertEquals(wLeft.Left, wLeftLeft);
        assertEquals(wLeft.Right, wLeftRight);
        if(debugging) System.out.println("wLeft.Parent = "+wLeft.Parent.Value);
        assertEquals(wLeft.Parent, xParent);
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left.Value = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right.Value = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        if(debugging) System.out.println("wLeftLeft.Parent = "+wLeftLeft.Parent.Value);
        assertEquals(wLeftLeft.Parent, wLeft);
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left.Value = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right.Value = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
        if(debugging) System.out.println("wLeftRight.Parent = "+wLeftRight.Parent.Value);
        assertEquals(wLeftRight.Parent, w);
    }

    /**
     * Test of deleteFixup - 2 method, of class RBTreeWithFaults.
     */
    @Test
    public void testDeleteFixup2()
    {
        Boolean debugging = false;
        System.out.println("deleteFixup - 2");
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode xParent = tree.new RBNode("xParent", i++, root);
        xParent.Black = true;
        root.Left = xParent;
        
        RBTreeWithFaults.RBNode x = tree.new RBNode("x", i++, xParent);
        x.Black = true;
        xParent.Left = x;
        
        RBTreeWithFaults.RBNode w = tree.new RBNode("w", i++, xParent);
        w.Black = true;
        xParent.Right = w;
        
        RBTreeWithFaults.RBNode wLeft = tree.new RBNode("wLeft",i++,w);
        wLeft.Black = false;
        w.Left = wLeft;
        
        RBTreeWithFaults.RBNode wLeftLeft = tree.new RBNode("wLeftLeft",i++,wLeft);
        wLeftLeft.Black = true;
        wLeft.Left = wLeftLeft;
        
        RBTreeWithFaults.RBNode wLeftRight = tree.new RBNode("wLeftRight",i++,w);
        wLeftRight.Black = true;
        wLeft.Right = wLeftRight;
        
        RBTreeWithFaults.RBNode wRight = tree.new RBNode("wRight",i++,w);
        wRight.Black = true;
        w.Right = wRight;
        
        int result = tree.deleteFixup(x);
        
        if(debugging) System.out.println("result = "+result);
        int expResult = 3;
        assertEquals(expResult, result);
        
        if(debugging) System.out.println("tree.Root.Value = "+tree.Root.Value);
        assertEquals(tree.Root, root);
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Left, wLeft);
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left, x);
        assertEquals(xParent.Right, wLeftLeft);
        if(debugging) System.out.println("xParent.Parent = "+xParent.Parent.Value);
        assertEquals(xParent.Parent, wLeft);
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left, wLeftRight);
        assertEquals(w.Right, wRight);
        if(debugging) System.out.println("w.Parent = "+w.Parent.Value);
        assertEquals(w.Parent, wLeft);
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        if(debugging) System.out.println("x.Parent = "+x.Parent.Value);
        assertEquals(x.Parent, xParent);
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, true);
        if(debugging) System.out.println("wLeft.Left.Value = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right.Value = "+wLeft.Right.Value);
        assertEquals(wLeft.Left, xParent);
        assertEquals(wLeft.Right, w);
        if(debugging) System.out.println("wLeft.Parent = "+wLeft.Parent.Value);
        assertEquals(wLeft.Parent, root);
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left.Value = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right.Value = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        if(debugging) System.out.println("wLeftLeft.Parent = "+wLeftLeft.Parent.Value);
        assertEquals(wLeftLeft.Parent, xParent);
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left.Value = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right.Value = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
        if(debugging) System.out.println("wLeftRight.Parent = "+wLeftRight.Parent.Value);
        assertEquals(wLeftRight.Parent, w);
    }

    /**
     * Test of deleteFixup - 3 method, of class RBTreeWithFaults.
     */
    @Test
    public void testDeleteFixup3()
    {
        Boolean debugging = false;
        System.out.println("deleteFixup - 3");
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode xParent = tree.new RBNode("xParent", i++, root);
        xParent.Black = true;
        root.Left = xParent;
        
        RBTreeWithFaults.RBNode x = tree.new RBNode("x", i++, xParent);
        x.Black = true;
        xParent.Left = x;
        
        RBTreeWithFaults.RBNode w = tree.new RBNode("w", i++, xParent);
        w.Black = true;
        xParent.Right = w;
        
        RBTreeWithFaults.RBNode wLeft = tree.new RBNode("wLeft",i++,w);
        wLeft.Black = false;
        w.Left = wLeft;
        
        RBTreeWithFaults.RBNode wLeftLeft = tree.new RBNode("wLeftLeft",i++,wLeft);
        wLeftLeft.Black = true;
        wLeft.Left = wLeftLeft;
        
        RBTreeWithFaults.RBNode wLeftRight = tree.new RBNode("wLeftRight",i++,w);
        wLeftRight.Black = true;
        wLeft.Right = wLeftRight;
        
        RBTreeWithFaults.RBNode wRight = tree.new RBNode("wRight",i++,w);
        wRight.Black = false;
        w.Right = wRight;
        
        int result = tree.deleteFixup(x);
        
        if(debugging) System.out.println("result = "+result);
        int expResult = 1;
        assertEquals(expResult, result);
        
        if(debugging) System.out.println("tree.Root.Value = "+tree.Root.Value);
        assertEquals(tree.Root, root);
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Left, w);
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left, x);
        assertEquals(xParent.Right, wLeft);
        if(debugging) System.out.println("root.Parent = "+xParent.Parent.Value);
        assertEquals(xParent.Parent, w);
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left, xParent);
        assertEquals(w.Right, wRight);
        if(debugging) System.out.println("w.Parent = "+w.Parent.Value);
        assertEquals(w.Parent, root);
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        if(debugging) System.out.println("x.Parent = "+x.Parent.Value);
        assertEquals(x.Parent, xParent);
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, false);
        if(debugging) System.out.println("wLeft.Left.Value = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right.Value = "+wLeft.Right.Value);
        assertEquals(wLeft.Left, wLeftLeft);
        assertEquals(wLeft.Right, wLeftRight);
        if(debugging) System.out.println("wLeft.Parent = "+wLeft.Parent.Value);
        assertEquals(wLeft.Parent, xParent);
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left.Value = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right.Value = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        if(debugging) System.out.println("wLeftLeft.Parent = "+wLeftLeft.Parent.Value);
        assertEquals(wLeftLeft.Parent, wLeft);
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left.Value = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right.Value = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
        if(debugging) System.out.println("wLeftRight.Parent = "+wLeftRight.Parent.Value);
        assertEquals(wLeftRight.Parent, w);
    }

    /**
     * Test of deleteFixup - 4 method, of class RBTreeWithFaults.
     */
    @Test
    public void testDeleteFixup4()
    {
        Boolean debugging = false;
        System.out.println("deleteFixup - 4");
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode xParent = tree.new RBNode("xParent", i++, root);
        xParent.Black = true;
        root.Left = xParent;
        
        RBTreeWithFaults.RBNode x = tree.new RBNode("x", i++, xParent);
        x.Black = true;
        xParent.Right = x;
        
        RBTreeWithFaults.RBNode w = tree.new RBNode("w", i++, xParent);
        w.Black = false;
        xParent.Left = w;
        
        RBTreeWithFaults.RBNode wLeft = tree.new RBNode("wLeft",i++,w);
        wLeft.Black = false;
        w.Left = wLeft;
        
        RBTreeWithFaults.RBNode wLeftLeft = tree.new RBNode("wLeftLeft",i++,wLeft);
        wLeftLeft.Black = true;
        wLeft.Left = wLeftLeft;
        
        RBTreeWithFaults.RBNode wLeftRight = tree.new RBNode("wLeftRight",i++,w);
        wLeftRight.Black = true;
        wLeft.Right = wLeftRight;
        
        RBTreeWithFaults.RBNode wRight = tree.new RBNode("wRight",i++,w);
        wRight.Black = false;
        w.Right = wRight;
        
        int result = tree.deleteFixup(x);
        
        if(debugging) System.out.println("result = "+result);
        int expResult = 4;
        assertEquals(expResult, result);
        
        if(debugging) System.out.println("tree.Root.Value = "+tree.Root.Value);
        assertEquals(tree.Root.Value, "root");
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Left, w);
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left, wRight);
        assertEquals(xParent.Right, x);
        if(debugging) System.out.println("root.Parent = "+xParent.Parent.Value);
        assertEquals(xParent.Parent, w);
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left, wLeft);
        assertEquals(w.Right, xParent);
        if(debugging) System.out.println("w.Parent = "+w.Parent.Value);
        assertEquals(w.Parent, root);
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        if(debugging) System.out.println("x.Parent = "+x.Parent.Value);
        assertEquals(x.Parent, xParent);
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, false);
        if(debugging) System.out.println("wLeft.Left.Value = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right.Value = "+wLeft.Right.Value);
        assertEquals(wLeft.Left, wLeftLeft);
        assertEquals(wLeft.Right, wLeftRight);
        if(debugging) System.out.println("wLeft.Parent = "+wLeft.Parent.Value);
        assertEquals(wLeft.Parent, w);
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left.Value = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right.Value = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        if(debugging) System.out.println("wLeftLeft.Parent = "+wLeftLeft.Parent.Value);
        assertEquals(wLeftLeft.Parent, wLeft);
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left.Value = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right.Value = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
        if(debugging) System.out.println("wLeftRight.Parent = "+wLeftRight.Parent.Value);
        assertEquals(wLeftRight.Parent, w);
    }

    /**
     * Test of deleteFixup - 5 method, of class RBTreeWithFaults.
     */
    @Test
    public void testDeleteFixup5()
    {
        Boolean debugging = false;
        System.out.println("deleteFixup - 5");
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode xParent = tree.new RBNode("xParent", i++, root);
        xParent.Black = true;
        root.Left = xParent;
        
        RBTreeWithFaults.RBNode x = tree.new RBNode("x", i++, xParent);
        x.Black = true;
        xParent.Right = x;
        
        RBTreeWithFaults.RBNode w = tree.new RBNode("w", i++, xParent);
        w.Black = true;
        xParent.Left = w;
        
        RBTreeWithFaults.RBNode wLeft = tree.new RBNode("wLeft",i++,w);
        wLeft.Black = true;
        w.Left = wLeft;
        
        RBTreeWithFaults.RBNode wLeftLeft = tree.new RBNode("wLeftLeft",i++,wLeft);
        wLeftLeft.Black = true;
        wLeft.Left = wLeftLeft;
        
        RBTreeWithFaults.RBNode wLeftRight = tree.new RBNode("wLeftRight",i++,w);
        wLeftRight.Black = true;
        wLeft.Right = wLeftRight;
        
        RBTreeWithFaults.RBNode wRight = tree.new RBNode("wRight",i++,w);
        wRight.Black = false;
        w.Right = wRight;
        
        int result = tree.deleteFixup(x);
        
        if(debugging) System.out.println("result = "+result);
        int expResult = 3;
        assertEquals(expResult, result);
        
        if(debugging) System.out.println("tree.Root.Value = "+tree.Root.Value);
        assertEquals(tree.Root.Value, "root");
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Left, wRight);
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left.Value, "N");
        assertEquals(xParent.Right, x);
        if(debugging) System.out.println("root.Parent = "+xParent.Parent.Value);
        assertEquals(xParent.Parent, wRight);
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left, wLeft);
        assertEquals(w.Right.Value, "N");
        if(debugging) System.out.println("w.Parent = "+w.Parent.Value);
        assertEquals(w.Parent, wRight);
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        if(debugging) System.out.println("x.Parent = "+x.Parent.Value);
        assertEquals(x.Parent, xParent);
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, true);
        if(debugging) System.out.println("wLeft.Left.Value = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right.Value = "+wLeft.Right.Value);
        assertEquals(wLeft.Left, wLeftLeft);
        assertEquals(wLeft.Right, wLeftRight);
        if(debugging) System.out.println("wLeft.Parent = "+wLeft.Parent.Value);
        assertEquals(wLeft.Parent, w);
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left.Value = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right.Value = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        if(debugging) System.out.println("wLeftLeft.Parent = "+wLeftLeft.Parent.Value);
        assertEquals(wLeftLeft.Parent, wLeft);
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left.Value = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right.Value = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
        if(debugging) System.out.println("wLeftRight.Parent = "+wLeftRight.Parent.Value);
        assertEquals(wLeftRight.Parent, w);
    }

    /**
     * Test of deleteFixup - 6 method, of class RBTreeWithFaults.
     */
    @Test
    public void testDeleteFixup6()
    {
        Boolean debugging = false;
        System.out.println("deleteFixup - 6");
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode root = tree.new RBNode("root", i++, null);
        root.Black = true;
        tree.Root = root;
        
        RBTreeWithFaults.RBNode xParent = tree.new RBNode("xParent", i++, root);
        xParent.Black = true;
        root.Left = xParent;
        
        RBTreeWithFaults.RBNode x = tree.new RBNode("x", i++, xParent);
        x.Black = true;
        xParent.Right = x;
        
        RBTreeWithFaults.RBNode w = tree.new RBNode("w", i++, xParent);
        w.Black = true;
        xParent.Left = w;
        
        RBTreeWithFaults.RBNode wLeft = tree.new RBNode("wLeft",i++,w);
        wLeft.Black = false;
        w.Left = wLeft;
        
        RBTreeWithFaults.RBNode wLeftLeft = tree.new RBNode("wLeftLeft",i++,wLeft);
        wLeftLeft.Black = true;
        wLeft.Left = wLeftLeft;
        
        RBTreeWithFaults.RBNode wLeftRight = tree.new RBNode("wLeftRight",i++,w);
        wLeftRight.Black = true;
        wLeft.Right = wLeftRight;
        
        RBTreeWithFaults.RBNode wRight = tree.new RBNode("wRight",i++,w);
        wRight.Black = false;
        w.Right = wRight;
        
        int result = tree.deleteFixup(x);
        
        if(debugging) System.out.println("result = "+result);
        int expResult = 1;
        assertEquals(expResult, result);
        
        if(debugging) System.out.println("tree.Root.Value = "+tree.Root.Value);
        assertEquals(tree.Root.Value, "root");
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Left, w);
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left, wRight);
        assertEquals(xParent.Right, x);
        if(debugging) System.out.println("root.Parent = "+xParent.Parent.Value);
        assertEquals(xParent.Parent, w);
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left, wLeft);
        assertEquals(w.Right, xParent);
        if(debugging) System.out.println("w.Parent = "+w.Parent.Value);
        assertEquals(w.Parent, root);
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        if(debugging) System.out.println("x.Parent = "+x.Parent.Value);
        assertEquals(x.Parent, xParent);
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, true);
        if(debugging) System.out.println("wLeft.Left.Value = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right.Value = "+wLeft.Right.Value);
        assertEquals(wLeft.Left, wLeftLeft);
        assertEquals(wLeft.Right, wLeftRight);
        if(debugging) System.out.println("wLeft.Parent = "+wLeft.Parent.Value);
        assertEquals(wLeft.Parent, w);
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left.Value = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right.Value = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        if(debugging) System.out.println("wLeftLeft.Parent = "+wLeftLeft.Parent.Value);
        assertEquals(wLeftLeft.Parent, wLeft);
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left.Value = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right.Value = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
        if(debugging) System.out.println("wLeftRight.Parent = "+wLeftRight.Parent.Value);
        assertEquals(wLeftRight.Parent, w);
    }
    
    /**
     * Test of min - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testMin1() {
        Boolean debugging = false;
        System.out.println("min - 1");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        String expResult = null;
        String result = tree.min();
        
        if(debugging) System.out.println("result == null");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of min - 2 method, of class RBTreeWithFaults.
     */
    @Test
    public void testMin2() {
        Boolean debugging = false;
        System.out.println("min - 2");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode xParent = tree.new RBNode("rootLeft", i++, tree.Root);
        xParent.Black = true;
        tree.Root.Left = xParent;
        
        String expResult = "rootLeft";
        String result = tree.min();
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of minimumNode - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void minimumNode1() {
        Boolean debugging = false;
        System.out.println("minimumNode - 1");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode expResult = null;
        RBTreeWithFaults.RBNode result = tree.minimumNode(tree.Root.Left);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of minimumNode - 2 method, of class RBTreeWithFaults.
     */
    @Test
    public void minimumNode2() {
        Boolean debugging = false;
        System.out.println("minimumNode - 2");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode rootLeft = tree.new RBNode("rootLeft", i++, tree.Root);
        rootLeft.Black = true;
        tree.Root.Left = rootLeft;
        
        RBTreeWithFaults.RBNode expResult = rootLeft;
        RBTreeWithFaults.RBNode result = tree.minimumNode(rootLeft);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of minimumNode - 3 method, of class RBTreeWithFaults.
     */
    @Test
    public void minimumNode3() {
        Boolean debugging = false;
        System.out.println("minimumNode - 3");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode rootLeft = tree.new RBNode("rootLeft", i++, tree.Root);
        rootLeft.Black = true;
        tree.Root.Left = rootLeft;
        
        RBTreeWithFaults.RBNode expResult = rootLeft;
        RBTreeWithFaults.RBNode result = tree.minimumNode(tree.Root);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInfinityNode - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void isInfinityNode1() {
        Boolean debugging = false;
        System.out.println("isInfinityNode - 1");
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        Boolean expResult = true;
        Boolean result = tree.isInfinityNode(tree.Root);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNullNode - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void isNullNode1() {
        Boolean debugging = false;
        System.out.println("isNullNode - 1");
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        Boolean expResult = false;
        Boolean result = tree.isNullNode(tree.Root);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of max - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testMax1() {
        Boolean debugging = false;
        System.out.println("max - 1");
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        String expResult = null;
        String result = tree.max();
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of max - 2 method, of class RBTreeWithFaults.
     */
    @Test
    public void testMax2() {
        Boolean debugging = false;
        System.out.println("max - 2");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode rootLeft = tree.new RBNode("rootLeft", i++, tree.Root);
        rootLeft.Black = true;
        tree.Root.Left = rootLeft;
        
        String expResult = "rootLeft";
        String result = tree.max();
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of maxValue - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testMaxValue1() {
        Boolean debugging = false;
        System.out.println("maxValue - 1");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        tree.Root.Right = tree.createNullNode(tree.Root);
        
        String expResult = "Infinity";
        String result = tree.maxValue(tree.Root);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of maxValue - 2 method, of class RBTreeWithFaults.
     */
    @Test
    public void testMaxValue2() {
        Boolean debugging = false;
        System.out.println("maxValue - 2");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode rootRight = tree.new RBNode("rootRight", i++, tree.Root);
        rootRight.Black = true;
        tree.Root.Right = rootRight;
        
        String expResult = "rootRight";
        String result = tree.maxValue(tree.Root);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of keysToArray - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testKeysToArray1() {
        Boolean debugging = false;
        System.out.println("keysToArray - 1");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        int[] expResult = {};
        int[] result = tree.keysToArray();
        
        if(debugging) System.out.println("result.length == "+result.length);
        assertEquals(expResult.length, result.length);
        
        for(int arrayIndex = 0; arrayIndex<result.length; arrayIndex++)
        {
            if(debugging) System.out.println("result["+arrayIndex+"] == "+result[arrayIndex]);
            assertEquals(expResult[arrayIndex], result[arrayIndex]);
        }
    }
    
    /**
     * Test of keysToArray - 2 method, of class RBTreeWithFaults.
     */
    @Test
    public void testKeysToArray2() {
        Boolean debugging = false;
        System.out.println("keysToArray - 2");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode rootLeft = tree.new RBNode("rootLeft", i++, tree.Root);
        rootLeft.Black = true;
        tree.Root.Left = rootLeft;
        
        int[] expResult = {1};
        int[] result = tree.keysToArray();
        
        if(debugging) System.out.println("result.length == "+result.length);
        assertEquals(expResult.length, result.length);
        
        for(int arrayIndex = 0; arrayIndex<result.length; arrayIndex++)
        {
            if(debugging) System.out.println("result["+arrayIndex+"] == "+result[arrayIndex]);
            assertEquals(expResult[arrayIndex], result[arrayIndex]);
        }
    }
    
    /**
     * Test of ArrayOfStringsToArrayOfInts - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testArrayOfStringsToArrayOfInts1() {
        Boolean debugging = false;
        System.out.println("ArrayOfStringsToArrayOfInts - 1");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode rootLeft = tree.new RBNode("rootLeft", i++, tree.Root);
        rootLeft.Black = true;
        tree.Root.Left = rootLeft;
        
        String[] input = {"1"};
        int[] expResult = {1};
        int[] result = tree.ArrayOfStringsToArrayOfInts(input);
        
        if(debugging) System.out.println("result.length == "+result.length);
        assertEquals(expResult.length, result.length);
        
        for(int arrayIndex = 0; arrayIndex<result.length; arrayIndex++)
        {
            if(debugging) System.out.println("result["+arrayIndex+"] == "+result[arrayIndex]);
            assertEquals(expResult[arrayIndex], result[arrayIndex]);
        }
    }
    
    /**
     * Test of ElementsToString - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testElementsToString1() {
        Boolean debugging = false;
        System.out.println("ElementsToString - 1");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        tree.Root.Left = tree.createNullNode(tree.Root);
        
        String expResult = "";
        String result = tree.ElementsToString(tree.Root.Left, true);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ElementsToString - 2 method, of class RBTreeWithFaults.
     */
    @Test
    public void testElementsToString2() {
        Boolean debugging = false;
        System.out.println("ElementsToString - 2");
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        tree.Root.Left = tree.createNullNode(tree.Root);
        
        String expResult = "";
        String result = tree.ElementsToString(tree.Root, true);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ElementsToString - 3 method, of class RBTreeWithFaults.
     */
    @Test
    public void testElementsToString3() {
        Boolean debugging = false;
        System.out.println("ElementsToString - 3");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode rootLeft = tree.new RBNode("rootLeft", i++, tree.Root);
        rootLeft.Black = true;
        tree.Root.Left = rootLeft;
        
        RBTreeWithFaults.RBNode rootLeftRight = tree.new RBNode("rootLeftRight", i++, rootLeft);
        rootLeftRight.Black = true;
        rootLeft.Right = rootLeftRight;
        
        RBTreeWithFaults.RBNode rootLeftLeft = tree.new RBNode("rootLeftLeft", i++, rootLeft);
        rootLeftLeft.Black = true;
        rootLeft.Left = rootLeftLeft;
        
        String expResult = "3,1,2";
        String result = tree.ElementsToString(rootLeft, true);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ElementsToString - 4 method, of class RBTreeWithFaults.
     */
    @Test
    public void testElementsToString4() {
        Boolean debugging = false;
        System.out.println("ElementsToString - 4");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode rootLeft = tree.new RBNode("rootLeft", i++, tree.Root);
        rootLeft.Black = true;
        tree.Root.Left = rootLeft;
        
        RBTreeWithFaults.RBNode rootLeftRight = tree.new RBNode("rootLeftRight", i++, rootLeft);
        rootLeftRight.Black = true;
        rootLeft.Right = rootLeftRight;
        
        String expResult = "rootLeft,rootLeftRight";
        String result = tree.ElementsToString(rootLeft, false);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ElementsToString - 5 method, of class RBTreeWithFaults.
     */
    @Test
    public void testElementsToString5() {
        Boolean debugging = false;
        System.out.println("ElementsToString - 5");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode rootLeft = tree.new RBNode("rootLeft", i++, tree.Root);
        rootLeft.Black = true;
        tree.Root.Left = rootLeft;
        
        RBTreeWithFaults.RBNode rootLeftLeft = tree.new RBNode("rootLeftLeft", i++, rootLeft);
        rootLeftLeft.Black = true;
        rootLeft.Left = rootLeftLeft;
        
        String expResult = "rootLeftLeft,rootLeft";
        String result = tree.ElementsToString(rootLeft, false);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ElementsToString - 6 method, of class RBTreeWithFaults.
     */
    @Test
    public void testElementsToString6() {
        Boolean debugging = false;
        System.out.println("ElementsToString - 6");
        
        int i=1;
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        RBTreeWithFaults.RBNode rootLeft = tree.new RBNode("rootLeft", i++, tree.Root);
        rootLeft.Black = true;
        tree.Root.Left = rootLeft;
        
        String expResult = "rootLeft";
        String result = tree.ElementsToString(rootLeft, false);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of valuesToArray - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testValuesToArray1() {
        Boolean debugging = false;
        System.out.println("valuesToArray - 1");
        
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        String[] expResult = {""};
        String[] result = tree.valuesToArray();
        
        if(debugging) System.out.println("result.length == "+result.length);
        assertEquals(expResult.length, result.length);
        
        for(int arrayIndex = 0; arrayIndex<result.length; arrayIndex++)
        {
            if(debugging) System.out.println("result["+arrayIndex+"] == "+result[arrayIndex]);
            assertEquals(expResult[arrayIndex], result[arrayIndex]);
        }
    }

    /**
     * Test of size - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testSize1() {
        Boolean debugging = false;
        System.out.println("size - 1");
        RBTreeWithFaults instance = new RBTreeWithFaults();
        int expResult = 0;
        int result = instance.size();
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of size - 2 method, of class RBTreeWithFaults.
     */
    @Test
    public void testSize2() {
        Boolean debugging = false;
        System.out.println("size - 2");
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        int i=1;
        RBTreeWithFaults.RBNode rootLeft = tree.new RBNode("rootLeft", i++, tree.Root);
        rootLeft.Black = true;
        tree.Root.Left = rootLeft;
        
        int expResult = 1;
        int result = tree.size();
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of sizeCalc - 1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testSizeCalc1() {
        Boolean debugging = false;
        System.out.println("sizeCalc - 1");
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        int i=1;
        RBTreeWithFaults.RBNode rootLeft = tree.new RBNode("rootLeft", i++, tree.Root);
        rootLeft.Black = true;
        tree.Root.Left = rootLeft;
        
        RBTreeWithFaults.RBNode rootRight = tree.new RBNode("rootRight", i++, tree.Root);
        rootRight.Black = true;
        tree.Root.Right = rootRight;
        
        int expResult = 3;
        int result = RBTreeWithFaults.sizeCalc(tree.Root);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of sizeCalc - 2 method, of class RBTreeWithFaults.
     */
    @Test
    public void testSizeCalc2() {
        Boolean debugging = false;
        System.out.println("sizeCalc - 2");
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        int i=1;
        RBTreeWithFaults.RBNode rootLeft = tree.new RBNode("rootLeft", i++, tree.Root);
        rootLeft.Black = true;
        tree.Root.Left = rootLeft;
        
        tree.Root.Right = tree.createNullNode(tree.Root);
        
        int expResult = 2;
        int result = RBTreeWithFaults.sizeCalc(tree.Root);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of sizeCalc - 3 method, of class RBTreeWithFaults.
     */
    @Test
    public void testSizeCalc3() {
        Boolean debugging = false;
        System.out.println("sizeCalc - 3");
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        int i=1;
        RBTreeWithFaults.RBNode rootRight = tree.new RBNode("rootRight", i++, tree.Root);
        rootRight.Black = true;
        tree.Root.Right = rootRight;
        
        tree.Root.Left = tree.createNullNode(tree.Root);
        
        int expResult = 2;
        int result = RBTreeWithFaults.sizeCalc(tree.Root);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of sizeCalc - 4 method, of class RBTreeWithFaults.
     */
    @Test
    public void testSizeCalc4() {
        Boolean debugging = false;
        System.out.println("sizeCalc - 4");
        RBTreeWithFaults tree = new RBTreeWithFaults();
        
        tree.Root.Left = tree.createNullNode(tree.Root);
        tree.Root.Right = tree.createNullNode(tree.Root);
        
        int expResult = 1;
        int result = RBTreeWithFaults.sizeCalc(tree.Root);
        
        if(debugging) System.out.println("result == "+result);
        assertEquals(expResult, result);
    }
}