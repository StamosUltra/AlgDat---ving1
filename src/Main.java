import java.util.Random;

/**
 * Created by joaki on 21.08.2017.
 *
 * Øving 1
 * Oppgave 1-1: Se Klassen: Aksjekurs
 *
 * Oppgave 1-2:
 * Vi har funnet at beste tilfelle er at algoritmen er Ω(n) (Gitt at den kun
 * utfører første løkke, og ikke trenger å kjøre neste løkkene)
 *
 * Verste tilfelle er O(n^2) (Gitt at laveste verdi kommer etter største verdi)
 *
 * Oppgave 1-3:
 * +-------------------+------------------------------+--------------+
 * | n                 | Tid:                         | multiplier:  |
 * +-------------------+------------------------------+--------------+
 * | 100               | 26469ns                      |6             |
 * +-------------------+------------------------------+--------------+
 * | 1000              | 168260ns                     |557           |
 * +-------------------+------------------------------+--------------+
 * | 10000             | 93858618ns                   |45            |
 * +-------------------+------------------------------+--------------+
 * | 100000            | 4226851592ns                 |102           |
 * +-------------------+------------------------------+--------------+
 * | 1000000           | 433143530434ns               |              |
 * +-------------------+------------------------------+--------------+
 *
 * Vi ser fra testdataene våre at når n er stor, så blir prosesseringstiden omtrent 100 ganger så stor.
 * Det er avvik, spesielt hoppet fra 1000 til 100, som kan skyldes andre prosesser som kjørte samtidig
 * på maskinen, eller IO-venting på å få plass i minnet.
 *
 */
public class Main {
    public static void main(String[] args) {
        Aksjekurs aksjekurs = new Aksjekurs();
        Random random = new Random();
        int arraySize = 200000;
        int[] kurs = new int[arraySize];
        int value = 0;
        for (int i = 0; i < arraySize; i++) {
            kurs[i] = random.nextInt(20) - 10;
            value += kurs[i];
        }
        Long start = System.nanoTime();

        int[] result = aksjekurs.saleAlgorithm(kurs);

        Long end = System.nanoTime();

        System.out.println("lowest: " + result[0] + ". Highest: " + result[1] + " difference: " + result[2] + "\n" +
                "Time: " +  (end - start));
    }
}
