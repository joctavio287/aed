package aed;

public class ColaSobreListaEnlazada implements Cola {
    
    private Node head;
    private Node tail;

    public ColaSobreListaEnlazada() {
        head = null;
        tail = null;
    }

    public void enqueue(int elem) {
        Node nuevo = new Node(elem);
        if (isEmpty()) {
            head = nuevo;
        } else {
            tail.next = nuevo;
        }
        tail = nuevo;
    }

    public int dequeue() {
        int elem = front();
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return elem;
    }

    public int front() {
        return head.data;
    }

    public int rear() {
        return tail.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Una lista enlazada no tiene capacidad fija
    public boolean isFull() {
        return false;
    }
}
