import java.util.Random;

/**
 * Created by joaki on 21.08.2017.
 */
public class Aksjekurs {
    private Random random;

    public Aksjekurs() {
    }

    public int[] saleAlgorithm(int[] numberArray) {
        int value = 0;
        int[] valueArray = new int[numberArray.length];
        int low = 0;
        int lowIndex = 0;
        int high = 0;
        int highIndex = 0;
        int difference = 0;

        for (int i = 0; i < numberArray.length; i++) {
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

        if (highIndex < lowIndex) {
            for (int i = 0; i < valueArray.length; i++) {
                for (int j = i; j < valueArray.length; j++) {
                    if (valueArray[j] - valueArray[i] > difference) {
                        difference = valueArray[j] - valueArray[i];
                        lowIndex = i;
                        highIndex = j;
                    }
                }

            }
        }


        int[] out = {lowIndex, highIndex};
        return out;
    }
}
