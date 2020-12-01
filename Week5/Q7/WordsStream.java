/**
 * Write a description of class WordStream here.
 *
 * @author TsangHoYin
 * @version 1.0
 */
public class WordsStream extends DoublyLinked implements Doubly{
    private DoublyNode firstword =  null;
    private DoublyNode secondword =  null;
    private DoublyNode thirdword =  null;
    private String word1, word2;
    public WordsStream(){
        super();
    }

    public void activeWord(){
        DoublyNode current = head;
        int noMove = 0;
        int linkedsize = 0;
        while(current != null){
            linkedsize++;
            current = current.next;
        }
        DoublyNode moveword;
        while(noMove < linkedsize - 1){                                     // loop until there is no movement of Node
            current = head;
            moveword = head;
            noMove = 0;
            while(current != null){
                firstword = moveword.prev;                                  // firstword is moveword of previous Node
                secondword = moveword.next;                                 // secondword is moveword of next Node
                if(moveword != tail){
                    word1 = moveword.data.toString();                       // word1 is moveword word
                    word2 = secondword.data.toString();                     // word2 is secondword word
                    thirdword = moveword.next.next;                         // thirdword is secondword of next Node
                    if(word1.length() > word2.length())                     // if word1 is greater than word2
                        moveWord(firstword, secondword, thirdword, moveword); // move Node  
                                                                            // if word 1 and word 2 are the same length and the first letter of word 1 is larger than word 2
                    else if(word1.length() == word2.length() && checkletter(word1, word2))
                        moveWord(firstword, secondword, thirdword, moveword);  // move Node
                    else
                        noMove++;                                           // if Node no move, the noMove will be +1
                    moveword = moveword.next;
                }
                current = current.next;
            }
        }
    }
    // Use the Bubble-sort
    private void moveWord(DoublyNode firstword, DoublyNode secondword, DoublyNode thirdword, DoublyNode moveword){
        if(moveword.next.next !=null)                                       // if thirdword no is null
            thirdword.prev = moveword;                                      // the thirdword of previous Node to moveword
        else
            thirdword = null;
        secondword.next = moveword;                                         // the secondword of next node to moveword
        if(moveword == head){                                               // if moveword is head
            secondword.prev = null;
            head = secondword;                                              // head is secondword
        }else{
            secondword.prev = moveword.prev;                                // the secondword of previous Node to moveword of previous Node
            firstword.next = secondword;                                    // the firstword of next Node to secondword
        }
        if(secondword == tail){                                             // if secondword is tail
            moveword.next = null;
            tail = moveword;                                                // tail is moveword
        }else
            moveword.next = thirdword;                                      // the moveword of next Node to thirdword
        moveword.prev = secondword;                                         // the moveword of pervious to secondword
    }

    private boolean checkletter(String word1, String word2){
        char letter1 = Character.toUpperCase(word1.charAt(0));
        char letter2 = Character.toUpperCase(word2.charAt(0));
        boolean isLettercase = false;;
        
        if(letter1 > letter2){                                              //check whether the first letter of word 1 is larger than word 2
            isLettercase = true;
        }
        return isLettercase;
    }
    
    public void removeAllNode(){
        DoublyNode current = head;
        
        while(current != null){
            removeFromHead();
            current = current.next;
        }
    }
}
