
/**
 * Write a description of class d here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListNode{
    protected int data;
    protected ListNode next;
    
    public ListNode(){
        this.data = 0;
        this.next = null;
    }
    
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
    
    public ListNode(int data, ListNode next){
        this.data = data;
        this.next = next;
    }
}
