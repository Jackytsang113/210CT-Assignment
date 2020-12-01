public class QueueEmptyException extends RuntimeException{
    public QueueEmptyException(){
        super("Queue is empty");
    }
}