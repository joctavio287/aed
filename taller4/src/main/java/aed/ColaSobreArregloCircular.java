package aed;

public class ColaSobreArregloCircular implements Cola {
    private int[] elems;
    // Índice del frente (head); el final (tail) se deduce de head y size
    private int head;
    private int size;

    public ColaSobreArregloCircular(int i) {
        elems = new int[i];
        head = 0;
        size = 0;
    }

    // Inserta en el final (tail)
    public void enqueue(int elem) {
        if (isFull()) {
            throw new IllegalStateException("La cola está llena");
        }
        int tail = (head + size) % elems.length;
        elems[tail] = elem;
        size++;
    }

    // Obtiene el elemento del frente (head)
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        int elem = front();
        head = (head + 1) % elems.length;
        size--;
        return elem;
    }

    // Obtiene el elemento del frente (head)
    public int front() {
        return elems[head];
    }

    // Obtiene el elemento del final (tail)
    public int rear() {
        return elems[(head + size - 1) % elems.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elems.length;
    }
}
