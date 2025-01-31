package com.ComputadorasRed.models;

import java.util.Objects;

public class Computadora {
    private Integer id;
    private String nombre;
    private String marca;
    private String ip;
    private Double ubicacionX;
    private Double ubicacionY;

    
    public Computadora(Integer id, String nombre, String ip) {
        this.id = id;
        this.nombre = nombre;
        this.ip = ip;
    }

    public Computadora() {
        
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Double getUbicacionX() {
        return this.ubicacionX;
    }

    public void setUbicacionX(Double ubicacionX) {
        this.ubicacionX = ubicacionX;
    }

    public Double getUbicacionY() {
        return this.ubicacionY;
    }

    public void setUbicacionY(Double ubicacionY) {
        this.ubicacionY = ubicacionY;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        Computadora computadora = (Computadora) obj;
        return id.equals(computadora.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
