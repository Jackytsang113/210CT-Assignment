
/**
 * Write a description of class runMain here.
 *
 * @author TsangHoYin
 * @version 1.0
 */
public class runMain{
    public static void main(String[] args){
        Queue queue = new ArrayQueue(4);
        queue.enqueue("Jacky");
        queue.enqueue("Flowerboy");
        queue.enqueue("FatKit");
        System.out.println(queue);
        System.out.println("Removed: " + queue.dequeue());
        System.out.println(queue);
        System.out.println("Removed: " + queue.dequeue());
        System.out.println(queue);
        System.out.println("Removed: " + queue.dequeue());
        System.out.println(queue);
    }
}
