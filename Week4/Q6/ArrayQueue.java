
/**
 * Write a description of class ArrayQueue here.
 *
 * @author TsangHoYin
 * @version 1.0
 */
public class ArrayQueue implements Queue{
    private Object[] array;
    private int front;
    private int rear;
    private int capacity;

    public ArrayQueue(){
        this.capacity = 10;
        array = new Object[capacity];
        rear = front = 0;
    }
    
    public ArrayQueue(int size){
        this.capacity = size;
        array = new Object[capacity];
        rear = front = 0;
    }
    
    public boolean empty(){
        return (front == rear);
    }

    public int size(){
        return (capacity - front + rear) % capacity;
    }
    
    public boolean full(){
        return (size()+1 == capacity);
    }
   
    public void enqueue(Object item) throws QueueFullException{
        if(full())
            throw new QueueFullException();
        array[rear] = item;
        rear = (rear + 1) % capacity;
    }
    
    public Object dequeue() throws QueueEmptyException{
        if(empty())
            throw new QueueEmptyException();
        Object item = array[front];
        array[front] = null;
        front = (front + 1) % capacity;
        return item;
    }
    
    public Object frount() throws QueueEmptyException{
        if(empty())
            throw new QueueEmptyException();
        return array[front];
    }
    
    public String toString(){
        String print = "[ ";
        for(Object data: array){
            print += data + " ";
        }
        print += "]";
        return print;
    }
}
