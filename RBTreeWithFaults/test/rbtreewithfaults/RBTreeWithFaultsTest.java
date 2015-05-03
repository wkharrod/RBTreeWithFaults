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
        assertEquals(root.Left.Value, "w");
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left.Value, "x");
        assertEquals(xParent.Right.Value, "wLeft");
        if(debugging) System.out.println("xParent.Parent = "+xParent.Parent.Value);
        assertEquals(xParent.Parent.Value, "w");
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left.Value, "xParent");
        assertEquals(w.Right.Value, "wRight");
        if(debugging) System.out.println("w.Parent = "+w.Parent.Value);
        assertEquals(w.Parent.Value, "root");
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        if(debugging) System.out.println("x.Parent = "+x.Parent.Value);
        assertEquals(x.Parent.Value, "xParent");
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, false);
        if(debugging) System.out.println("wLeft.Left.Value = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right.Value = "+wLeft.Right.Value);
        assertEquals(wLeft.Left.Value, "wLeftLeft");
        assertEquals(wLeft.Right.Value, "wLeftRight");
        if(debugging) System.out.println("wLeft.Parent = "+wLeft.Parent.Value);
        assertEquals(wLeft.Parent.Value, "xParent");
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left.Value = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right.Value = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        if(debugging) System.out.println("wLeftLeft.Parent = "+wLeftLeft.Parent.Value);
        assertEquals(wLeftLeft.Parent.Value, "wLeft");
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left.Value = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right.Value = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
        if(debugging) System.out.println("wLeftRight.Parent = "+wLeftRight.Parent.Value);
        assertEquals(wLeftRight.Parent.Value, "w");
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
        assertEquals(tree.Root.Value, "root");
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Left.Value, "wLeft");
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left.Value, "x");
        assertEquals(xParent.Right.Value, "wLeftLeft");
        if(debugging) System.out.println("xParent.Parent = "+xParent.Parent.Value);
        assertEquals(xParent.Parent.Value, "wLeft");
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left.Value, "wLeftRight");
        assertEquals(w.Right.Value, "wRight");
        if(debugging) System.out.println("w.Parent = "+w.Parent.Value);
        assertEquals(w.Parent.Value, "wLeft");
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        if(debugging) System.out.println("x.Parent = "+x.Parent.Value);
        assertEquals(x.Parent.Value, "xParent");
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, true);
        if(debugging) System.out.println("wLeft.Left.Value = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right.Value = "+wLeft.Right.Value);
        assertEquals(wLeft.Left.Value, "xParent");
        assertEquals(wLeft.Right.Value, "w");
        if(debugging) System.out.println("wLeft.Parent = "+wLeft.Parent.Value);
        assertEquals(wLeft.Parent.Value, "root");
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left.Value = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right.Value = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        if(debugging) System.out.println("wLeftLeft.Parent = "+wLeftLeft.Parent.Value);
        assertEquals(wLeftLeft.Parent.Value, "xParent");
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left.Value = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right.Value = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
        if(debugging) System.out.println("wLeftRight.Parent = "+wLeftRight.Parent.Value);
        assertEquals(wLeftRight.Parent.Value, "w");
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
        assertEquals(tree.Root.Value, "root");
        
        if(debugging) System.out.println("root.Black = "+root.Black);
        assertEquals(root.Black, true);
        if(debugging) System.out.println("root.Left.Value = "+root.Left.Value);
        if(debugging) System.out.println("root.Right.Value = "+root.Right.Value);
        assertEquals(root.Left.Value, "w");
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left.Value, "x");
        assertEquals(xParent.Right.Value, "wLeft");
        if(debugging) System.out.println("root.Parent = "+xParent.Parent.Value);
        assertEquals(xParent.Parent.Value, "w");
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left.Value, "xParent");
        assertEquals(w.Right.Value, "wRight");
        if(debugging) System.out.println("w.Parent = "+w.Parent.Value);
        assertEquals(w.Parent.Value, "root");
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        if(debugging) System.out.println("x.Parent = "+x.Parent.Value);
        assertEquals(x.Parent.Value, "xParent");
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, false);
        if(debugging) System.out.println("wLeft.Left.Value = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right.Value = "+wLeft.Right.Value);
        assertEquals(wLeft.Left.Value, "wLeftLeft");
        assertEquals(wLeft.Right.Value, "wLeftRight");
        if(debugging) System.out.println("wLeft.Parent = "+wLeft.Parent.Value);
        assertEquals(wLeft.Parent.Value, "xParent");
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left.Value = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right.Value = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        if(debugging) System.out.println("wLeftLeft.Parent = "+wLeftLeft.Parent.Value);
        assertEquals(wLeftLeft.Parent.Value, "wLeft");
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left.Value = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right.Value = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
        if(debugging) System.out.println("wLeftRight.Parent = "+wLeftRight.Parent.Value);
        assertEquals(wLeftRight.Parent.Value, "w");
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
        assertEquals(root.Left.Value, "w");
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left.Value, "wRight");
        assertEquals(xParent.Right.Value, "x");
        if(debugging) System.out.println("root.Parent = "+xParent.Parent.Value);
        assertEquals(xParent.Parent.Value, "w");
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left.Value, "wLeft");
        assertEquals(w.Right.Value, "xParent");
        if(debugging) System.out.println("w.Parent = "+w.Parent.Value);
        assertEquals(w.Parent.Value, "root");
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        if(debugging) System.out.println("x.Parent = "+x.Parent.Value);
        assertEquals(x.Parent.Value, "xParent");
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, false);
        if(debugging) System.out.println("wLeft.Left.Value = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right.Value = "+wLeft.Right.Value);
        assertEquals(wLeft.Left.Value, "wLeftLeft");
        assertEquals(wLeft.Right.Value, "wLeftRight");
        if(debugging) System.out.println("wLeft.Parent = "+wLeft.Parent.Value);
        assertEquals(wLeft.Parent.Value, "w");
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left.Value = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right.Value = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        if(debugging) System.out.println("wLeftLeft.Parent = "+wLeftLeft.Parent.Value);
        assertEquals(wLeftLeft.Parent.Value, "wLeft");
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left.Value = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right.Value = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
        if(debugging) System.out.println("wLeftRight.Parent = "+wLeftRight.Parent.Value);
        assertEquals(wLeftRight.Parent.Value, "w");
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
        assertEquals(root.Left.Value, "wRight");
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left.Value, "N");
        assertEquals(xParent.Right.Value, "x");
        if(debugging) System.out.println("root.Parent = "+xParent.Parent.Value);
        assertEquals(xParent.Parent.Value, "wRight");
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left.Value, "wLeft");
        assertEquals(w.Right.Value, "N");
        if(debugging) System.out.println("w.Parent = "+w.Parent.Value);
        assertEquals(w.Parent.Value, "wRight");
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        if(debugging) System.out.println("x.Parent = "+x.Parent.Value);
        assertEquals(x.Parent.Value, "xParent");
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, true);
        if(debugging) System.out.println("wLeft.Left.Value = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right.Value = "+wLeft.Right.Value);
        assertEquals(wLeft.Left.Value, "wLeftLeft");
        assertEquals(wLeft.Right.Value, "wLeftRight");
        if(debugging) System.out.println("wLeft.Parent = "+wLeft.Parent.Value);
        assertEquals(wLeft.Parent.Value, "w");
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left.Value = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right.Value = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        if(debugging) System.out.println("wLeftLeft.Parent = "+wLeftLeft.Parent.Value);
        assertEquals(wLeftLeft.Parent.Value, "wLeft");
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left.Value = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right.Value = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
        if(debugging) System.out.println("wLeftRight.Parent = "+wLeftRight.Parent.Value);
        assertEquals(wLeftRight.Parent.Value, "w");
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
        assertEquals(root.Left.Value, "w");
        assertEquals(root.Right.Value, "N");
        if(debugging) System.out.println("root.Parent = null");
        assertEquals(root.Parent, null);
        
        if(debugging) System.out.println("xParent.Black = "+xParent.Black);
        assertEquals(xParent.Black, true);
        if(debugging) System.out.println("xParent.Left.Value = "+xParent.Left.Value);
        if(debugging) System.out.println("xParent.Right.Value = "+xParent.Right.Value);
        assertEquals(xParent.Left.Value, "wRight");
        assertEquals(xParent.Right.Value, "x");
        if(debugging) System.out.println("root.Parent = "+xParent.Parent.Value);
        assertEquals(xParent.Parent.Value, "w");
        
        if(debugging) System.out.println("w.Black = "+w.Black);
        assertEquals(w.Black, true);
        if(debugging) System.out.println("w.Left.Value = "+w.Left.Value);
        if(debugging) System.out.println("w.Right.Value = "+w.Right.Value);
        assertEquals(w.Left.Value, "wLeft");
        assertEquals(w.Right.Value, "xParent");
        if(debugging) System.out.println("w.Parent = "+w.Parent.Value);
        assertEquals(w.Parent.Value, "root");
        
        if(debugging) System.out.println("x.Black = "+x.Black);
        assertEquals(x.Black, true);
        if(debugging) System.out.println("x.Left.Value = "+x.Left.Value);
        if(debugging) System.out.println("x.Right.Value = "+x.Right.Value);
        assertEquals(x.Left.Value, "N");
        assertEquals(x.Right.Value, "N");
        if(debugging) System.out.println("x.Parent = "+x.Parent.Value);
        assertEquals(x.Parent.Value, "xParent");
        
        if(debugging) System.out.println("wLeft.Black = "+wLeft.Black);
        assertEquals(wLeft.Black, true);
        if(debugging) System.out.println("wLeft.Left.Value = "+wLeft.Left.Value);
        if(debugging) System.out.println("wLeft.Right.Value = "+wLeft.Right.Value);
        assertEquals(wLeft.Left.Value, "wLeftLeft");
        assertEquals(wLeft.Right.Value, "wLeftRight");
        if(debugging) System.out.println("wLeft.Parent = "+wLeft.Parent.Value);
        assertEquals(wLeft.Parent.Value, "w");
        
        if(debugging) System.out.println("wLeftLeft.Black = "+wLeftLeft.Black);
        assertEquals(wLeftLeft.Black, true);
        if(debugging) System.out.println("wLeftLeft.Left.Value = "+wLeftLeft.Left.Value);
        if(debugging) System.out.println("wLeftLeft.Right.Value = "+wLeftLeft.Right.Value);
        assertEquals(wLeftLeft.Left.Value, "N");
        assertEquals(wLeftLeft.Right.Value, "N");
        if(debugging) System.out.println("wLeftLeft.Parent = "+wLeftLeft.Parent.Value);
        assertEquals(wLeftLeft.Parent.Value, "wLeft");
        
        if(debugging) System.out.println("wLeftRight.Black = "+wLeftRight.Black);
        assertEquals(wLeftRight.Black, true);
        if(debugging) System.out.println("wLeftRight.Left.Value = "+wLeftRight.Left.Value);
        if(debugging) System.out.println("wLeftRight.Right.Value = "+wLeftRight.Right.Value);
        assertEquals(wLeftRight.Left.Value, "N");
        assertEquals(wLeftRight.Right.Value, "N");
        if(debugging) System.out.println("wLeftRight.Parent = "+wLeftRight.Parent.Value);
        assertEquals(wLeftRight.Parent.Value, "w");
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
