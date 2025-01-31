package com.ComputadorasRed.rest;

import java.text.ParseException;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        return Response.ok(map).build();
    }
}
