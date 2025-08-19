package programas-19agosto;

/**
 *
 * @author Armando Betancourt Esparza
 */
public class Queue<E> {

    public static final int CAPACITY = 1000;

    private E[] data;
    private int size = 0;

    public Queue() {
        this.data = (E[]) new Object[this.CAPACITY];
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int size() {
        return this.size;
    }

    public void push(E value) {
        this.data[this.size] = value;
        this.size++;
    }

    public E pop() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("La cola esta vacia");
        }
        E result = this.data[0];
        for (int i = 0; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.size--;
        this.data[this.size] = null;
        return result;
    }

    public E peek() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("La cola esta vaciaa");
        }
        return this.data[0];
    }
}
