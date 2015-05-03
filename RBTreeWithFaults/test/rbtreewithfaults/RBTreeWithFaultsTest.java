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
     * Test of getRoot method, of class RBTreeWithFaults.
     */
    @Test
    public void testGetRoot() {
        System.out.println("getRoot");
        RBTreeWithFaults instance = new RBTreeWithFaults();
        RBTreeWithFaults.RBNode expResult = null;
        RBTreeWithFaults.RBNode result = instance.getRoot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of empty method, of class RBTreeWithFaults.
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        RBTreeWithFaults instance = new RBTreeWithFaults();
        boolean expResult = false;
        boolean result = instance.empty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class RBTreeWithFaults.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        int k = 0;
        RBTreeWithFaults instance = new RBTreeWithFaults();
        String expResult = "";
        String result = instance.search(k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class RBTreeWithFaults.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        int k = 0;
        String v = "";
        RBTreeWithFaults instance = new RBTreeWithFaults();
        int expResult = 0;
        int result = instance.insert(k, v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class RBTreeWithFaults.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int k = 0;
        RBTreeWithFaults instance = new RBTreeWithFaults();
        int expResult = 0;
        int result = instance.delete(k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFixup1 method, of class RBTreeWithFaults.
     */
    @Test
    public void testDeleteFixup1()
    {
        Boolean debugging = false;
        System.out.println("deleteFixup1");
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
        assertEquals(root.Left.Value, "w");
        assertEquals(root.Right.Value, "N");
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left.Value, "x");
        assertEquals(xParent.Right.Value, "wLeft");
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left.Value, "xParent");
        assertEquals(w.Right.Value, "wRight");
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, false);
        if(debugging) System.out.println("wLeft.Left = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right = "+wLeft.Right.Value);
        assertEquals(wLeft.Left.Value, "wLeftLeft");
        assertEquals(wLeft.Right.Value, "wLeftRight");
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
    }

    /**
     * Test of deleteFixup2 method, of class RBTreeWithFaults.
     */
    @Test
    public void testDeleteFixup2()
    {
        Boolean debugging = false;
        System.out.println("deleteFixup2");
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
        assertEquals(root.Left.Value, "w");
        assertEquals(root.Right.Value, "N");
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left.Value, "x");
        assertEquals(xParent.Right.Value, "wLeft");
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left.Value, "xParent");
        assertEquals(w.Right.Value, "wRight");
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, false);
        if(debugging) System.out.println("wLeft.Left = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right = "+wLeft.Right.Value);
        assertEquals(wLeft.Left.Value, "wLeftLeft");
        assertEquals(wLeft.Right.Value, "wLeftRight");
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
    }
    
    /**
     * Test of min method, of class RBTreeWithFaults.
     */
    @Test
    public void testMin() {
        System.out.println("min");
        RBTreeWithFaults instance = new RBTreeWithFaults();
        String expResult = "";
        String result = instance.min();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of max method, of class RBTreeWithFaults.
     */
    @Test
    public void testMax() {
        System.out.println("max");
        RBTreeWithFaults instance = new RBTreeWithFaults();
        String expResult = "";
        String result = instance.max();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of maxValue method, of class RBTreeWithFaults.
     */
    @Test
    public void testMaxValue() {
        System.out.println("maxValue");
        RBTreeWithFaults.RBNode node = null;
        String expResult = "";
        String result = RBTreeWithFaults.maxValue(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keysToArray method, of class RBTreeWithFaults.
     */
    @Test
    public void testKeysToArray() {
        System.out.println("keysToArray");
        RBTreeWithFaults instance = new RBTreeWithFaults();
        int[] expResult = null;
        int[] result = instance.keysToArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valuesToArray method, of class RBTreeWithFaults.
     */
    @Test
    public void testValuesToArray() {
        System.out.println("valuesToArray");
        RBTreeWithFaults instance = new RBTreeWithFaults();
        String[] expResult = null;
        String[] result = instance.valuesToArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class RBTreeWithFaults.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        RBTreeWithFaults instance = new RBTreeWithFaults();
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class RBTreeWithFaults.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        RBTreeWithFaults instance = new RBTreeWithFaults();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sizeCalc method, of class RBTreeWithFaults.
     */
    @Test
    public void testSizeCalc() {
        System.out.println("sizeCalc");
        RBTreeWithFaults.RBNode node = null;
        int expResult = 0;
        int result = RBTreeWithFaults.sizeCalc(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class RBTreeWithFaults.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RBTreeWithFaults.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
