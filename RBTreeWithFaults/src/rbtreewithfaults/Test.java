/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbtreewithfaults;

/**
 *
 * @author William
 */
public class Test 
{
    public boolean test()
    {
        RBTreeWithFaults tree = new RBTreeWithFaults();
        RBTreeWithFaults.RBNode node = tree.new RBNode("Hi", 10, null, null, null);
        
        tree.print();
        
        tree.insert(10, "hell0");
        
        tree.print();
        
        return true;
    }
    
}
