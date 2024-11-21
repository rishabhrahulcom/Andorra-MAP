package com.rishabhrahul.map;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/route")
public class APIExposer {

    private  Graph graph;
    CustomRouting customRouting;
    @PostConstruct
    public void init() {
        this.graph = OSMGraphParser.buildGraphFromJSON("src/main/resources/sample.json");
        this.customRouting = new CustomRouting();
    }

    @GetMapping
    public List<Long> route(@RequestParam String from) {
        var sx = CustomRouting.DFS(graph, graph.getNode(Long.parseLong(from)));

        return sx.stream().map(GraphNode::getLabel).toList();
    }


}
