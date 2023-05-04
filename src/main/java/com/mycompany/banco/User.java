    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banco;

/**
 *
 * @author Ismael Polanco
 */
public class User {

    private String username;
    private String password;
    private CuentaPrincipal cuentaPrincipal;
    private CuentaAhorro cuentaAhorro;

    public User(String username, String password, int saldoPrincipal, int saldoAhorro) {
        this.username = username;
        this.password = password;
        this.cuentaPrincipal = new CuentaPrincipal(saldoPrincipal);
        this.cuentaAhorro = new CuentaAhorro(saldoAhorro);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CuentaPrincipal getCuentaPrincipal() {
        return cuentaPrincipal;
    }

    public void setCuentaPrincipal(CuentaPrincipal cuentaPrincipal) {
        this.cuentaPrincipal = cuentaPrincipal;
    }

    public double getSaldoCuentaPrincipal() {
        return cuentaPrincipal.getSaldo();
    }

    public void setSaldoCuentaPrincipal(double saldoCuentaPrincipal) {
        cuentaPrincipal.setSaldo(saldoCuentaPrincipal);
    }

    public CuentaAhorro getCuentaAhorro() {
        return cuentaAhorro;
    }

    public void setCuentaAhorro(CuentaAhorro cuentaAhorro) {
        this.cuentaAhorro = cuentaAhorro;
    }

    public double getSaldoCuentaAhorro() {
        return cuentaAhorro.getSaldoAhorro();
    }

    public void setSaldoCuentaAhorro(double saldoCuentaAhorro) {
        cuentaAhorro.setSaldoAhorro(saldoCuentaAhorro);
    }

    public int getSaldo() {
        return 0;
    }

    public void setSaldo(int newSaldo) {
    }

    public int getSaldoAhorro() {
        return 0;
    }



}
