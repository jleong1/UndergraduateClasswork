import java.util.*;

public class UndirectedNetworkExample
{
    public static void main (String[ ] args)
    {
        new UndirectedNetworkExample().run();
    } // main
    
    public void run()
    {
        final String PROMPT1 =
            "\nPlease enter the vertices whose shortest path you want: ";
        final String SENTINEL = "***";
        final String PROMPT2 = " \nPlease enter " +
            "two vertices and a weight (or " + SENTINEL + " to quit): ";
        final String SHORTEST_PATH_MESSAGE1 =
            "\n\n\nThe shortest path from ";
        final String SHORTEST_PATH_MESSAGE2 = " and its total weight are ";
        final String REMOVAL_MESSAGE = "\n\niterating over network after removing B-C and D:";
        
        UndirectedNetwork<String> network = new UndirectedNetwork<String>();
        
        Scanner sc = new Scanner (System.in);
        
        String start,
               finish,
               vertex1,
               vertex2;
        
        double weight;
        try
        {
            // Get start and finish vertices.
            System.out.print (PROMPT1);
            start = sc.next();
            finish = sc.next();
            
            // Get edges and weights.
            while (true)
            {
                System.out.print (PROMPT2);
                vertex1 = sc.next();
                if (vertex1.equals(SENTINEL))
                     break;
                vertex2 = sc.next();
                weight = sc.nextDouble();
                network.addEdge (vertex1, vertex2, weight);
            } // while
            System.out.println ("\nnetwork = " + network);
            
            LinkedList<Object> pathList = network.getShortestPath (start, finish);
            System.out.println (SHORTEST_PATH_MESSAGE1 + start + " to " +
                                finish + SHORTEST_PATH_MESSAGE2 + pathList);
            
            LinkedList<String> neighbors = network.neighbors (start);
            System.out.println ("neighbors of " + start + ": " + network.neighbors (start));
            network.addEdge (start, "Q", 1.0);
            System.out.println ("neighbors of " + start + ", including Q: " + network.neighbors (start));

            boolean networkIsConnected = network.isConnected();
            System.out.println ("is connected: " + networkIsConnected);
            if (networkIsConnected)
                System.out.println ("spanning tree: " + network.getMinimumSpanningTree());
            
            System.out.println ("is empty: " + network.isEmpty());
            System.out.println ("vertex count: " + network.size());
            System.out.println ("edge count: " + network.getEdgeCount());
            System.out.println ("contains Q:  " + network.containsVertex ("Q"));
            System.out.println ("contains edge S D: " + network.containsEdge ("S", "D"));
            System.out.println ("contains edge B D: " + network.containsEdge ("B", "D"));

            System.out.println ("\n\nbreadth-first iterating from " + start + ": ");
            Iterator<String> itr = network.breadthFirstIterator (start);
            while (itr.hasNext())
                System.out.print (itr.next() + " ");
            
            System.out.println ("\n\ndepth-first iterating from " + start + ": ");
            itr = network.depthFirstIterator (start);
            while (itr.hasNext())
                System.out.print (itr.next() + " ");
            
            System.out.println ("\n\niterating over network:");
            for (String s : network)
                System.out.print (s + " ");
            
            network.removeEdge ("B", "C");
            network.removeVertex ("D");
            System.out.println (REMOVAL_MESSAGE);
            for (String s : network)
                System.out.print (s + " ");
            System.out.println ("\n\nedge weight of A B: " +
                                network.getEdgeWeight ("A", "B"));
            
            pathList = network.getShortestPath (start, finish);
            System.out.println (SHORTEST_PATH_MESSAGE1 + start + " to " +
                                finish + SHORTEST_PATH_MESSAGE2 + pathList);
        } // try
        catch (Exception e)
        {
            System.out.println (e);
        } // catch
    } // method run
} // class UndirectedNetworkExample
