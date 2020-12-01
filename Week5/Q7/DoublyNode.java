
/**
 * Write a description of class DoublyNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DoublyNode{
    protected Object data;
    protected DoublyNode next;
    protected DoublyNode prev;

    public DoublyNode(){
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    public DoublyNode(Object data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
