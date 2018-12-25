import java.util.*;
import java.util.function.IntFunction;

public class RadixQueues{



    public Queue<Integer> getTheQueue(){
        return theQueue;
    }

    private Queue<Integer> theQueue;
    private String queueName;
    static int numOfQueues = 0;

    public RadixQueues(String queueName){

        this.queueName = queueName + numOfQueues;
        numOfQueues++;

        theQueue = new LinkedList<Integer>();
    }


    public boolean addNumber(Integer number){
         return theQueue.offer(number);
    }

}
