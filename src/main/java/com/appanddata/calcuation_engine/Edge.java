package com.appanddata.calcuation_engine;

public class Edge {
    public String getTail() {
        return tail;
    }

    public String getHead() {
        return head;
    }

    private final String tail;
    private final String head;

    public Edge(String tail, String head) {
        this.tail = tail;
        this.head = head;
    }
}
