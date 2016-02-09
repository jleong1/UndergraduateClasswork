import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;

import java.util.*;

public class NetworkTest 
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (NetworkTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main          
    
    protected Network network;         
    
    @Before
    public void runBeforeEachTest() 
    {   
        network = new Network();                        
    } // method runBeforeEachTest

    @Test 
    public void testAddVertex1()      
    {
        network.addVertex ("a");
        assertEquals ("{a={}}", network.toString());                                            
    } // method testAddVertex1

    @Test 
    public void testAddVertex2()      
    {
        network.addVertex ("a");
        network.addVertex ("b");        
        assertEquals ("{a={}, b={}}", network.toString());                                            
    } // method testAddVertex2
        
    @Test 
    public void testAddVertex3()      
    {
        network.addVertex ("a");
        network.addVertex ("b");
        assertEquals (false, network.addVertex ("a"));                                              
    } // method testAddVertex2
    
    @Test (expected = NullPointerException.class)
    public void testAddVertexNull()      
    {
        network.addVertex (null);
    } // method testAddVertexNull
    
    @Test 
    public void testRemoveVertex1()      
    {
        network.addVertex ("a");
        network.addVertex ("b"); 
        assertEquals (true, network.removeVertex ("b")); 
        assertEquals ("{a={}}", network.toString());
    } // method testRemoveVertex1

    @Test 
    public void testRemoveVertex2()      
    {
        network.addVertex ("a");
        network.addVertex ("b"); 
        assertEquals (false, network.removeVertex ("c"));  
        assertEquals ("{a={}, b={}}", network.toString()); 
    } // method testRemoveVertex2
    
    @Test (expected = NullPointerException.class)
    public void testRemoveVertexNull()      
    {
        network.removeVertex (null);
    } // method testRemoveVertexNull
    
    @Test
    public void testContainsVertex1()
    {
        network.addVertex ("a");
        network.addVertex ("b"); 
        assertEquals (true, network.containsVertex ("b")); 
    } // method testContainsVertex1

    @Test
    public void testContainsVertex2()
    {
        network.addVertex ("a");
        network.addVertex ("b"); 
        assertEquals (false, network.containsVertex ("c")); 
    } // method testContainsVertex2
    
    @Test (expected = NullPointerException.class)
    public void testContainsVertexNull()      
    {
        network.containsVertex (null);
    } // method testContainsVertexNull
    
    @Test 
    public void testAddEdge1()      
    {
        network.addEdge ("a", "b", 5);
        assertEquals ("{a={b=5.0}, b={}}", network.toString());
    } // method testAddEdge1
    
    @Test 
    public void testAddEdge2()      
    {
        network.addEdge ("a", "b", 5);
        network.addEdge ("a", "c", 7);
        network.addEdge ("b", "d", 4);
        assertEquals ("{a={b=5.0, c=7.0}, b={d=4.0}, c={}, d={}}", network.toString());
    } // method testAddEdge2    
    
    @Test (expected = NullPointerException.class)
    public void testAddEdgeNull()      
    {
        network.addEdge (" ", null, 0);
    } // method testAddEdgeNull
    
    @Test 
    public void testGetEdgeWeight1()      
    {
        network.addEdge ("a", "b", 5);
        network.addEdge ("a", "c", 7);
        network.addEdge ("b", "d", 4);
        assertEquals (7, network.getEdgeWeight ("a", "c"), 0.0000001);
    } // method testGetEdgeWeight1 
    
    @Test 
    public void testGetEdgeWeight2()      
    {
        network.addEdge ("a", "b", 5);
        network.addEdge ("a", "c", 7);
        network.addEdge ("b", "d", 4);
        network.removeVertex ("b");
        assertEquals (-1, network.getEdgeWeight ("a", "b"), 0.0000001);
        assertEquals (-1, network.getEdgeWeight ("b", "d"), 0.0000001);
        assertEquals (7, network.getEdgeWeight ("a", "c"), 0.0000001);
    } // method testGetEdgeWeight2 
    
    @Test (expected = NullPointerException.class)
    public void testGetEdgeWeightNull()      
    {
        network.getEdgeWeight (" ", null);
    } // method testGetEdgeWeightNull   
    
    @Test 
    public void testRemoveEdge1()      
    {
        network.addEdge ("a", "b", 5);
        network.addEdge ("a", "c", 7);
        network.addEdge ("b", "d", 4);
        network.removeEdge ("a", "b");
        assertEquals ("{a={c=7.0}, b={d=4.0}, c={}, d={}}", network.toString());
    } // method testRemoveEdge1 
    
    @Test 
    public void testRemoveEdge2()      
    {
        network.addEdge ("a", "b", 5);
        network.addEdge ("a", "c", 7);
        network.addEdge ("b", "d", 4);
        assertEquals (false, network.removeEdge ("a", "d"));        
    } // method testRemoveEdge2 
    
    @Test (expected = NullPointerException.class)
    public void testRemoveEdgeNull()      
    {
        network.removeEdge (" ", null);
    } // method testRemoveEdgeNull
    
    @Test 
    public void testNeighbors1()    
    {
        network.addEdge ("a", "b", 5);
        network.addEdge ("a", "c", 7);
        network.addEdge ("b", "d", 4);        
        assertEquals ("[b, c]", network.neighbors ("a").toString());
    } // method testNeighbors1
    
    @Test 
    public void testNeighbors2()    
    {
        network.addEdge ("a", "b", 5);
        network.addEdge ("a", "c", 7);
        network.addEdge ("b", "d", 4);       
        assertEquals ("[]", network.neighbors ("c").toString());
    } // method testNeighbors2
    
    @Test (expected = NullPointerException.class)
    public void testNeighborsNull()    
    {
        network.neighbors (null);
    } // method testNeighborsNull
    
    @Test
    public void testEquals1()
    {
        network.addEdge ("S", "A", 2);
        network.addEdge ("S", "B", 6);
        network.addEdge ("S", "C", 5);
        network.addEdge ("A", "D", 8);
        network.addEdge ("B", "C", 2);
        network.addEdge ("B", "D", 3);
        network.addEdge ("B", "E", 2);
        network.addEdge ("D", "T", 5);
        network.addEdge ("D", "E", 3);
        network.addEdge ("E", "T", 1);
        network.addEdge ("C", "F", 2);
        network.addEdge ("F", "T", 10);
        
        Network<String> otherNetwork = new Network<String>();                
        otherNetwork.addEdge ("F", "T", 10);
        otherNetwork.addEdge ("C", "F", 2);
        otherNetwork.addEdge ("E", "T", 1);
        otherNetwork.addEdge ("D", "E", 3);
        otherNetwork.addEdge ("D", "T", 5);
        otherNetwork.addEdge ("B", "E", 2);
        otherNetwork.addEdge ("B", "D", 3);
        otherNetwork.addEdge ("B", "C", 2);
        otherNetwork.addEdge ("A", "D", 8);
        otherNetwork.addEdge ("S", "C", 5);
        otherNetwork.addEdge ("S", "B", 6);
        otherNetwork.addEdge ("S", "A", 2);
        assertEquals (true, network.equals (otherNetwork));        
    } // method testEquals1
    
    @Test
    public void testEquals2()
    {
        String other = "No way!";
        assertEquals (false, network.equals (other));
    } // method testEquals2
        
    @Test
    public void testEqualsNull()
    {        
        assertEquals (false, network.equals (null));
    } // method testEqualsNull
    
    @Test
    public void testIsConnected1()
    {        
        network.addEdge ("A", "B", 8);
        network.addEdge ("A", "C", 2);
        network.addEdge ("B", "D", 3);
        network.addEdge ("C", "D", 2);        
        network.addEdge ("D", "A", 3);        
        assertEquals (true, network.isConnected());
    } // method testIsConnected1
    
    @Test
    public void testIsConnected2()
    {
        network.addEdge ("S", "A", 2);
        network.addEdge ("S", "B", 6);
        network.addEdge ("S", "C", 5);
        network.addEdge ("A", "D", 8);
        network.addEdge ("B", "C", 2);
        network.addEdge ("B", "D", 3);
        network.addEdge ("B", "E", 2);
        network.addEdge ("D", "T", 5);
        network.addEdge ("D", "E", 3);
        network.addEdge ("E", "T", 1);
        network.addEdge ("C", "F", 2);        
        assertEquals (false, network.isConnected());
    } // method testIsConnected2
    
    @Test 
    public void testIterator1()      
    {
        network.addEdge ("A", "B", 16);
        network.addEdge ("A", "F", 5);
        network.addEdge ("B", "D", 3);        
        network.addEdge ("C", "D", 15);
        network.addEdge ("B", "C", 4);    
        Iterator<String> itr = network.iterator();
        assertEquals ("A", itr.next());
        assertEquals ("B", itr.next());
        assertEquals ("C", itr.next());
        assertEquals ("D", itr.next());
        assertEquals ("F", itr.next());        
    } // method testIterator1
    
    @Test 
    public void testBreadthFirstIterator1()      
    {
        network.addEdge ("A", "B", 16);
        network.addEdge ("A", "F", 5);
        network.addEdge ("B", "D", 3);        
        network.addEdge ("C", "D", 15);
        network.addEdge ("B", "C", 4);  
        Iterator<String> itr = network.breadthFirstIterator ("A");
        assertEquals ("A", itr.next());
        assertEquals ("B", itr.next());
        assertEquals ("F", itr.next());
        assertEquals ("C", itr.next());
        assertEquals ("D", itr.next());        
    } // method testBreadthFirstIterator1
    
    @Test (expected = NullPointerException.class)
    public void testBreadthFirstIteratorNull()      
    {
        network.breadthFirstIterator (null);
    } // method testBreadthFirstIteratorNull
    
    @Test 
    public void testDepthFirstIterator1()      
    {
        network.addEdge ("A", "B", 16);
        network.addEdge ("A", "F", 5);
        network.addEdge ("B", "D", 3);        
        network.addEdge ("C", "D", 15);
        network.addEdge ("B", "C", 4);   
        Iterator<String> itr = network.depthFirstIterator ("A");
        assertEquals ("A", itr.next());
        assertEquals ("F", itr.next());
        assertEquals ("B", itr.next());
        assertEquals ("D", itr.next());
        assertEquals ("C", itr.next());        
    } // method testDepthFirstIterator1
    
    @Test (expected = NullPointerException.class)
    public void testDepthFirstIteratorNull()      
    {
        network.depthFirstIterator (null);
    } // method testDepthFirstIteratorNull
    
    @Test
    public void testShortest1()
    {        
        network.addEdge ("A", "B", 16);
        network.addEdge ("A", "C", 5);
        network.addEdge ("B", "D", 3);        
        network.addEdge ("C", "D", 15);       
        assertEquals ("[A, B, D, 19.0]", network.getShortestPath ("A", "D").toString());
    } // method testShortest1
    
    @Test
    public void testShortest2()
    {        
        network.addEdge ("A", "B", 16);
        network.addEdge ("A", "C", 5);
        network.addEdge ("B", "D", 3);        
        network.addEdge ("C", "D", 15);
        network.addEdge ("B", "F", 4);        
        assertEquals ("[-1.0]", network.getShortestPath ("C", "F").toString());
    } // method testShortest2
    
    @Test
    public void testShortest3()
    {
        network.addEdge ("S", "A", 2);
        network.addEdge ("S", "B", 6);
        network.addEdge ("S", "C", 5);
        network.addEdge ("A", "D", 8);
        network.addEdge ("B", "C", 2);
        network.addEdge ("B", "D", 3);
        network.addEdge ("B", "E", 2);
        network.addEdge ("D", "T", 5);
        network.addEdge ("D", "E", 3);
        network.addEdge ("E", "T", 1);
        network.addEdge ("C", "F", 2);
        network.addEdge ("F", "T", 10);
        assertEquals ("[S, B, E, T, 9.0]", network.getShortestPath ("S", "T").toString());
    } // method testShortest3
    
    @Test (expected = NullPointerException.class)
    public void testGetShortestPathNull()      
    {
        network.getShortestPath (" ", null);
    } // method testGetShortestPathNull
    
    @Test
    public void testCopyConstructor()
    {
        network.addEdge ("a", "b", 5);
        network.addEdge ("a", "c", 7);
        network.addEdge ("b", "d", 4);
        Network<String> myNetwork = new Network<String> (network);         
        assertEquals (network, myNetwork);       
        network.addEdge ("d", "e", 3);
        assertNotSame (network, myNetwork);       
    } // testCopyConstructor
    
    @Test (expected = NullPointerException.class)
    public void testCopyConstructorNull()      
    {
        network = new Network (null);
    } // method testCopyConstructorNull  
    
    @Test
    public void testSpanning1()
    {
        network.addEdge ("A", "B", 5);
        network.addEdge ("B", "A", 5);
        network.addEdge ("A", "C", 18);
        network.addEdge ("C", "A", 18);
        network.addEdge ("A", "D", 7);
        network.addEdge ("D", "A", 7);
        network.addEdge ("B", "E", 3);
        network.addEdge ("E", "B", 3);
        network.addEdge ("C", "E", 28);
        network.addEdge ("E", "C", 28);
        network.addEdge ("C", "F", 20);
        network.addEdge ("F", "C", 20);
        network.addEdge ("D", "F", 8);
        network.addEdge ("F", "D", 8);
        network.addEdge ("D", "G", 2);
        network.addEdge ("G", "D", 2);
        network.addEdge ("F", "G", 4);
        network.addEdge ("G", "F", 4);
        
        UndirectedWeightedTree tree = network.getMinimumSpanningTree();
        assertEquals (true, tree.isConnected());                  // Is tree
        assertEquals (tree.getEdgeCount() / 2, tree.size() - 1);  //    a tree?
        assertEquals (tree.size(), network.size());               // Does tree span network?
        assertEquals (true, tree.containsEdge ("A", "B"));
        assertEquals (true, tree.containsEdge ("A", "C"));
        assertEquals (true, tree.containsEdge ("A", "D"));
        assertEquals (true, tree.containsEdge ("E", "B"));
        assertEquals (true, tree.containsEdge ("D", "G"));
        assertEquals (true, tree.containsEdge ("G", "F"));
    } // method testSpanning1
    
    @Test
    public void testSpanning2()
    {
        network.addEdge ("A", "B", 5);
        network.addEdge ("B", "A", 5);       
        
        UndirectedWeightedTree tree = network.getMinimumSpanningTree();
        assertEquals (true, tree.isConnected());                  // Is tree
        assertEquals (tree.getEdgeCount() / 2, tree.size() - 1);  //    a tree?
        assertEquals (tree.size(), network.size());               // Does tree span network?
        assertEquals (5, (int)(tree.getEdgeWeight ("B", "A")));
    } // method testSpanning2
    
} // NetworkTest class