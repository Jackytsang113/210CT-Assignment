
/**
 * Write a description of class DoublyLinked here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DoublyLinked implements Doubly{
    protected DoublyNode head;
    protected DoublyNode tail;

    public DoublyLinked(){
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public void addToHead(Object item){
        if(isEmpty())
            head = tail = new DoublyNode(item);
        else{
            DoublyNode newNode = new DoublyNode(item);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addToTail(Object item){
        if(isEmpty())
            head = tail = new DoublyNode(item);
        else{
            DoublyNode newNode = new DoublyNode(item);
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Object removeFromHead() throws EmptyListException{
        if(isEmpty())
            throw new EmptyListException();
        Object item = head.data;
        if(head == tail)
            head = tail = null;
        else{
            head.next.prev = null;
            head = head.next;
        }
        return item;
    }

    public Object removeFromTail() throws EmptyListException{
        Object item = null;
        if(isEmpty())
            throw new EmptyListException();
        item = tail.data;
        if(head == tail)
            head = tail = null;
        else{
            tail.prev.next = null;
            tail = tail.prev;
        }
        return item;
    }

    public String toString() { 
        String s = "[ ";
        DoublyNode current = head;
        while (current != null) {
            s += current.data + " ";
            current = current.next;
        }
        return s + "]";
    }

    public String forward(){
        return toString();
    }

    public String backward(){
        String s = "[ ";
        DoublyNode current = tail;
        while (current != null) {
            s += current.data + " ";
            current = current.prev;
        }
        return s + "]";
    }
}
