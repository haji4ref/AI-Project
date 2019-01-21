package com.company.classes;

public class Node {
    private String name;

    private int id;

    private String color;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return color;
    }

    public Node setColor(String color) {
        this.color = color;
        return this;
    }

    public int setId(int id) {
        this.id = id;

        return this.id;
    }

    public int getId() {
        return this.id;
    }
}
