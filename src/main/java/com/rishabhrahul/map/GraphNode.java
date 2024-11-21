package com.rishabhrahul.map;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class GraphNode {

    private final long label;
    private double latitude;
    private double longitude;
   // Second parameter represent the distance from the parent node
    private Map<GraphNode, Double> neighbors;

    // Now we need is an init
    public GraphNode(long label, double latitude, double longitude) {
        this.label = label;
        this.latitude = latitude;
        this.longitude = longitude;
        // creating an empty sibling
        neighbors = new HashMap<>();
    }
    public GraphNode(long label) {
        this.label = label;
        neighbors = new HashMap<>();
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }

    public long getLabel() {
        return label;
    }
    public Map<GraphNode, Double> getNeighbors() {
        return neighbors;
    }

    public void addNeighbors(GraphNode to, Double Weight) {
        this.neighbors.put(to, Weight);
    }
}
