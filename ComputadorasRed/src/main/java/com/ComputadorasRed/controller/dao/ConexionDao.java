package com.ComputadorasRed.controller.dao;

import com.ComputadorasRed.controller.dao.implement.AdapterDao;
import com.ComputadorasRed.controller.tda.list.LinkedList;
import com.ComputadorasRed.models.Conexion;

public class ConexionDao extends AdapterDao<Conexion> {
    private Conexion obj;
    private LinkedList listAll;

    public ConexionDao() {
        super(Conexion.class);
    }

    public Conexion getConexion() {
        if (this.obj == null) {
            this.obj = new Conexion();
        }
        return this.obj;
    }

    public void setConexion(Conexion obj) {
        this.obj = obj;
    }

    public LinkedList getListAll() {
        if (this.listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    public Boolean save() throws Exception {
        Integer id = listAll().getSize() + 1;
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
