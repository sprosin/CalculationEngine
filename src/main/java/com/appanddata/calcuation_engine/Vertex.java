package com.appanddata.calcuation_engine;

public class Vertex {
    private final IEquation equation;

    public String getName() {
        return name;
    }

    private final String name;

    public Vertex(String name, IEquation equation) {
        this.name = name;
        this.equation = equation;
    }

    public IEquation getEquation() {
        return equation;
    }
}
