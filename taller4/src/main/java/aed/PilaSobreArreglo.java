package aed;

public class PilaSobreArreglo implements Pila {
    private int[] elems;
    // Cantidad de elementos; el tope está en elems[size - 1]
    private int size;

    public PilaSobreArreglo(int capacity) {
        elems = new int[capacity];
        size = 0;
    }

    public void push(int elem) {
        elems[size] = elem;
        size++;
    }

    public int pop() {
        int elem = top();
        size--;
        return elem;
    }

    public int top() {
        return elems[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elems.length;
    }
}
