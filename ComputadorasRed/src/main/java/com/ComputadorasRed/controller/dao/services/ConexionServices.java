package com.ComputadorasRed.controller.dao.services;

import com.ComputadorasRed.controller.dao.ConexionDao;
import com.ComputadorasRed.controller.tda.list.LinkedList;
import com.ComputadorasRed.models.Conexion;

public class ConexionServices {
    private ConexionDao obj;

    public ConexionServices() {
        this.obj = new ConexionDao();
    }

    public Conexion getConexion() {
        return this.obj.getConexion();
    }

    public void setConexion(Conexion obj) {
        this.obj.setConexion(obj);
    }
    
    public LinkedList getListAll() {
        return this.obj.getListAll();
    }

    public Boolean save() throws Exception {
        return this.obj.save();
    }

    public Boolean update() throws Exception {
        return this.obj.update();
    }

    public Boolean delete() throws Exception {
        return this.obj.delete();
    }

    public Conexion get(Integer id) throws Exception {
        return this.obj.get(id);
    }

    public LinkedList ordenarQuickSort(String attribute, Integer type) throws Exception {
        return this.obj.listAll().ordenarQuickSort(attribute, type);
    }
    
}
