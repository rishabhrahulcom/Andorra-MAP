package com.rishabhrahul.map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OSMGraphParser {

    // this class will read the JSON and try to build a graph out of it
   public static Graph buildGraphFromJSON(String graphFileLocation) {

       Graph graph = new Graph();
       Map<Long, GraphNode> nodesMap = new HashMap<Long, GraphNode>();
    try {

       ObjectMapper mapper = new ObjectMapper();
       JsonNode root = mapper.readTree(new File(graphFileLocation));
       for (JsonNode node : root.get("nodes")) {
           long label = node.get("id").asLong();
            double lat = node.get("lat").asDouble();
            double lon = node.get("lon").asDouble();
            GraphNode graphNode = new GraphNode(label,lat,lon);
            nodesMap.put(label,graphNode);
            graph.addNode(graphNode.getLabel());
       }

       for (JsonNode way : root.get("ways")) {
           JsonNode label = way.get("nodes");
           for(int i = 0 ; i < label.size()-1; i++) {
               long from = label.get(i).asLong();
               long to = label.get(i+1).asLong();
               if(nodesMap.containsKey(from) && nodesMap.containsKey(to)) {
                   GraphNode fromNode = nodesMap.get(from);
                   GraphNode toNode = nodesMap.get(to);
                   double weight = calculateDistance(fromNode,toNode);
                   graph.addEdge(fromNode.getLabel(),toNode.getLabel(),weight);
               }
           }
       }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
return graph;
   }

   private  static double calculateDistance(GraphNode from, GraphNode to) {

       double latFrom = from.getLatitude();
       double latTo = to.getLatitude();
       double lonFrom = from.getLongitude();
       double lonTo = to.getLongitude();
       double deltaLat = Math.toRadians(latTo - latFrom);
       double deltaLon = Math.toRadians(lonTo - lonFrom);
        // no idea
       double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)+ Math.cos(Math.cos(latFrom) * Math.cos(latTo))
               * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return c *6371;
   }

}
