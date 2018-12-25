import java.util.*;

public class RadixSimulator {

    //Declare an ArrayList if Queues Q0 -> Q9
    //Q10 acts as a dump queue
    public static List<RadixQueues> arrayListOfRadixQueues = new ArrayList<>(11);
    public static Queue<Integer> Q10 = new LinkedList<>();



    //Adds a number from randomArray into said number's respected Queue based on Queue subscript (ie index)
    public static void addToQueue(Integer[] randomArray,int place) {

        for (int i = 0; i < randomArray.length; i++) {

            int queueIndex = (int) (randomArray[i] / Math.pow(10, place)) % 10;
            arrayListOfRadixQueues.get(queueIndex).addNumber(randomArray[i]);
        }

    }



    static void mergeQueues() {

        //Loop through the Queues in the arrayListOfRadixQueues
        for (int i = 0; i < arrayListOfRadixQueues.size(); i++) {

            //Iterate through the contents of said Queue
            //Add each number from currently selected Queue into Q10
            Iterator<Integer> queueIter = arrayListOfRadixQueues.get(i).getTheQueue().iterator();

            while (queueIter.hasNext()){
                int number = queueIter.next();
                Q10.add(number);
                //System.out.println(number);
            }
        }

        //Clear contents from each Queue in arrayListOfRadixQueues
        for(int j = 0; j < arrayListOfRadixQueues.size(); j++){
            arrayListOfRadixQueues.get(j).getTheQueue().clear();

            }
    }


    public static Integer[] dumpQ10(Integer[] randomArray) {

        int i = 0;

        //Dump numbers from Q10 back into randomArray
        while (i < randomArray.length) {
            for (Integer number : Q10) {
                randomArray[i] = number;
                i++;
            }
        }

        //Clear Q10
        Q10.clear();

        //Return randomArray to start the Radix Sort again starting from the next digit
        return randomArray;

    }

    public static void main(String[] args) {

        //Make 10 Queues
        for (int i = 0; i < 10; i++) {
            RadixQueues queues = new RadixQueues("Queue #");
            arrayListOfRadixQueues.add(queues);
        }

        Scanner keyboard = new Scanner(System.in);
        System.out.print("How many integers would you like to Radix Sort: ");
        int size = keyboard.nextInt();

        System.out.print("What is the max you would like the random seed to be capped at when choosing integers (max is 999999999): ");
        int max = keyboard.nextInt();

        //Make an array of random positive integers
        Integer[] randomArray = new Integer[size];

        int min = 0;
        Random randomInt = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = randomInt.nextInt(max - min);
        }

        System.out.println("Initial Array: " + Arrays.toString(randomArray));

        //While loop takes control of radix sort by the digit
        //Starts at the Ones digit, then tens, ...., ending at 10^10.
        //Prints out sorted array at end
        //Placement keep track of where the Radix Sort is taking place
        int placement = 1;
        //Place keeps track of what power the 10 in addToQueue is being raised to
        int place = 0;
        while (placement < 1000000000) {
            Sort.radixSort(randomArray,placement);
            addToQueue(randomArray, place);
            place++;
            mergeQueues();
            dumpQ10(randomArray);
            System.out.println("Sorted by " + placement + "s place: " + Arrays.toString(randomArray));
            placement *= 10;
        }
        System.out.println("FINAL SORTED ARRAY: " + Arrays.toString(randomArray));
    }
}





