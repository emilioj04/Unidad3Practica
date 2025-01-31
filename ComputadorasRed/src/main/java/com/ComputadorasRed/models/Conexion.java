package com.ComputadorasRed.models;

public class Conexion {
    Integer id;
    Integer idOrigen;
    Integer idDestino;
    Double distancia; 

    public Conexion(Integer id, Integer idOrigen, Integer idDestino, Double distancia) {
        this.id = id;
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.distancia = distancia;
    }

    public Conexion() {
        
    }

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOrigen() {
        return this.idOrigen;
    }

    public void setIdOrigen(Integer idOrigen) {
        this.idOrigen = idOrigen;
    }

    public Integer getIdDestino() {
        return this.idDestino;
    }

    public void setIdDestino(Integer idDestino) {
        this.idDestino = idDestino;
    }

    public Double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

}
