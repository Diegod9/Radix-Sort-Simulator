import java.util.ArrayList;
import java.util.List;

public class Sort {

    public static void radixSort(Integer[] inputArray, int placement) {

        final int RADIXNUMBER = 10;

        List<Integer>[] bucket = new ArrayList[RADIXNUMBER];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        boolean maxLength = false;
        int temp;
        //Starting at the one's place
        while (maxLength) {

            for (Integer i : inputArray) {
                temp = i / placement;
                bucket[temp % RADIXNUMBER].add(i);
                if (maxLength && temp > 0) {
                    maxLength = false;
                }
            }

            int j = 0;
            for (int k = 0; k < RADIXNUMBER; k++) {
                for (Integer i : bucket[k]) {
                    inputArray[j++] = i;
                }
                bucket[k].clear();
            }

            //Move to the next digit in the integer
            placement *= RADIXNUMBER;

            //Goes to the randomArray addToQueue method
            RadixSimulator.addToQueue(inputArray,placement);


        }
    }
}


