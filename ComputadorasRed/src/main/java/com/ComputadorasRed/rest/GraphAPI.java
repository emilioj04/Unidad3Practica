package com.ComputadorasRed.rest;

import java.text.ParseException;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.ComputadorasRed.controller.dao.services.GraphServices;

@Path("/graph")
public class GraphAPI {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGrafo () throws ParseException, Exception {
        HashMap map = new HashMap<>();
        GraphServices gs = new GraphServices();        
        
        try {
            map.put("msg", "OK");
            map.put("data", gs.graphJson());
        } catch (Exception e) {
            map.put("msg", "Error");
            map.put("data", e.toString());
        }

        ResponseBuilder responseBuilder = Response.ok(map)
        .header("Access-Control-Allow-Origin", "*") // Permite cualquier origen
        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS") // Métodos permitidos
        .header("Access-Control-Allow-Headers", "Content-Type, Authorization"); // Encabezados permitidos
        return responseBuilder.build();
    }

    @GET
    @Path("/minCamino/{algoritmo}/{origen}/{destino}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMinPath (@PathParam("algoritmo") String algoritmo, @PathParam("origen") Integer origen, @PathParam("destino") Integer destino) throws ParseException, Exception {
        HashMap map = new HashMap<>();
        GraphServices gs = new GraphServices();        
        
        try {
            map.put("msg", "OK");
            map.put("data", gs.getMinCam(algoritmo, origen, destino));
        } catch (Exception e) {
            map.put("msg", "Error");
            map.put("data", e.toString());
        }
        ResponseBuilder responseBuilder = Response.ok(map)
        .header("Access-Control-Allow-Origin", "*") // Permite cualquier origen
        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS") // Métodos permitidos
        .header("Access-Control-Allow-Headers", "Content-Type, Authorization"); // Encabezados permitidos

        return responseBuilder.build();
    }

    @GET
    @Path("/minPeso/{algoritmo}/{origen}/{destino}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMinWeight (@PathParam("algoritmo") String algoritmo, @PathParam("origen") Integer origen, @PathParam("destino") Integer destino) throws ParseException, Exception {
        HashMap map = new HashMap<>();
        GraphServices gs = new GraphServices();        
        
        try {
            map.put("msg", "OK");
            map.put("data", gs.getMinPeso(algoritmo, origen, destino));
        } catch (Exception e) {
            map.put("msg", "Error");
            map.put("data", e.toString());
        }
        ResponseBuilder responseBuilder = Response.ok(map)
        .header("Access-Control-Allow-Origin", "*") // Permite cualquier origen
        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS") // Métodos permitidos
        .header("Access-Control-Allow-Headers", "Content-Type, Authorization"); // Encabezados permitidos

        return responseBuilder.build();
    }

}
