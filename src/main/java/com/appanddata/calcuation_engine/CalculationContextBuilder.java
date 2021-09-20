package com.appanddata.calcuation_engine;

import java.util.*;
import java.util.stream.Collectors;

public class CalculationContextBuilder {
    private Map<String, Vertex> vertexes;
    private Map<String, List<Edge>> tailEdges;
    private Map<String, List<Edge>> headEdges;

    public CalculationContextBuilder() {
        context();
    }


    private void init() {
        vertexes = new HashMap<>();
        tailEdges = new HashMap<>();
        headEdges = new HashMap<>();
    }


    public CalculationContextBuilder context() {
        init();
        return this;
    }

    public CalculationContextBuilder context(CalculationContext context) {
        init();
        for (var equation: context.getEquations())
            withEquation(equation);
        return this;
    }

    public CalculationContext build() {

        var rootVertexes = vertexes.values().stream()
                .filter(v -> !headEdges.containsKey(v.getName()))
                .map(v -> v.getName())
                .collect(Collectors.toList());
        Set<String> visitedVertexes = new HashSet<>();
        List<IEquation> equationList = new ArrayList<>();
        Set<String> notVisitedVertexes = new HashSet<>();

        notVisitedVertexes.addAll(rootVertexes);
        while (notVisitedVertexes.size()>0) {
            var nextStepVertexes = notVisitedVertexes.stream()
                    .filter(vKey -> visitedVertexes.containsAll(
                            headEdges.getOrDefault(vKey, Collections.emptyList()).stream()
                                    .map(e -> e.getTail()).collect(Collectors.toList())
                    )).collect(Collectors.toList());

            nextStepVertexes.forEach(vKey -> {
                var v = vertexes.get(vKey);
                if (v.getEquation()!=null)
                    equationList.add(v.getEquation());
                visitedVertexes.add(v.getName());
                notVisitedVertexes.addAll(tailEdges.getOrDefault(v.getName(), Collections.emptyList())
                        .stream().map(e -> e.getHead()).collect(Collectors.toList()));
            });

            notVisitedVertexes.removeAll(nextStepVertexes);
        }

        context();
        return new CalculationContext(equationList.toArray(new IEquation[0]));
    }

    public CalculationContextBuilder withEquation(IEquation equation) {
        var vKey = equation.getOutputParameter().getName();
        ensureParameterCalcuationDataRemoved(vKey);
        addEquation(equation);
        return this;
    }

    private void ensureParameterCalcuationDataRemoved(String parameterName) {

        if (vertexes.containsKey(parameterName)) {
            removeVertexWithEdges(parameterName);
        }
    }

    private void addEquation(IEquation equation) {
        var vKey = equation.getOutputParameter().getName();
        vertexes.put(vKey, new Vertex(vKey, equation));
        for (var inputParameter : equation.getInputParameters()) {
            var inputParameterName = inputParameter.getName();
            Edge edge = new Edge(inputParameterName, vKey);
            addEdge(tailEdges, inputParameterName, edge);
            addEdge(headEdges, vKey, edge);
            if (!vertexes.containsKey(inputParameterName))
                vertexes.put(inputParameterName, new Vertex(inputParameterName, null));
        }
    }

    private void addEdge(Map<String, List<Edge>> map, String vKey, Edge edge) {
        var tailList = map.getOrDefault(vKey, new ArrayList<>());
        tailList.add(edge);
        map.put(vKey, tailList);
    }

    private void removeVertexWithEdges(String vKey) {
        for (Edge edge : headEdges.getOrDefault(vKey,Collections.emptyList())) {
            tailEdges.get(edge.getTail()).remove(edge);
            Vertex tailVertex = vertexes.get(edge.getTail());
            if (tailVertex.getEquation() == null)
                vertexes.remove(tailVertex);
        }
        headEdges.getOrDefault(vKey,Collections.emptyList()).clear();
        vertexes.remove(vKey);
    }

    public CalculationContextBuilder withEquations(IEquation[] equations) {
        for (var eq: equations)
            withEquation(eq);
        return this;
    }
}
