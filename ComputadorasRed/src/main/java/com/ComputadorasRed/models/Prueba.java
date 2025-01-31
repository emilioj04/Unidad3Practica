package com.ComputadorasRed.models;

import com.ComputadorasRed.controller.dao.services.ComputadoraServices;
import com.ComputadorasRed.controller.tda.graph.GraphLabelNotDirect;

public class Prueba {
    public static void main(String[] args) throws Exception {
        System.out.println("Ejecutando prueba...");

        ComputadoraServices computadoraServices = new ComputadoraServices();
        Computadora computadora1 = computadoraServices.get(1);
        Computadora computadora2 = computadoraServices.get(2);
        Computadora computadora3 = computadoraServices.get(3);

        if (computadora1 == null || computadora2 == null || computadora3 == null) {
            throw new Exception("No se pudo recuperar una de las computadoras.");
        }
        

        //.out.println(Computadora1);

        GraphLabelNotDirect<Computadora> graph = new GraphLabelNotDirect<Computadora>(3, Computadora.class);
        graph.labelVertex(1, computadora1);
        graph.labelVertex(2, computadora2);
        graph.labelVertex(3, computadora3);
        System.out.println("Vértices etiquetados:");
        System.out.println(graph.getVertexLabel(computadora1));
        System.out.println(graph.getVertexLabel(computadora2));
        System.out.println(graph.getVertexLabel(computadora3));
        System.out.println("¿El grafo tiene etiquetas? " + graph.islabelsGraph());


        graph.addEdgeLabel(computadora1, computadora2);
        graph.addEdgeLabel(computadora1, computadora3);
        graph.addEdgeLabel(computadora2, computadora3);

        
        
        System.out.println("Vértices etiquetados:");

        graph.saveGraph();  // Guarda el grafo en un archivo
        



        System.out.println(graph.readGraph());

        //GraphDirect graph2 = new GraphDirect(2);
        //graph2.addEdge(1, 2);
        //System.out.println(graph2);
    }

}
