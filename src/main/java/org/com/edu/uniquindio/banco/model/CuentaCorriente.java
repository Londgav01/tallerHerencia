package org.com.edu.uniquindio.banco.model;

import org.com.edu.uniquindio.banco.exceptions.CuentaException;

public class CuentaCorriente extends Cuenta implements Cuentas {
    //Attributes
    double sobregiro;

    //construct
    public CuentaCorriente(double saldo, double tasa) {
        super(saldo, tasa); // Invoca al constructor de la clase padre
        sobregiro = 0; // Inicialmente no hay sobregiro
    }

    //Metodo que recibe una cantidad de dinero a retirar y actualiza el saldo de la cuenta
    public void retirar(double cantidad) throws CuentaException {
        double resultado = saldo - cantidad;
        if (resultado < 0) {
            sobregiro = sobregiro - resultado;
            saldo = 0;
        } else {
            super.retirar(cantidad);
        }
    }
    //Metodo que recibe una cantidad de dinero a consignar y actualiza el saldo de la cuenta
    public void consignar(double cantidad) {
        double residuo = sobregiro - cantidad;
        if (sobregiro > 0) {
            if (residuo > 0) {
                sobregiro = 0;
                saldo = residuo;
            } else{
                sobregiro = -residuo;
                saldo = 0;
            }
        } else{
            super.consignar(cantidad);
        }
    }
    //Metodo que genera el extracto mensual de la cuenta
    public void extractoMensual() {
        super.extractoMensual(); // Invoca al m�todo de la clase padre
    }
    /**
     * M�todo que muestra en pantalla los datos de una cuenta corriente
     */
    public void imprimir() {
        System.out.println("Saldo = $ " + saldo);
        System.out.println("Cargo mensual = $ " + comisionMensual);
        System.out.println("N�mero de transacciones = " + (numeroConsignaciones + numeroRetiros));
        System.out.println("Valor de sogregiro = $" + (numeroConsignaciones + numeroRetiros));
        System.out.println();
    }
}
