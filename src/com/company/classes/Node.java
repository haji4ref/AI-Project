package com.company.classes;

public class Node {
    private String name;

    private int cost;

    private int id;

    public Node(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public int setId(int id) {
        this.id = id;

        return this.id;
    }

    public int getId() {
        return this.id;
    }
}
