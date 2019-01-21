package com.company.classes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyNodeBuilder {
    private static ArrayList<Node> nodes = new ArrayList<Node>();
    private static ArrayList<String> nodeNames = new ArrayList<String>();

    private static int id;

    public MyNodeBuilder() {

    }

    public static Node instance(String name) {
        if (nodeNames.contains(name)) {
            return nodes.get(nodeNames.indexOf(name));
        } else {
            Node node = new Node(name);

            node.setId(id++);

            nodes.add(node);

            nodeNames.add(name);

            return node;
        }
    }
}
