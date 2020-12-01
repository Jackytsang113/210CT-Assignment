
/**
 * Write a description of class SimBusStop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*; 
public class SimBusStop{
    public static void main (String[] args){
        //Scanner SimpleInput = new Scanner(System.in);
        Queue queue = new ArrayQueue(10);
        int code=0, time=0, count=0;
        Integer item;
        int people = 0;
        int wait = 0;
        int passedBus = 0;
        int vacantSeats = 0;
        int passenger = 0;

        code = SimpleInput.getInteger("Code: ");
        while (code!=-1) {
            time = SimpleInput.getInteger("Time: ");
            count = SimpleInput.getInteger("Count: ");
            if (code==0) {
                people += count; 
                while (count-- > 0)
                    queue.enqueue (new Integer(time));
            }
            else if (code==1) {
                passedBus++;
                while ( (count-- > 0) && !queue.empty ()){
                    item = (Integer) queue.dequeue ();
                    wait += time - item.intValue();
                    passenger++;
                }
                vacantSeats += count;
            }
            code = SimpleInput.getInteger("Code: ");
        }

        String printMsg = "";
        if (people!=0){
            printMsg = people
            + " people waited for "
            + wait + " minutes,"
            + "average waiting time = "
            + (float) wait/people
            + " minutes.";
        }else
            printMsg = "No people on the bus.";

        if(passedBus!=0){
            printMsg += "\nThe number of buses passed the bus stop = " 
            + passedBus
            + "\nAverage number of people got on a bus = " 
            + (float) people / passedBus
            + "\nAverage number of vacant seats for a bus leaving the bus stop = " 
            + (float) vacantSeats / passedBus;
        }else
            printMsg += "\nNo bus passed the bus stop.";

        int waitBusPeople = people - passenger;
        if(waitBusPeople > 0){
            wait = 0;
            while (!queue.empty ()) {  
                item = (Integer) queue.dequeue ();  
                wait += time - item.intValue();  
            }  
            
            printMsg += "\nThe number of people still waiting at the bus stop = "
            + waitBusPeople
            + " average waiting time = " 
            +  (float) wait/waitBusPeople 
            + " minutes";  
        }else
            printMsg += "\nNo people waiting at the station.";
 
        System.out.println(printMsg);
    }
}

