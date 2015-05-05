/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbtreewithfaults;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * RBTree
 *
 * An implementation of a Red Black Tree with
 * non-negative, distinct integer keys and values
 *
 */

public class RBTreeWithFaults 
{
    public RBNode Root;

    /**
     * O(1)
     * @return the tree real root (not the sentinel)
     */
    public RBNode getRoot()
    {
        Boolean debugging = false;
        if(debugging) System.out.println("getRoot() -- 1");
        return Root.Left;
    }

    /**
     * O(1)
     * Create a new empty tree
     */
    public RBTreeWithFaults()
    {
        Boolean debugging = false;
        if(debugging) System.out.println("RBTreeWithFaults() -- 1");
        this.Root = createInfinityNode();
    }

    /**
     * O(1)
     * create a tree with a root
     * @param root - RBNode object will be the root of the tree
     */
    public RBTreeWithFaults(RBNode root)
    {
        Boolean debugging = false;
        if(debugging) System.out.println("RBTreeWithFaults(RBNode root) -- 2");
        this.Root = createInfinityNode(root);;
    }

    /**
     * O(1)
     * create infinity node with Null children
     * @return infinity node with no children
     */
    public RBNode createInfinityNode()
    {
        Boolean debugging = false;
        if(debugging) System.out.println("RBTreeWithFaults(RBNode root) -- 2");
        return createInfinityNode(createNullNode(null));
    }

    /**
     * O(1)
     * create infinity node with a left child (infinity node cant have right child)
     * @param leftchild - the left child of the infinity node
     * @return infinity node with a left child
     */
    public RBNode createInfinityNode(RBNode leftchild)
    {
        Boolean debugging = false;
        if(debugging) System.out.println("createInfinityNode(RBNode leftchild) -- 1");
        //create infinity node with a key of the maximum integer available in java.
        RBNode node = new RBNode("Infinity",Integer.MAX_VALUE,leftchild,null,null);
        //set the parent of the new child to be the node
        node.Left.Parent = node;
        //set the infinity node to be black
        node.Black = true;
        return node;
    }

    /**
     * O(1)
     * create a null node
     * @param parent - the parent of this null node
     * @return the null node already connected to its parent
     */
    public RBNode createNullNode(RBNode parent)
    {
        Boolean debugging = false;
        if(debugging) System.out.println("createNullNode(RBNode parent) -- 1");
        //create a null node. this node will have the minimum integer value available in java as a key
        RBNode newNode = new RBNode("N",Integer.MIN_VALUE,null,null,parent);
        //set the null node to be black (default is red)
        newNode.Black = true;
        return newNode;
    }

    /**
     * O(1)
     * public boolean empty()
     *
     * returns true if and only if the tree is empty
     *
     */
    public boolean empty()
    {
        Boolean debugging = false;
        if(debugging) System.out.println("empty() -- 1");
        return isNullNode(this.Root.Left);
    }

    /**
     * O(log(n))
     * public String search(int k)
     *
     * returns the value of an item with key k if it exists in the tree
     * otherwise, returns null
     */
    public String search(int k)
    {
        Boolean debugging = false;
        if(debugging) System.out.println("search(int k) -- 1");
        RBNode currNode = SearchNode(k,this.Root);
        //return null if the tree is empty
        if(currNode == null)
        {
            if(debugging) System.out.println("search(int k) -- 2");
            return null;
        }
        if(debugging) System.out.println("search(int k) -- 3");
        //if not found return null
        if(isNullNode(currNode) || currNode.Key != k)
        {
            if(debugging) System.out.println("search(int k) -- 4");
            return null;
        }
        
        if(debugging) System.out.println("search(int k) -- 5");
        //return the value of the node with the key = k
        return currNode.Value;
    }

    /**
     * O(log(n))
     * search for node
     * @param k - the key to look for
     * @param node - the node to start looking from
     * @return if found return the node with the same key and if not found returns the nearest node for the location
     * the node was supposed to be found. if the parent is the infinity node and not part of the tree
     * returns null
     */
    public RBNode SearchNode(int k,RBNode node)
    {
        Boolean debugging = false;
        if(debugging) System.out.println("SearchNode(int k,RBNode node) -- 1");
        //if the node that was given is the sentinel recursively call the function with the tree root
        if (isInfinityNode(node))
        {
            if(debugging) System.out.println("SearchNode(int k,RBNode node) -- 2");
            return SearchNode(k,node.Left);
        }
        if(debugging) System.out.println("SearchNode(int k,RBNode node) -- 3");
        if(isNullNode(node))
        {
            if(debugging) System.out.println("SearchNode(int k,RBNode node) -- 4");
            //the node is not exist in the tree. we will return null if the tree is empty.
            if(isInfinityNode(node.Parent))
            {
                if(debugging) System.out.println("SearchNode(int k,RBNode node) -- 5");
                return null;
            }
            else
            {
                if(debugging) System.out.println("SearchNode(int k,RBNode node) -- 6");
                //we could not find the node so we will return the parent of the imaginary node if it was exist in the tree 
                return node.Parent;
            }
        }
        if(debugging) System.out.println("SearchNode(int k,RBNode node) -- 7");

        if(node.Key > k)
        {
            if(debugging) System.out.println("SearchNode(int k,RBNode node) -- 8");
            //if the current node key is bigger then the key we look for
            //recursively call searchNode with the left child of the current node 
            return SearchNode(k,node.Left);
        }
        if(debugging) System.out.println("SearchNode(int k,RBNode node) -- 9");
        if(node.Key < k)
        {
            if(debugging) System.out.println("SearchNode(int k,RBNode node) -- 10");
            //if the current node key is lower then the key we look for
            //recursively call searchNode with the right child of the current node
            return SearchNode(k,node.Right);
        }
        
        if(debugging) System.out.println("SearchNode(int k,RBNode node) -- 11");
        //if the current node key is not bigger and not lower it equals to the key we are looking for
        return node;
    }

    /**
     * O(log(n))
     * public int insert(int k, String v)
     *
     * inserts an item with key k and value v to the red black tree.
     * the tree must remain valid (keep its invariants).
     * returns the number of color switches, or 0 if no color switches were necessary.
     * returns -1 if an item with key k already exists in the tree.
     */
    public int insert(int k, String v) 
    { 
        Boolean debugging = false;
        if(debugging) System.out.println("insert(int k, String v) -- 1");
        //find the place we want to insert the new node
        RBNode y = SearchNode(k,this.Root);
        //create new node which y is its parent
        RBNode z = new RBNode(v,k,y);
        //counter counts the number of color changes
        int counter = 0;
        if(y == null)
        {
            if(debugging) System.out.println("insert(int k, String v) -- 2");
            //empty tree
            this.Root.Left = z;
            z.Black = true;
            z.Parent = this.Root;
        }
        else
        {
            if(debugging) System.out.println("insert(int k, String v) -- 3");
            if(y.Key == z.Key)
            {
                if(debugging) System.out.println("insert(int k, String v) -- 4");
                //an item with the key k is  already exist in the tree
                return -1;
            }
            if(debugging) System.out.println("insert(int k, String v) -- 5");
            if(z.Key < y.Key)
            {
                
                if(debugging) System.out.println("insert(int k, String v) -- 6");
                //z will be a left child
                y.Left = z;
            }
            else
            {   
                if(debugging) System.out.println("insert(int k, String v) -- 7");
                //z will be a right child
                y.Right = z;
            }
            
            if(debugging) System.out.println("insert(int k, String v) -- 8");
            //calling the method that will check if the tree is valid and if not fix it
            counter = fixUpTree(z);
        }
        
        if(debugging) System.out.println("insert(int k, String v) -- 9");
        return counter;	
    }

    /**
     * O(log(n))
     * keep the red and black rules. this method will be called when the rules were been 
     * compromised and needs to be fix.
     * @param z - the node to start the fix from
     * @return the number of color changes that occured while fixing the tree
     */
    //changed this function to public for testing purposes
    public int fixUpTree (RBNode z)
    {
        Boolean debugging = false;
        //counter will count the number of color changes
        int counter = 0;
        if(debugging) System.out.println("fixUpTree(RBNode z) -- 1");
        //run until there is no problem with the red rule
        while(!z.Parent.Black)
        {
            if(debugging) System.out.println("fixUpTree(RBNode z) -- 3");
            if(z.Parent == z.Parent.Parent.Left)
            {
                if(debugging) System.out.println("fixUpTree(RBNode z) -- 4");
                //z parent is a left child
                RBNode y = z.Parent.Parent.Right;
                if(!y.Black)
                {
                    if(debugging) System.out.println("fixUpTree(RBNode z) -- 5");
                    //case 1: z'w parent and uncle are red
                    z.Parent.Black = true;
                    y.Black = true;
                    z.Parent.Parent.Black = false;

                    z = z.Parent.Parent;

                    //case 1 cost 3 color changes
                    counter += 3;
                }
                else
                {   
                    if(debugging) System.out.println("fixUpTree(RBNode z) -- 6");
                    if(z == z.Parent.Right)
                    {
                        
                        //case 2: z is a right child and its uncle is red. need to left rotate
                        // Fault see graph 1 z.Parent.Black = true; 
                        z = z.Parent;
			leftRotate(z);
                        
                        if(debugging) System.out.println("fixUpTree(RBNode z) -- 7");
                    }
                    //case 3: z is a left child and its uncle is red. need to right rotate
                    
                    z.Parent.Black = true; 
                    z.Parent.Parent.Black = false;
                    rightRotate(z.Parent.Parent);
                    counter += 2; 
                    if(debugging) System.out.println("fixUpTree(RBNode z) -- 8");
                }
            }
            else
            {
                if(debugging) System.out.println("fixUpTree(RBNode z) -- 9");
                //z parent is a right child
                RBNode y = z.Parent.Parent.Left;
                if(!y.Black)
                {
                    //case 1: z'w parent and uncle are red
                    z.Parent.Black = true;
                    y.Black = true;
                    z.Parent.Parent.Black = false;
                    z = z.Parent.Parent;

                    //case 1 cost 3 color changes
                    counter += 3;
                    if(debugging) System.out.println("fixUpTree(RBNode z) -- 10");
                }
                else
                {
                    if(debugging) System.out.println("fixUpTree(RBNode z) -- 11");
                    if(z == z.Parent.Left)
                    {
                        //case 2: z is a left child and its uncle is red. need to right rotate
                        z = z.Parent;
                        rightRotate(z);
                        if(debugging) System.out.println("fixUpTree(RBNode z) -- 12");
                    }
                    //case 3: z is a right child and its uncle is red. need to left rotate
                    z.Parent.Parent.Black = false;
                    z.Parent.Black = true; /* Fault found! Didn't set parent to Black since grandparent set to Red */
                    leftRotate(z.Parent.Parent);

                    //counter++; /* Fault found! Only added for the grandparent's color change, neglecting parent's color change */
                    counter += 2;
                    if(debugging) System.out.println("fixUpTree(RBNode z) -- 13");
                }
            }
        }
        if(debugging) System.out.println("fixUpTree(RBNode z) -- 14");
        if(!this.Root.Left.Black)
        {
            counter++;
            this.Root.Left.Black = true;
            if(debugging) System.out.println("fixUpTree(RBNode z) -- 15");
        }
        if(debugging) System.out.println("fixUpTree(RBNode z) -- 16");
        return counter;
    }

    /**
     * O(1)
     * put y as left child for x
     * @param x - the parent node
     * @param y - left child root
     */
    public void leftChild(RBNode x,RBNode y)
    {
        Boolean debugging = false;
        if(debugging) System.out.println("leftChild(RBNode x,RBNode y)-- 1");
        x.Left = y;
        y.Parent = x;
    }

    /**
     * O(1)
     * put y as right child of x
     * @param x - the parent node
     * @param y - the right child node
     */
    public void rightChild(RBNode x,RBNode y)
    {
        Boolean debugging = false;
        if(debugging) System.out.println("rightChild(RBNode x,RBNode y) -- 1");
        x.Right = y;
        y.Parent = x;
    }

    /**
     * O(1)
     * put y instead of x
     * @param x - the original child
     * @param y - the child after the change
     */
    public void transplate(RBNode x, RBNode y)
    {
        Boolean debugging = false;
        if(debugging) System.out.println("transplate(RBNode x, RBNode y) -- 1");
        if (x == x.Parent.Left)
        {
            if(debugging) System.out.println("transplate(RBNode x, RBNode y) -- 2");
            leftChild(x.Parent,y);
        }
        else
        {
            if(debugging) System.out.println("transplate(RBNode x, RBNode y) -- 3");
            rightChild(x.Parent,y);
        }
    }

    /**
     * O(1)
     * rotate the tree left (according to the principles discussed in class and can be
     * found in Book: Cormen - introduction to algorithms
     * @param x - the node to rotate from
     */
    public void leftRotate(RBNode x)
    {
        Boolean debugging = false;
        if(debugging) System.out.println("leftRotate(RBNode x) -- 1");
        RBNode y = x.Right;
        transplate(x,y);
        rightChild(x,y.Left);
        leftChild(y,x);
    }

    /**
     * O(1)
     * rotate the tree right (according to the principles discussed in class and can be
     * found in Book: Cormen - introduction to algorithms
     * @param x - the node to rotate from
     */
    public void rightRotate(RBNode y)
    {
        Boolean debugging = false;
        if(debugging) System.out.println("rightRotate(RBNode y)-- 1");
        RBNode x = y.Left;
        transplate(y,x);
        leftChild(y,x.Right);
        rightChild(x,y);
    }

    /**
     * O(log(n))
     * public int delete(int k)
     *
     * deletes an item with key k from the binary tree, if it is there;
     * the tree must remain valid (keep its invariants).
     * returns the number of color switches, or 0 if no color switches were needed.
     * returns -1 if an item with key k was not found in the tree.
     */
    public int delete(int k)
    {	
        Boolean debugging = true;
        if(debugging) System.out.println("delete(int k)-- 1");
        int counter = 0;
        RBNode z = SearchNode(k, this.Root);
        if(z.Key != k){
            if(debugging) System.out.println("delete(int k)-- 2");
            //item with the key k could not be found
            return -1;
        }
        if(debugging) System.out.println("delete(int k)-- 3");
        RBNode x;
        RBNode y = z;
        boolean isBlackOriginalY = y.Black;

        //z is the node we want to delete
        if(isNullNode(z.Left))
        {
            if(debugging) System.out.println("delete(int k)-- 4");
            x = z.Right;
            transplate(z,z.Right);
        
        }
        else if(isNullNode(z.Right))
        {
            if(debugging) System.out.println("delete(int k)-- 5");
            if(debugging) System.out.println("delete(int k)-- 6");
            x = z.Left;
            transplate(z,z.Left);
        }
        else
        {
            if(debugging) System.out.println("delete(int k)-- 5");
            if(debugging) System.out.println("delete(int k)-- 7");
            y = minimumNode(z.Right);
            isBlackOriginalY = y.Black;
            x = y.Right;
            if(y.Parent == z)
            {
                if(debugging) System.out.println("delete(int k)-- 8");
                    x.Parent = y;
            }
            else
            {
                if(debugging) System.out.println("delete(int k)-- 9");
                transplate(y,y.Right);
                y.Right = z.Right;
                y.Right.Parent = y;
            }
            if(debugging) System.out.println("delete(int k)-- 10");
            transplate(z,y);
            y.Left = z.Left;
            y.Black = z.Black;
            y.Left.Parent = y; /* Fault found! Didn't set y's left child to have y as parent */
        }
        if(debugging) System.out.println("delete(int k)-- 11");
        if(isBlackOriginalY)
        {
            if(debugging) System.out.println("delete(int k)-- 12");
            //we have a problem with the black rule that needs to be fixed
            counter = deleteFixup(x);
        }
        if(debugging) System.out.println("delete(int k)-- 13");
        return counter;
    }

    /**
     * O(log(n))
     * fix the red and black rules after deleting a node.
     * @param x - the node to start the fixing from
     * @return number of color changes made while fixing the tree
     */
    public int deleteFixup(RBNode x)
    {
        Boolean debugging = false;
        //number of color changes
        int counter = 0;
        if(debugging) System.out.println("deleteFixup(RBNode x) -- 1");
        //run until x is the tree root and as long as x is black
        while(x != this.Root.Left && x.Black)
        {
            if(debugging) System.out.println("deleteFixup(RBNode x) -- 2"); // can't put 2 in while condition
            if(debugging) System.out.println("deleteFixup(RBNode x) -- 3");
            if(x == x.Parent.Left)
            {
                if(debugging) System.out.println("deleteFixup(RBNode x) -- 4");
                //x is a left child
                RBNode w = x.Parent.Right;
                if(debugging) System.out.println("w.value == "+w.Value);
                if(!w.Black)
                {
                    if(debugging) System.out.println("deleteFixup(RBNode x) -- 5");
                    //case 1
                    w.Black = true;
                    x.Parent.Black = false;
                    leftRotate(x.Parent);
                    w = x.Parent.Right;
                    if(debugging) System.out.println("w.value == "+w.Value);
                    counter += 2;
                }
                if(debugging) System.out.println("deleteFixup(RBNode x) -- 6");
                if(w.Left.Black && w.Right.Black)
                {
                    if(debugging) System.out.println("deleteFixup(RBNode x) -- 7");
                    //case 2
                    w.Black = false;
                    x = x.Parent;
                    if(debugging) System.out.println("x.value == "+x.Value);
                    counter += 1;
                }
                else 
                {
                    if(debugging) System.out.println("deleteFixup(RBNode x) -- 8");
                    if(w.Right.Black)
                    {
                        if(debugging) System.out.println("deleteFixup(RBNode x) -- 9");
                        //case 3 
                        w.Left.Black = true;
                        w.Black = false;
                        rightRotate(w);
                        w = x.Parent.Right;
                        if(debugging) System.out.println("w.value == "+w.Value);
                        counter +=2;
                    }
                    if(debugging) System.out.println("deleteFixup(RBNode x) -- 10");
                    //case 4
                    w.Black = x.Parent.Black;
                    x.Parent.Black = true;
                    w.Right.Black = true;
                    leftRotate(x.Parent);
                    x = this.Root.Left;
                    if(debugging) System.out.println("x.value == "+x.Value);
                    counter += 1;
                }
            }
            else
            {
                if(debugging) System.out.println("deleteFixup(RBNode x) -- 11");
                //x is a right child
                RBNode w = x.Parent.Left;
                if(debugging) System.out.println("w.Value == " + w.Value);
                if(!w.Black){
                    if(debugging) System.out.println("deleteFixup(RBNode x) -- 12");
                    //case 1
                    w.Black = true;
                    x.Parent.Black = false;
                    rightRotate(x.Parent);
                    w = x.Parent.Left;
                    if(debugging) System.out.println("w.value == "+w.Value);
                    counter += 2;
                }
                
                if(debugging) System.out.println("deleteFixup(RBNode x) -- 13");
                if(w.Left.Black && w.Right.Black)
                {
                    if(debugging) System.out.println("deleteFixup(RBNode x) -- 14");
                    //case 2
                    w.Black = false;
                    x = x.Parent;
                    if(debugging) System.out.println("x.value == "+x.Value);
                    counter += 1;
                }
                else 
                {
                    if(debugging) System.out.println("deleteFixup(RBNode x) -- 15");
                    if(w.Left.Black)
                    {
                        if(debugging) System.out.println("deleteFixup(RBNode x) -- 16");
                        //case 3 
                        w.Right.Black = true;
                        w.Black = false;
                        leftRotate(w);
                        w = x.Parent.Left;
                        if(debugging) System.out.println("w.value == "+w.Value);
                        counter +=2;
                    }
                    if(debugging) System.out.println("deleteFixup(RBNode x) -- 17");
                    //case 4
                    w.Black = x.Parent.Black;
                    x.Parent.Black = true;
                    w.Left.Black = true;
                    rightRotate(x.Parent);
                    x = this.Root.Left;
                    if(debugging) System.out.println("x.value == "+x.Value);
                    counter +=1;
                }
            }
        }
        if(debugging) System.out.println("deleteFixup(RBNode x) -- 2"); // can't put 2 in while condition
        if(debugging) System.out.println("deleteFixup(RBNode x) -- 18");
        if(x.Black == false)
        {
            if(debugging) System.out.println("deleteFixup(RBNode x) -- 19");
            x.Black = true;
            counter += 1;
        }

        if(debugging) System.out.println("deleteFixup(RBNode x) -- 20");
        return counter;
    }

    /**
     *  O(log(n))
     * public String min()
     *
     * @return the value of the item with the smallest key in the tree,
     * or null if the tree is empty
     */
    public String min()
    {
        Boolean debugging = false;
        if(debugging) System.out.println("min() -- 1");
        
        /* Fault found! Didn't check if tree is empty to avoid null pointer exception */
        if(this.empty())
        {
            if(debugging) System.out.println("min() -- 2");
            return null;
        }
        
        if(debugging) System.out.println("min() -- 3");
        return minimumNode(this.Root.Left).Value;
    }

    /**
     *  O(log(n))
     * return the node with the minimal key in the tree
     * @param node - the node to start looking from
     * @return the minimal node of the tree
     */
    public static RBNode minimumNode(RBNode node)
    {
        Boolean debugging = false;
        
        if(debugging) System.out.println("minimumNode(RBNode node) -- 1");
        if(isNullNode(node))
        {
            if(debugging) System.out.println("minimumNode(RBNode node) -- 2");
            return null;
        }

        
        if(debugging) System.out.println("minimumNode(RBNode node) -- 3");
        //next smaller node is null node so this is the minimal node
        if(isNullNode(node.Left))
        {
            if(debugging) System.out.println("minimumNode(RBNode node) -- 4");
            return node;
        }
        
        if(debugging) System.out.println("minimumNode(RBNode node) -- 5");
        return minimumNode(node.Left);
    }

    /**
     * O(1)
     * check if the given node is an infinity node
     * @param node - the node to check
     * @return true if it is an infinity node. O.W false
     */
    public boolean isInfinityNode(RBNode node)
    {
        Boolean debugging = false;
        
        if(debugging) System.out.println("isInfinityNode(RBNode node) -- 1");
        return node.Key == Integer.MAX_VALUE;
    }

    /**
     * O(1)
     * check if the given node is a null node
     * @param node - the node to check
     * @return true if it is an null node. O.W false
     */
    public static boolean isNullNode(RBNode node)
    {
        Boolean debugging = false;
        
        if(debugging) System.out.println("isNullNode(RBNode node) -- 1");
        return node.Key == Integer.MIN_VALUE;
    }

    /**
     *  O(log(n))
     * public String max()
     *
     * @return  the value of the item with the largest key in the tree,
     * or null if the tree is empty
     */
    public String max()
    {
        Boolean debugging = false;
        
        if(debugging) System.out.println("max() -- 1");
        if(this.empty())
        {
            if(debugging) System.out.println("max() -- 2");
            return null;
        }

        if(debugging) System.out.println("max() -- 3");
        return maxValue(this.Root.Left);

    }

    /**
     *  O(log(n))
     * Returns the value of the item with the largest key in the tree,
     * @param node the node to start looking from
     * @return the value of the minimal node in the tree
     */
    public static String maxValue(RBNode node)
    {
        Boolean debugging = false;
        
        if(debugging) System.out.println("maxValue(RBNode node) -- 1");
        
        //next node is null node so return this node
        if(isNullNode(node.Right))
        {
            if(debugging) System.out.println("maxValue(RBNode node) -- 2");
            return node.Value;
        }

        if(debugging) System.out.println("maxValue(RBNode node) -- 3");
        return maxValue(node.Right);
    }

    /**
     *  O(n)
     * public int[] keysToArray()
     *
     * @return a sorted array which contains all keys in the tree,
     * or an empty array if the tree is empty.
     */
    public int[] keysToArray()
    {
        Boolean debugging = false;
        
        if(debugging) System.out.println("keysToArray() -- 1");
        String keysString = ElementsToString(this.Root,true);
        
        //keysString is a string of all the keys in the tree separated by ","
        if(keysString.equals(""))
        {
            if(debugging) System.out.println("keysToArray() -- 2");
            return new int[0];
        }
        
        if(debugging) System.out.println("keysToArray() -- 3");
        return ArrayOfStringsToArrayOfInts(keysString.split(","));              
    }

    /**
     * O(strArr length)
     * @param strArr - array of string values (that can be parsed into integers)
     * @return array of the same values cast as int
     */
    public int[] ArrayOfStringsToArrayOfInts(String[] strArr)
    {
        Boolean debugging = false;
        
        if(debugging) System.out.println("ArrayOfStringsToArrayOfInts(String[] strArr) -- 1");
        int[] arr = new int[strArr.length];
        // for(int i=0; i<= strArr.length;i++) /* Fault found! Goes through extra index */
        for(int i=0; i< strArr.length;i++)
        {
            if(debugging) System.out.println("ArrayOfStringsToArrayOfInts(String[] strArr) -- 2"); /* can't place in for loop conditional */
            if(debugging) System.out.println("ArrayOfStringsToArrayOfInts(String[] strArr) -- 3");
            arr[i] = Integer.parseInt(strArr[i]);
        }
        if(debugging) System.out.println("ArrayOfStringsToArrayOfInts(String[] strArr) -- 2"); /* can't place in for loop conditional */
        
        if(debugging) System.out.println("ArrayOfStringsToArrayOfInts(String[] strArr) -- 4");
        return arr;
    }


    /**
     * O(n)
     * @param node - the node we start from
     * @param key - if true returns the string with keys elements else return the string with value elements
     * @return a string with values\keys seperated with ,
     */
    public String ElementsToString(RBNode node,boolean key)
    {
        Boolean debugging = false;
        
        if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 1");
        if(isNullNode(node))
        {
            if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 2");
            return "";
        }

        if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 3");
        //if called with the infinity node recursively call with the real root
        if(isInfinityNode(node))
        {
            if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 4");
            return ElementsToString(node.Left,key); 
        }

        if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 5");
        String str;
        if(key)
        {
            if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 6");
            //str will be the key
            str = Integer.toString(node.Key);
        }
        else
        {
            if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 7");
            //str will be the value
            str = node.Value;
        }

        if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 8");
        //str is the element needs to be insert in the returning string
        if(!isNullNode(node.Left) && !isNullNode(node.Right))
        {
            if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 9");
            //return all the elements, bigger and smaller then the current node
            return ElementsToString(node.Left,key) + "," + str + "," + ElementsToString(node.Right,key);
        }

        if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 10");
        if(!isNullNode(node.Right))
        {
            if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 11");
            //there is no lower elements return the current element + all the elements that bigger
            return str + "," + ElementsToString(node.Right,key);
        }

        if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 12");
        if(!isNullNode(node.Left))
        {
            if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 13");
            //there is no higher elements. return all the elements that are lower than the current element
            return ElementsToString(node.Left,key) + "," + str;
        }

        if(debugging) System.out.println("ElementsToString(RBNode node,boolean key) -- 14");
        return str;
    }

    /**
     * O(n)
     * public String[] valuesToArray()
     *
     * @return an array which contains all values in the tree,
     * sorted by their respective keys,
     * or an empty array if the tree is empty.
     */
    public String[] valuesToArray()
    {
        Boolean debugging = false;
        
        if(debugging) System.out.println("valuesToArray() -- 1");
        String valuesString = ElementsToString(this.Root.Left,false);
        //valuesString is a string with all the values saperated with ","
        return valuesString.split(",");
    }

    /**
     * O(n)
     * print out this RBTree level by level.
     */
    public void print() 
    {
        Queue<RBNode> queue = new LinkedList<>();
        queue.add(this.Root);
        while (!queue.isEmpty()) 
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) 
            {
                RBNode curNode = queue.poll();
                System.out.print(curNode.Key + " " + curNode.Value + " " + (curNode.Black? "black" : "red") + " | ");
                if (curNode.Left != null) 
                {
                        queue.add(curNode.Left);
                }
                if (curNode.Right != null) 
                {
                        queue.add(curNode.Right);
                }
            }
            System.out.print('\n');
        }
    }

    /**
     * O(log(n))
     * public int size()
     *
     *
     * precondition: none
     * postcondition: none
     * @return the number of nodes in the tree.
     */
    public int size()
    {
        Boolean debugging = false;
        
        if(debugging) System.out.println("size() -- 1");
        if(this.empty())
        {
            if(debugging) System.out.println("size() -- 2");
            return 0;
        }

        if(debugging) System.out.println("size() -- 3");
        return sizeCalc(this.Root.Left);
    }

    /**
     * O(log(n))
     * @param node the node to start from
     * @return the amount of all nodes "under" that node
     */
    public static int sizeCalc(RBNode node)
    {
        Boolean debugging = false;
        
        if(debugging) System.out.println("sizeCalc(RBNode node) -- 1");
        //count from both sides
        if(!isNullNode(node.Left) && !isNullNode(node.Right))
        {
            if(debugging) System.out.println("sizeCalc(RBNode node) -- 2");
            //return 2 + sizeCalc(node.Left) + sizeCalc(node.Right); /* Fault found! Added 2 instead of just this 1 node to size */
            return 1 + sizeCalc(node.Left) + sizeCalc(node.Right);
        }

        if(debugging) System.out.println("sizeCalc(RBNode node) -- 3");
        //count with higher side
        if(!isNullNode(node.Left))
        {
            if(debugging) System.out.println("sizeCalc(RBNode node) -- 4");
            return 1 + sizeCalc(node.Left);
        }

        if(debugging) System.out.println("sizeCalc(RBNode node) -- 5");
        //count with lower side
        if(!isNullNode(node.Right))
        {
            if(debugging) System.out.println("sizeCalc(RBNode node) -- 6");
            return 1 + sizeCalc(node.Right);
        }

        if(debugging) System.out.println("sizeCalc(RBNode node) -- 7");
        return 1;
    }

    /**
     * public class RBNode
     *
     *	An implementation of a node for the RBTree.
     */
    public class RBNode
    {
        String Value; // wkh change to private
        int Key;
        RBNode Left,Right,Parent; // wkh change to private
        boolean Black; // wkh change to private

        /**
         * O(1)
         * new node object
         * @param value - value of the node
         * @param key - the key of the node
         * @param left - the left child node
         * @param right - the right child node
         * @param parent - the parent node
         */
        public RBNode(String value,int key, RBNode left, RBNode right,RBNode parent)
        {
            this.Value = value;
            this.Key = key;
            this.Left = left;
            this.Right = right;
            this.Parent = parent;
            this.Black = false;
        }

        /**
         * O(1)
         * create node with null nodes children
         * @param value - the value for the node
         * @param key - the key for the node 
         * @param parent - the parent node
         */
        public RBNode(String value,int key, RBNode parent)
        {
            this(value, key, null, null, parent);
            this.Left = createNullNode(this);
            this.Right = createNullNode(this);
        }
    }
    
    public static void main(String[] args) 
    {
    }
}
