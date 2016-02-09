    public String toString()
    {
       UndirectedNetwork<Vertex> newNetwork = new UndirectedNetwork<Vertex>(); 
       
       for (Map.Entry<Vertex, TreeMap<Vertex, Double>> entry : adjacencyMap.entrySet())
       {
           Vertex key = entry.getKey();
           
           TreeMap<Vertex, Double> neighborMap = new TreeMap<Vertex, Double>();
           for (Map.Entry<Vertex, Double> neighborEntry : adjacencyMap.get (key).entrySet())
           {
               Vertex neighborKey = neighborEntry.getKey();               
               if (!newNetwork.containsVertex (neighborKey))
                   neighborMap.put (neighborKey, neighborEntry.getValue());               
           } // iterating over neighbors of key
           if (!neighborMap.isEmpty())
              newNetwork.adjacencyMap.put (key, neighborMap);           
       } // iterating over entries in adjacencyMap
       return newNetwork.adjacencyMap.toString();
    } // method toString()       