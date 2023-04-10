package org.com.edu.uniquindio.banco.model;

import org.com.edu.uniquindio.banco.exceptions.CuentaException;

public interface Cuentas {
    public void retirar(double cantidad) throws CuentaException;
    public void consignar(double cantidad);
    public void extractoMensual();
}
