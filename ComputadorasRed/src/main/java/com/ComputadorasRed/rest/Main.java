package com.ComputadorasRed.rest;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.ComputadorasRed.rest package
        final ResourceConfig rc = new ResourceConfig().packages("com.ComputadorasRed.rest");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, Exception {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        /*ComputadoraServices cs = new ComputadoraServices();
        cs.getComputadora().setIp("121.102.100");
        cs.getComputadora().setNombre("Computadora3");
        cs.getComputadora().setMarca("LG");
        cs.getComputadora().setUbicacionX(15.12);
        cs.getComputadora().setUbicacionY(90.00);
        cs.save();

        System.out.println("Computadora guardada");
    

        

        ConexionServices cs = new ConexionServices();
        cs.getConexion().setIdOrigen(2);
        cs.getConexion().setIdDestino(3);
        cs.getConexion().setdistancia(15.0);
        cs.save();
        */
        System.in.read();

        server.stop();
    }
}

