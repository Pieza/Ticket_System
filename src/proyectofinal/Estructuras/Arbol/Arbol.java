package proyectofinal.Estructuras.Arbol;

public class Arbol {

    private Nodo raiz;

    public void inserta(int num) {
        if (raiz == null) {
            raiz = new Nodo(num);
        } else {
            insertaRecursivo(num, raiz);//mandamos raiz porque es la referencia del nivel que estamos
        }
    }

    private void insertaRecursivo(int num, Nodo n) {
        if (num <= n.getDato()) {
            //insertamos a la izquierda
            if (n.getHijoIzq() == null) {
                n.setHijoIzq(new Nodo(num));
            } else {
                insertaRecursivo(num, n.getHijoIzq());//le mandamos el hijoIzq porque es el nodo donde estamos
            }
        } else {
            //insertamos a la derecha
            if (n.getHijoDer() == null) {
                n.setHijoDer(new Nodo(num));
            } else {
                insertaRecursivo(num, n.getHijoDer());//le mandamos el hijoDer
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

    public void preOrden() {
        if (raiz != null) {
            System.out.println("PreOrden");
            preOrdenRecursivo(raiz);
        }
    }

    private void preOrdenRecursivo(Nodo n) {
        if (n != null) {
            System.out.print(" " + n);
            preOrdenRecursivo(n.getHijoIzq());
            preOrdenRecursivo(n.getHijoDer());
        }
    }
}
