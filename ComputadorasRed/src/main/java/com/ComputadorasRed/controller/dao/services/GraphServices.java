package com.ComputadorasRed.controller.dao.services;

import org.json.simple.JSONObject;

import com.ComputadorasRed.controller.dao.GraphDao;
import com.ComputadorasRed.controller.tda.graph.GraphLabelNotDirect;


public class GraphServices {
    GraphDao obj;

    public GraphServices() {
        this.obj = new GraphDao();
    }

    public GraphLabelNotDirect getGraph() throws Exception {
        return this.obj.getGraph();
    }

    public void setGraph(GraphLabelNotDirect graph) {
        this.obj.setGraph(graph);
    }

    public JSONObject graphJson() throws Exception {
        return this.obj.graphJson();
    }

    public void createGraph() throws Exception {
        this.obj.createGraph();
    }

    public Integer[] getMinCam (String algoritmo, Integer origen, Integer destino) throws Exception {
        switch (algoritmo) {
            case "floyd" :
            return this.getGraph().minPathFloyd(origen, destino);
            case "bellman" :
            return this.getGraph().minPathBellmanFord(origen, destino);
            default:
                return null;
        }
    }

    public Float getMinPeso (String algoritmo, Integer origen, Integer destino) throws Exception {
        switch (algoritmo) {
            case "floyd" :
            return this.getGraph().minWeightFloyd(origen, destino);
            case "bellman" :
            return this.getGraph().minWeightBellmanFord(origen, destino);
            default:
                return null;
        }
    }
}
