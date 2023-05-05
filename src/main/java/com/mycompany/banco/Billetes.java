package com.mycompany.banco;

/**
 *
 * @author Ismael Polanco
 */
public class Billetes {

    private int billete500;
    private int billete200;
    private int billete100;
    private int billete50;
    private int billete20;
    private int billete10;
    private int billete5;

    // Constructor
    public Billetes(int billete500, int billete200, int billete100, int billete50, int billete20, int billete10,
            int billete5) {
        this.billete500 = billete500;
        this.billete200 = billete200;
        this.billete100 = billete100;
        this.billete50 = billete50;
        this.billete20 = billete20;
        this.billete10 = billete10;
        this.billete5 = billete5;
    }

    public void ingresarBilletes(int cantidad) {

        billete500 += cantidad / 500;
        cantidad = cantidad % 500;
        billete200 += cantidad / 200;
        cantidad = cantidad % 200;
        billete100 += cantidad / 100;
        cantidad = cantidad % 100;
        billete50 += cantidad / 50;
        cantidad = cantidad % 50;
        billete20 += cantidad / 20;
        cantidad = cantidad % 20;
        billete10 += cantidad / 10;
        cantidad = cantidad % 10;
        billete5 += cantidad / 5;

    }

    public void retirarBilletes(int cantidad) {
        int cantidadRetirada = 0;

        if (cantidad >= 500 && billete500 > 0) {
            int cantidadMaxima = Math.min(cantidad / 500, billete500);
            cantidadRetirada += cantidadMaxima * 500;
            billete500 -= cantidadMaxima;
            cantidad %= 500;
        }

        if (cantidad >= 200 && billete200 > 0) {
            int cantidadMaxima = Math.min(cantidad / 200, billete200);
            cantidadRetirada += cantidadMaxima * 200;
            billete200 -= cantidadMaxima;
            cantidad %= 200;
        }

        if (cantidad >= 100 && billete100 > 0) {
            int cantidadMaxima = Math.min(cantidad / 100, billete100);
            cantidadRetirada += cantidadMaxima * 100;
            billete100 -= cantidadMaxima;
            cantidad %= 100;
        }

        if (cantidad >= 50 && billete50 > 0) {
            int cantidadMaxima = Math.min(cantidad / 50, billete50);
            cantidadRetirada += cantidadMaxima * 50;
            billete50 -= cantidadMaxima;
            cantidad %= 50;
        }

        if (cantidad >= 20 && billete20 > 0) {
            int cantidadMaxima = Math.min(cantidad / 20, billete20);
            cantidadRetirada += cantidadMaxima * 20;
            billete20 -= cantidadMaxima;
            cantidad %= 20;
        }

        if (cantidad >= 10 && billete10 > 0) {
            int cantidadMaxima = Math.min(cantidad / 10, billete10);
            cantidadRetirada += cantidadMaxima * 10;
            billete10 -= cantidadMaxima;
            cantidad %= 10;
        }

        if (cantidad >= 5 && billete5 > 0) {
            int cantidadMaxima = Math.min(cantidad / 5, billete5);
            cantidadRetirada += cantidadMaxima * 5;
            billete5 -= cantidadMaxima;
            cantidad %= 5;
        }

        if (cantidadRetirada > 0) {
            System.out.println("Se retiraron en total: ");
            System.out.println(cantidadRetirada + " en billetes de diferentes denominaciones");
        } else {
            System.out.println("No se pudieron retirar billetes.");
        }
    }

    public void transferirBilletes(Billetes cuentaDestino, int cantidad) {
        int cantidadTransferida = 0;

        User usuarioActual = App.login.currentUser;

        if (usuarioActual.getSaldoTotal() >= cantidad) {

            if (cantidad >= 500 && billete500 > 0 && cuentaDestino.billete500 > 0) {
                int cantidadMaxima = Math.min(cantidad / 500, Math.min(billete500, cuentaDestino.billete500));
                cantidadTransferida += cantidadMaxima * 500;
                billete500 -= cantidadMaxima;
                cuentaDestino.billete500 -= cantidadMaxima;
                cantidad %= 500;
            }

            if (cantidad >= 200 && billete200 > 0 && cuentaDestino.billete200 > 0) {
                int cantidadMaxima = Math.min(cantidad / 200, Math.min(billete200, cuentaDestino.billete200));
                cantidadTransferida += cantidadMaxima * 200;
                billete200 -= cantidadMaxima;
                cuentaDestino.billete200 -= cantidadMaxima;
                cantidad %= 200;
            }

            if (cantidad >= 100 && billete100 > 0 && cuentaDestino.billete100 > 0) {
                int cantidadMaxima = Math.min(cantidad / 100, Math.min(billete100, cuentaDestino.billete100));
                cantidadTransferida += cantidadMaxima * 100;
                billete100 -= cantidadMaxima;
                cuentaDestino.billete100 -= cantidadMaxima;
                cantidad %= 100;
            }

            if (cantidad >= 50 && billete50 > 0 && cuentaDestino.billete50 > 0) {
                int cantidadMaxima = Math.min(cantidad / 50, Math.min(billete50, cuentaDestino.billete50));
                cantidadTransferida += cantidadMaxima * 50;
                billete50 -= cantidadMaxima;
                cuentaDestino.billete50 -= cantidadMaxima;
                cantidad %= 50;
            }

            if (cantidad >= 20 && billete20 > 0 && cuentaDestino.billete20 > 0) {
                int cantidadMaxima = Math.min(cantidad / 20, Math.min(billete20, cuentaDestino.billete20));
                cantidadTransferida += cantidadMaxima * 20;
                billete20 -= cantidadMaxima;
                cuentaDestino.billete20 -= cantidadMaxima;
                cantidad %= 20;
            }

            if (cantidad >= 10 && billete10 > 0 && cuentaDestino.billete10 > 0) {
                int cantidadMaxima = Math.min(cantidad / 10, Math.min(billete10, cuentaDestino.billete10));
                cantidadTransferida += cantidadMaxima * 10;
                billete10 -= cantidadMaxima;
                cuentaDestino.billete10 -= cantidadMaxima;
                cantidad %= 10;
            }

            if (cantidad >= 5 && billete5 > 0 && cuentaDestino.billete5 > 0) {
                int cantidadMaxima = Math.min(cantidad / 5, Math.min(billete5, cuentaDestino.billete5));
                cantidadTransferida += cantidadMaxima * 5;
                billete5 -= cantidadMaxima;
                cuentaDestino.billete5 -= cantidadMaxima;
                cantidad %= 5;
            }

            if (cantidadTransferida > 0) {
                System.out.println("Se transfirieron en total: ");
                System.out.println(
                        cantidadTransferida + " en billetes de diferentes denominaciones a la cuenta destino.");
            } else {
                System.out.println("No se pudieron transferir billetes.");
            }

        } else {
            System.out.println("Saldo insuficiente en la cuenta de origen.");
        }
    }

    public boolean actualizarBilletes(int cantidad) {

        if (cantidad > 0) {
            return true; // esto si puede actulizar la cantidad
        } else {
            return false; // esto si no
        }
    }
}