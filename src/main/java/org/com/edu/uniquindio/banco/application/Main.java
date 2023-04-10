package org.com.edu.uniquindio.banco.application;

import org.com.edu.uniquindio.banco.exceptions.CuentaException;
import org.com.edu.uniquindio.banco.model.CuentaAhorros;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CuentaException {
        Scanner input = new Scanner(System.in);
        System.out.println("Cuenta de ahorros");
        System.out.println("Ingrese saldo inicial= $");
        float saldoInicialAhorros = input.nextFloat();
        System.out.print("Ingrese tasa de inter�s= ");
        float tasaAhorros = input.nextFloat();
        CuentaAhorros cuenta1 = new	CuentaAhorros(saldoInicialAhorros, tasaAhorros);
        System.out.print("Ingresar cantidad a consignar: $");
        float cantidadDepositar = input.nextFloat();
        cuenta1.consignar(cantidadDepositar);
        System.out.print("Ingresar cantidad a retirar: $");
        float cantidadRetirar = input.nextFloat();
        cuenta1.retirar(cantidadRetirar);
        cuenta1.extractoMensual();
        cuenta1.imprimir();
    }
}
