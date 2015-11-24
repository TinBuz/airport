public class Queue<T> implements QueueInterface<T> {

    protected T[] items;
    protected int numItems, head, tail;

    public RAQueue() {
        numItems = head = 0;
        items = (T[]) new Object[3];
        tail = items.length - 1;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public T dequeue() {
        if(numItems == 0)
            return null;
        T temp = items[head];
        items[head] = null;
        if(head != tail)
            head = (head+1) % items.length;
        numItems--;
        return temp;
    }

    public T peek() {
        return items[head];
    }

    public void enqueue(T newItem) {
        if(numItems == items.length)
            resize();
        items[(tail + 1) % items.length] = newItem;
        tail = (tail + 1) % items.length;
        System.out.println(head);
        numItems++;

    }

    public void dequeueAll() {
        numItems = head = 0;
        items = (T[]) new Object[3];
        tail = items.length-1;
    }

    protected void resize() {
        T[] newItems = (T[]) new Object[(int)((items.length + 1) * 1.5)];
        for(int i = head; i < items.length + head; i++) {
            newItems[i-head] = items[i % items.length];
        }
        items = newItems;
        head = 0;
        tail = numItems - 1;
    }
    
     public String toString() {
        String returnString = "";
        for(int i = head; i<items.length + head; i++) {
            try {
                returnString += items[i % items.length].toString() + " ";
            }
            catch(NullPointerException e) {}
        }
        return returnString;
    }
}
