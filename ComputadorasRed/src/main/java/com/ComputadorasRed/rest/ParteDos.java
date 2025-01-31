package com.ComputadorasRed.rest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.json.simple.JSONObject;

import com.ComputadorasRed.controller.dao.services.GraphServices;
import com.ComputadorasRed.controller.tda.graph.GraphLabelNotDirect;

public class ParteDos {
    public static void main(String[] args) throws Exception {
        GraphServices graphServices = new GraphServices();
        graphServices.createGraph();
        GraphLabelNotDirect<String> graph = graphServices.getGraph();

        // Guardar grafo en un archivo JSON
        saveGraphToFile(graphServices.graphJson(), "graph.json");
        System.out.println("Número de nodos en el grafo: " + graph.nroVertex());

        // Medir tiempos de ejecución para Floyd y Bellman-Ford
        measureExecutionTime(graphServices, "floyd");
        measureExecutionTime(graphServices, "bellman");
    }

    private static void saveGraphToFile(JSONObject graphJson, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(graphJson.toJSONString());
            System.out.println("Grafo guardado en " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void measureExecutionTime(GraphServices graphServices, String algorithm) throws Exception {
        int[] dataSizes = {10, 20, 30};
        System.out.println("\nMedición de tiempos para " + algorithm + "");
        System.out.println("Tamaño | Tiempo (ms)");
        System.out.println("-------------------");
        
        for (int size : dataSizes) {
            Integer origen = 1, destino = size; // Suponiendo nodos dentro del rango
            long startTime = System.nanoTime();
            Integer[] path = graphServices.getMinCam(algorithm, origen, destino);
            long endTime = System.nanoTime();
            
            long duration = (endTime - startTime) / 1_000_000; // Convertir a milisegundos
            System.out.printf("%6d | %6d ms%n", size, duration);
            System.out.println("Camino más corto: " + Arrays.toString(path));
        }
    }
}

