package aed;

public class ListaEnlazada<T> implements Secuencia<T>{
    // Acorde a mi convención y para dejar
    // todo más claro, primero es el índice i=0
    // último es i= N-1
    // Alternativamente, k=N-1 y k=0, respectivamente
    // (por si es conveniente)
    private Nodo primero;
    private Nodo ultimo;
    private int tamaño;

    private class Nodo {
        T valor;
        Nodo siguiente;
        Nodo anterior;

        // Constructor no hace falta definir su privacidad porque esta dentro 
        // de una clase privada?
        public Nodo(T v) {
            this.valor=v;
        }
    }

    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    public int longitud() {
        return this.tamaño;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        // Muevo todo un casillero
        nuevo.siguiente = this.primero;
        if (this.primero != null){
            this.primero.anterior = nuevo;
        }
        else {
            // en caso de que este vacío
            // el nuevo es el unico elemento
            this.ultimo = nuevo;
        }
        // el nuevo elemento ES el primero
        this.primero = nuevo;       
        this.tamaño++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        // De nuevo muevo, pero en el otro 
        // sentido
        nuevo.anterior = this.ultimo;
        if (this.ultimo != null){
            this.ultimo.siguiente = nuevo;
        }
        else {
            this.primero = nuevo;
        }
        this.ultimo = nuevo;
        this.tamaño++;
    }

    private Nodo obtenerNodo(int i) {
        Nodo actual;
        if (i <= this.tamaño / 2) {
            actual = this.primero;
            for (int j = 0; j < i; j++) {
                actual = actual.siguiente;
            }
        } else {
            actual = this.ultimo;
            for (int j = this.tamaño - 1; j > i; j--) {
                actual = actual.anterior;
            }
        }
        return actual;
    }
    public T obtener(int i) {
        return obtenerNodo(i).valor;
    }

    public void eliminar(int i) {
        Nodo actual=obtenerNodo(i);
        if (actual.anterior!=null){
            actual.anterior.siguiente=actual.siguiente;
        }
        else{
            this.primero=actual.siguiente;
        }
        if (actual.siguiente!=null){
            actual.siguiente.anterior=actual.anterior;
        }
        else{
            this.ultimo=actual.anterior;
        }
        this.tamaño--;

    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = obtenerNodo(indice);
        actual.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        this.primero=null;
        this.ultimo=null; 
        this.tamaño=0;
        Nodo actual = lista.primero;
        while (actual!=null){
            this.agregarAtras(actual.valor);
            actual=actual.siguiente;
        }
    }
    
    @Override
    public String toString() {
        Nodo actual = this.primero;
        String mensaje = "[";
        if (actual!= null){
            mensaje += String.valueOf(actual.valor);
        }
        else{
            return "[]";
        }
        actual = actual.siguiente;
        while (actual!=null) {
            mensaje += ", " + String.valueOf(actual.valor);
            actual = actual.siguiente;
        }
        mensaje += "]";
        return mensaje;
    }

    public class ListaIterador implements Iterador<T>{
        private int posicion;
        ListaIterador(){
            posicion = 0;
        }
        public boolean haySiguiente() {
	        return posicion<tamaño;
        }

        public T siguiente() {
            T valor = obtenerNodo(posicion).valor;
            posicion++;          
            return valor;
        }
        
        public boolean hayAnterior() {
	        return posicion>0;
        }
        
        public T anterior() {
            posicion--;          
	        T valor = obtenerNodo(posicion).valor;
            return valor;
        }
    }

    public ListaIterador iterador() {
	    return new ListaIterador();
    }

}
