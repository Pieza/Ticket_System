package proyectofinal.estructuras.arbol;

import proyectofinal.objetos.Ticket;

public class Arbol {

    private Nodo raiz;

    public void inserta(Ticket ticket) {
        //preguntamos si la raiz es null
        if (raiz == null) {
            raiz = new Nodo(ticket);
        } else {
            insertaRecursivo(ticket, raiz);//mandamos raiz porque es la referencia del nivel que estamos
        }
    }

    private void insertaRecursivo(Ticket ticket, Nodo n) {
        if (ticket.getId() <= n.getDato().getId()) {
            //insertamos a la izquierda
            if (n.getHijoIzq() == null) {
                n.setHijoIzq(new Nodo(ticket));
            } else {
                insertaRecursivo(ticket, n.getHijoIzq());//le mandamos el hijoIzq porque es el nodo donde estamos
            }
        } else {
            //insertamos a la derecha
            if (n.getHijoDer() == null) {
                n.setHijoDer(new Nodo(ticket));
            } else {
                insertaRecursivo(ticket, n.getHijoDer());//le mandamos el hijoDer
            }
        }
    }

    public void inOrden() {
        if (raiz != null) {
            System.out.println("\nInOrden");
            inOrdenRecursivo(raiz);
        }
    }

    private void inOrdenRecursivo(Nodo n) {
        if (n != null) {
            inOrdenRecursivo(n.getHijoIzq());
            System.out.print(" " + n);
            inOrdenRecursivo(n.getHijoDer());
        }
    }

    public void postOrden() {
        if (raiz != null) {
            System.out.println("\nPostOrden");
            postOrdenRecursivo(raiz);
        }
    }

    private void postOrdenRecursivo(Nodo n) {
        if (n != null) {
            postOrdenRecursivo(n.getHijoIzq());
            postOrdenRecursivo(n.getHijoDer());
            System.out.print(" " + n);
        }
    }

    public String[] preOrden() {
        String result = "";
        if (raiz != null) {
            System.out.println("PreOrden");
            result = preOrdenRecursivo(raiz);
        }
        return result.split(";");
    }

    private String preOrdenRecursivo(Nodo n) {
        String result = "";
        if (n != null) {
            result += n + ";";
            preOrdenRecursivo(n.getHijoIzq());
            preOrdenRecursivo(n.getHijoDer());
        }
        return result.equals("") ? result : result.substring(0, result.length() -1);
    }
}
