
/**
 * Write a description of class Test here.
 *
 * @author TsangHoYin
 * @version 1.0
 */
public class Test{
    public static void main(String[] args){
        CircularLinkedList cll = new CircularLinkedList();
        cll.addToHead(20);
        cll.addToHead(60);
        cll.addToTail(80);
        System.out.println(cll);
        System.out.println("Remove Tail node: ");
        cll.removeFromTail();
        System.out.println(cll);
        System.out.println("Remove Head node: ");
        cll.removeFromHead();
        System.out.println(cll);
    }
}
