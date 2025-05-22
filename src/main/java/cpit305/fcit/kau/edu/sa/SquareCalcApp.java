package cpit305.fcit.kau.edu.sa;

import java.util.Scanner;

public class SquareCalcApp {

    // Complete this method but do not change the method name
    public static int square(int number) throws OutOfRangeException {
        if (number < 0 || number > 100) {
            throw new OutOfRangeException(0, 100);
        }
        return number * number;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to calculate its square (0 to 100): ");

        try {
            int num = Integer.parseInt(input.nextLine());
            int result = square(num);
            System.out.println(num + " * " + num + " = " + result);
        } catch (OutOfRangeException e) {
            System.err.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: Please enter an integer.");
        } finally {
            System.out.println("Execution complete.");
        }
    }
}
