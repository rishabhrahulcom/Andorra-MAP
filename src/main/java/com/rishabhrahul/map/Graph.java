package com.rishabhrahul.map;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;


public class Graph {
    // Node have a label represented by string it can be Integer also
    private Map<Long, GraphNode> nodes;
    public Graph() {
        nodes = new HashMap<>();
    }
    /**
     * Need add node
     * add edge
     * // setter and getter
     *
     * wtf is this  // (BiFunction<? super Integer, ? super GraphNode, ? extends GraphNode>) nodes.remove(label) xd
     * How does this make my life easier xd.
     *@TODO.. 
     */
    GraphNode addNode(long label) {
    // just added a node with all its value empty
        nodes.putIfAbsent(label, new GraphNode(label));
        return nodes.get(label);
    }
    void addEdge(long from, long to, Double weight) {
        GraphNode fromNode = nodes.computeIfAbsent(from, GraphNode::new);
        GraphNode toNode = nodes.computeIfAbsent(to, GraphNode::new);
        fromNode.addNeighbors(toNode,weight);

    }

    GraphNode getNode(long label) {
        return nodes.get(label);
    }
    GraphNode removeNode(long label) {
        return nodes.remove(label);
    }
    Collection<GraphNode> getAllNeighbors(long label) {

       return nodes.values();
    }

    @Override
    public String toString() {
  StringBuilder sb = new StringBuilder();
  nodes.forEach((label, node) -> {
      sb.append(label).append(" -> ").append(node).append("\n");
  });
   return sb.toString(); }
}
