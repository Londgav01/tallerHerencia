package org.com.edu.uniquindio.banco.model;

import org.com.edu.uniquindio.banco.exceptions.CuentaException;

public class CuentaAhorros extends Cuenta implements Cuentas{
    //atributes
    private boolean activa;

    //construct
    public CuentaAhorros(double saldo, double tasa) {
        super(saldo, tasa);
        if (saldo < 10000)
            // Si el saldo es menor a 10000, la cuenta no se activa
            activa = false;
        else
            activa = true;
    }
    //M�todo que recibe una cantidad de dinero a retirar y actualiza el saldo de la cuenta
    public void retirar(double cantidad) throws CuentaException {
        if (activa)
            super.retirar(cantidad);
    }

    // Metodo que recibe una cantidad de dinero a consignar y actualiza el saldo de la cuenta
    public void consignar(double cantidad) {
        if (activa) // Si la cuenta est� activa, se puede consignar dinero 200
            super.consignar(cantidad); /* Invoca al m�todo consignar dela clase padre */
    }

    //Metodo que genera el extracto mensual de una cuenta de ahorros
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }
        super.extractoMensual();
        if ( saldo < 10000 )
            activa = false;
    }

    //Metodo que muestra en pantalla los datos de una cuenta de ahorros
    public void imprimir() {
        System.out.println("Saldo = $ " + saldo);
        System.out.println("Comisi�n mensual = $ " + comisionMensual);
        System.out.println("N�mero de transacciones = "+ (numeroConsignaciones + numeroRetiros));
        System.out.println();
    }
}
