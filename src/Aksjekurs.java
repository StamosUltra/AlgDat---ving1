import java.util.Random;

/**
 * Created by joaki on 21.08.2017.
 */
public class Aksjekurs {
    private Random random;

    public Aksjekurs() {
    }

    public int[] saleAlgorithm(int[] numberArray) {
        int length = numberArray.length;
        int value = 0;
        int[] valueArray = new int[length];
        int low = 0;
        int lowIndex = 0;
        int high = 0;
        int highIndex = 0;
        int difference = 0;

        /**
         * This first loop is made on the off chance that you are lucky, and will be a huge time saver
         */
        for (int i = 0; i < length; i++) {
            value += numberArray[i];
            valueArray[i] = value;
            if(value < low) {
                low = value;
                lowIndex = i;
            }

            else if (value > high) {
                high = value;
                highIndex = i;
            }
        }

        // Checks if the first loop worked
        if (highIndex < lowIndex) {
            for (int i = 0; i < length; i++) {
                for (int j = i; j < length; j++) {
                    if (valueArray[j] - valueArray[i] > difference) {
                        difference = valueArray[j] - valueArray[i];
                        lowIndex = i;
                        highIndex = j;
                    }
                }

            }
        }


        int[] out = {lowIndex, highIndex, difference};
        return out;
    }
}
