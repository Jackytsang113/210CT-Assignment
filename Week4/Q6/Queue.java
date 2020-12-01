public interface Queue{
    public void enqueue(Object item) throws QueueFullException;
    public Object dequeue() throws QueueEmptyException; 
    public Object frount() throws QueueEmptyException;
    public boolean empty();
    public boolean full();
    public int size();
    public String toString();
}
