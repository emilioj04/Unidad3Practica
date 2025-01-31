package com.ComputadorasRed.controller.dao;

import com.ComputadorasRed.controller.dao.implement.AdapterDao;
import com.ComputadorasRed.controller.tda.list.LinkedList;
import com.ComputadorasRed.models.Computadora;


public class ComputadoraDao extends AdapterDao<Computadora> {
    private Computadora obj;
    private LinkedList listAll;

    public ComputadoraDao() {
        super(Computadora.class);
    }

    public Computadora getComputadora () {
        if(this.obj == null) {
            this.obj = new Computadora();
        }
        return this.obj;
    }

    public void setComputadora(Computadora obj) {
        this.obj = obj;
    }

    public LinkedList getListAll() {
        if(this.listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    
    public Boolean save() throws Exception{
        Integer id = getListAll().getSize() +1;
        try {
            obj.setId(id);
            this.persist(this.obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update() throws Exception {
        try {
            this.merge(this.obj, this.obj.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete() throws Exception {
        try {
            this.delete(this.obj.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
