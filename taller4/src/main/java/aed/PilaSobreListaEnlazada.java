package aed;

public class PilaSobreListaEnlazada implements Pila {
    // El tope de la pila es el primer nodo de la lista
    private Node head;

    public PilaSobreListaEnlazada() {
        head = null;
    }

    public void push(int elem) {
        Node nuevo = new Node(elem);
        nuevo.next = head;
        head = nuevo;
    }

    public int pop() {
        int elem = top();
        head = head.next;
        return elem;
    }

    public int top() {
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Una lista enlazada no tiene capacidad fija
    public boolean isFull() {
        return false;
    }
}
