package org.com.edu.uniquindio.banco.model;

import org.com.edu.uniquindio.banco.exceptions.CuentaException;

public abstract class Cuenta {
    //Atributes
    protected double saldo;
    protected int numeroConsignaciones = 0;
    protected int numeroRetiros = 0;
    protected double tasaAnual;
    protected double comisionMensual = 0;

    //Constructor
    public Cuenta(double saldo, double tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    //metodo que sirve para consignar una cantidad de dinero que entra como parametro
    // y actualiza el saldo de la cuenta
    public void consignar(double cantidad) {
        saldo = saldo + cantidad;
        numeroConsignaciones = numeroConsignaciones + 1;
    }
    //metodo que sirve para retirar cierta cantidad de dinero de una cuenta, esta cantidad a retirar
    // no supera el saldo, si lo hace lanza exception
    public void retirar(double cantidad) throws CuentaException {
        double nuevoSaldo = saldo - cantidad;
        if (nuevoSaldo >= 0) {
            saldo -= cantidad;
            numeroRetiros = numeroRetiros + 1;
        } else {
            throw new CuentaException("El saldo es superior al valor actual");
        }
    }
    //Metodo para calculae le interes menual de la cuenta y actualiza su saldo
    public void calcularInteres() {
        double tasaMensual = tasaAnual / 12;
        double interesMensual = saldo * tasaMensual;
        saldo += interesMensual;
    }
    //metodo que actualiza el saldo restándole la comisión mensual
    // y calculando el interés mensual correspondiente
    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteres();
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", numeroConsignaciones=" + numeroConsignaciones +
                ", numeroRetiros=" + numeroRetiros +
                ", tasaAnual=" + tasaAnual +
                ", comisionMensual=" + comisionMensual +
                '}';
    }
}
