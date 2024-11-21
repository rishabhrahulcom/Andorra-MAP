package com.rishabhrahul.map;

import java.util.*;

public  class CustomRouting {

    public  static List<GraphNode> BFS(Graph graph,GraphNode startNode) {

        // we need a queue
        Queue<GraphNode> queue = new LinkedList<>();

        queue.add(graph.getNode(startNode.getLabel()));
        // we need a list of item that we have visited
        Set<GraphNode> visited = new LinkedHashSet<GraphNode>();
        visited.add(startNode);

        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();

            for (Map.Entry<GraphNode,Double> fromNeighbor : current.getNeighbors().entrySet()){
                GraphNode neighbor = fromNeighbor.getKey();
                if(!visited.contains(neighbor)){
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }

        }

        return visited.stream().toList();

    }

    public static List<GraphNode> DFS(Graph graph,GraphNode startNode) {
        Deque<GraphNode> stack = new LinkedList<>();
        stack.push(startNode);
        //if we are passing the coordinates, then we must

        Set<GraphNode> visited = new LinkedHashSet<>();
        visited.add(startNode);

        while (!stack.isEmpty()) {
            var node = stack.pop();
            // get the children at least one and push back to stack
            var children = graph.getNode(node.getLabel());
            for (Map.Entry<GraphNode,Double> fromNeighbor : children.getNeighbors().entrySet()){
                GraphNode neighborKey = fromNeighbor.getKey();

                if(!visited.contains(neighborKey)){
                    stack.push(neighborKey);
                    visited.add(neighborKey);
                // psuh a
                }
            }
        }

    return visited.stream().toList();
    }


}
