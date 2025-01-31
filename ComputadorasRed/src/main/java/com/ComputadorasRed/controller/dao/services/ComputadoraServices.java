package com.ComputadorasRed.controller.dao.services;

import com.ComputadorasRed.controller.dao.ComputadoraDao;
import com.ComputadorasRed.controller.tda.list.LinkedList;
import com.ComputadorasRed.models.Computadora;

public class ComputadoraServices {
    private ComputadoraDao obj;

    public ComputadoraServices() {
        this.obj = new ComputadoraDao();
    }

    public Computadora getComputadora() {
        return this.obj.getComputadora();
    }

    public void setComputadora(Computadora obj) {
        this.obj.setComputadora(obj);
    }

    public LinkedList  getListAll() {
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

    public Computadora get(Integer id) throws Exception {
        return this.obj.get(id);
    }

    public LinkedList ordenarQuickSort(String attribute, Integer type) throws Exception {
        return this.obj.listAll().ordenarQuickSort(attribute, type);
    }



    
}
