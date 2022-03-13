/**
 * @author Hojat Ghasemi,
 * 2022-03-11
 * https://github.com/hojat72elect
 */
public class MainEntry {

    public static void main(String[] args) {
        // my java cheat sheet.
        // variables
        String myName = "Hojat";
        int myAge = 28;
        System.out.println("My name is " + myName + " and I'm " + myAge + " years old");
        myAge = 23;
        myName = "Ana";
        System.out.println("My girlfriend's name is " + myName + " and she's " + myAge + " years old.");

        // if
        // while
        int counter = 1;
        while (counter <= 5) {
            if (counter % 2 == 0) {
                System.out.println(counter + " is even");
            } else {
                System.out.println(counter + " is odd");
            }
            counter++;
        }

        // for
        for (int i = 0; i <= 5; i++) {
            System.out.print(i + "_");
        }

        // switch-case


    }
}
