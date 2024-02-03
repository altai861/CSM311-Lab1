package lab1;

public class Queue<T> {
    private T[] array;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public Queue(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Method to add an item to the queue.
    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size++;
    }

    // Method to remove an item from queue.
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        T item = array[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Method to get the front item from the queue without removing it.
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No element to peek.");
            return null;
        }
        return array[front];
    }

    // Method to check if the queue is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full.
    public boolean isFull() {
        return size == capacity;
    }

    // Method to get the current size of the queue.
    public int size() {
        return size;
    }

    // Method to print the elements of the queue.
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        int count = 0;
        int index = front;
        while (count < size) {
            System.out.print(array[index] + " ");
            index = (index + 1) % capacity;
            count++;
        }
        
        System.out.println();
    }
    
    public void printAllTheWayUp() {
    	if (isEmpty()) {
    		System.out.println("Queue is empty.");
    	}
    	
    	System.out.println("Queue: ");
    	
    	for (int i = 0; i < rear; i++) {
    		System.out.print(array[i] + " ");
    	}
    	System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> integerQueue = new Queue<>(5);
        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        integerQueue.enqueue(3);

        integerQueue.printQueue(); // Output: Queue: 1 2 3

        System.out.println("Peek: " + integerQueue.peek()); // Output: Peek: 1

        System.out.println("Dequeued: " + integerQueue.dequeue()); // Output: Dequeued: 1
        System.out.println("Dequeued: " + integerQueue.dequeue());
        
        integerQueue.enqueue(4);
        integerQueue.enqueue(5);
        integerQueue.enqueue(6);
        integerQueue.enqueue(7);
        integerQueue.enqueue(8);


        integerQueue.printQueue(); // Output: Queue: 2 3
        
        System.out.println("Peek: " + integerQueue.peek()); 
        

        Queue<String> stringQueue = new Queue<>(3);
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");

        stringQueue.printQueue(); // Output: Queue: Hello World
    }
}


