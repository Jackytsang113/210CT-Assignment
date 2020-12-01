
/**
 * Write a description of class s here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Doubly{
    public void addToHead(Object item);
    public void addToTail(Object item);
    
    public Object removeFromHead() throws EmptyListException;
    public Object removeFromTail() throws EmptyListException;
    public boolean isEmpty();
    public String toString();
    
    public String forward();
    public String backward();
}
