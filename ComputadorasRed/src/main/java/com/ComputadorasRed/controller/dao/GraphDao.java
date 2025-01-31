package com.ComputadorasRed.controller.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ComputadorasRed.controller.dao.services.ComputadoraServices;
import com.ComputadorasRed.controller.dao.services.ConexionServices;
import com.ComputadorasRed.controller.tda.graph.GraphLabelNotDirect;
import com.ComputadorasRed.models.Computadora;
import com.ComputadorasRed.models.Conexion;
import com.google.gson.Gson;

public class GraphDao {
    private GraphLabelNotDirect graph;

    public GraphDao() {
        this.graph = new GraphLabelNotDirect();
    }

    public GraphLabelNotDirect getGraph() throws Exception {
        createGraph();
        return graph;
    }

    public void setGraph(GraphLabelNotDirect graph) {
        this.graph = graph;
    }

    private void addComputadora() throws Exception {
        ComputadoraServices cs = new ComputadoraServices();
        this.graph = new GraphLabelNotDirect(cs.getListAll().getSize(), Computadora.class);
        for (Object obj : cs.getListAll().toArray()) {
            Computadora computadora = (Computadora) obj;
            this.graph.labelVertex(computadora.getId(), computadora);
        }
    }

    private void addConexion() throws Exception {
        ConexionServices cxs = new ConexionServices();
        ComputadoraServices cs = new ComputadoraServices();
    
        for (Object obj : cxs.getListAll().toArray()) {
            Conexion conexion = (Conexion) obj;
            
            // Obtener origen y destino
            Computadora origen = cs.get(conexion.getIdOrigen());
            Computadora destino = cs.get(conexion.getIdDestino());
            
            // Verificar si son nulos antes de agregarlos al grafo
            if (origen == null || destino == null) {
                System.err.println("Error: No se encontró la computadora con ID: " + 
                    (origen == null ? conexion.getIdOrigen() : "") + " o " + 
                    (destino == null ? conexion.getIdDestino() : ""));
                continue; // Saltar esta conexión si los datos son inválidos
            }
    
            Double peso = conexion.getDistancia();
            this.graph.addEdge(origen.getId(), destino.getId(), peso.floatValue());
        }
    }
    

    public void createGraph() throws Exception {
        this.addComputadora();
        this.addConexion();
        this.saveGraph();
    }

    public String toJson() {
        ComputadoraServices cs = new ComputadoraServices();
        ConexionServices crs = new ConexionServices();

        HashMap<String, Object> grafo = new HashMap<String, Object>();

        Computadora[] computadores = (Computadora[]) cs.getListAll().toArray();
        HashMap<String, Object>[] nodes = new HashMap[computadores.length];
        for (int i = 0; i < computadores.length; i++) {
            HashMap<String, Object> node = new HashMap<String, Object>();
            node.put("id", computadores[i].getId());
            node.put("nombre", computadores[i].getNombre());
            node.put("posx", computadores[i].getUbicacionY());
            node.put("posy", computadores[i].getUbicacionX());
            nodes[i] = node;
        }
        grafo.put("nodes", nodes);
        
        Conexion[] conexiones = (Conexion[]) crs.getListAll().toArray();
        HashMap<String, Number>[] edges = new HashMap[conexiones.length];
        for (int i = 0; i < conexiones.length; i++) {
            HashMap<String, Number> edge = new HashMap<String, Number>();
            edge.put("from", conexiones[i].getIdOrigen());
            edge.put("to", conexiones[i].getIdDestino());
            edge.put("weigth", conexiones[i].getDistancia());
            edges[i] = edge;
        }
        grafo.put("edges", edges);
        
        String json = new Gson().toJson(grafo);
        return json;
    }

    public void saveGraph () throws Exception {
        try {
            FileWriter file = new FileWriter("media/Graph" + ".json");
            file.write(this.toJson());
            file.flush();
            file.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public String readGraph() throws Exception {
        File file = new File("media/Graph" + ".json");
        StringBuilder sb = new StringBuilder();
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextLine()) {
                sb.append(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        }
        return sb.toString();
    }

    public JSONObject graphJson() throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(this.readGraph());
        return json;
    }
}