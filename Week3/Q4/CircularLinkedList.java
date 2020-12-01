public class CircularLinkedList{
    private ListNode head;
    private ListNode tail;

    public CircularLinkedList(){
        head = tail = null;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public void addToHead(int item){
        if(isEmpty())
            head = tail = new ListNode(item);
        else{
            head = new ListNode(item,head);
            tail.next = head;
        }
    }

    public void addToTail(int item){
        if(isEmpty())
            head = tail = new ListNode(item);
        else{
            tail.next = new ListNode(item);
            tail = tail.next;
            tail.next = head;
        }
    }

    public Object removeFromHead() throws EmptyListException{
        if(isEmpty()){
            throw new EmptyListException();
        }
        Object item = head;
        if(head == tail)
            head = tail = null;
        else{
            tail.next = head.next;
            head = head.next;
        }
        return item;
    }

    public Object removeFromTail() throws EmptyListException{
        if(isEmpty()){
            throw new EmptyListException();
        }
        Object item = tail;
        if(head == tail){
            head = tail = null;
            return item;
        }
        ListNode current = head;
        while(current.next != tail)
            current = current.next;
        tail = current;
        tail.next = head;
        return item;
    } 

    public String toString() { 
        String s = "[ ";
        ListNode current = head;
        do{
            s += current.data + " ";
            current = current.next;
        }while(current != head);
        return s + "]";
    }
}