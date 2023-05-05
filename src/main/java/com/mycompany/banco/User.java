
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

    public double getSaldoTotal() {
        return getSaldoCuentaPrincipal() + getSaldoCuentaAhorro();
    }
    
    public void setSaldoTotal(double newSaldo) {
        double saldoAhorro = Math.min(newSaldo, cuentaAhorro.getSaldoAhorro());
        double saldoPrincipal = newSaldo - saldoAhorro;
        cuentaAhorro.setSaldoAhorro(saldoAhorro);
        cuentaPrincipal.setSaldo(saldoPrincipal);
    }

    public void ingresar(double monto) {
        if (monto > 0)
        cuentaPrincipal.ingresar(monto);
        this.setSaldoCuentaPrincipal(cuentaPrincipal.getSaldo());
    }
    
    public void retirar(double monto) {
        if (monto > 0 && cuentaPrincipal.getSaldo() >= monto) {
            cuentaPrincipal.retirar(monto);
            this.setSaldoCuentaPrincipal(cuentaPrincipal.getSaldo());
        } else {
            throw new IllegalArgumentException("El monto a retirar es mayor al saldo disponible");
        }
    }
    
}
