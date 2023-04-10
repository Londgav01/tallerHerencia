package org.com.edu.uniquindio.banco.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    //Attributes
    List<Cuenta> listaCuentas = new ArrayList<Cuenta>();

    //constructor
    public Banco() {}
    public Banco(List<Cuenta> listaCuentas) {this.listaCuentas = listaCuentas;}

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
}
