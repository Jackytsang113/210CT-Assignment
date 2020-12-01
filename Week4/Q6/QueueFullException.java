public class QueueFullException extends RuntimeException{
    public QueueFullException(){
    super("Queue is full");
    }
}