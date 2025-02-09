package cpit305.fcit.kau.edu.sa;

import java.util.Scanner;

// Custom Exception for out-of-range numbers
public class OutOfRangeException extends Exception {
    public OutOfRangeException(String message) {
        super(message);
    }
}

class SquareCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.print("Enter an integer (0-100) or -1 to exit: ");
                if (!scanner.hasNextInt()) {
                    throw new NumberFormatException("Input is not a valid integer.");
                }
                
                int number = scanner.nextInt();
                if (number == -1) {
                    System.out.println("Exiting program.");
                    break;
                }
                
                if (number < 0 || number > 100) {
                    throw new OutOfRangeException("Number is out of range (0-100)." );
                }
                
                System.out.println("Square of " + number + " is: " + (number * number));
            } catch (NumberFormatException e) {
                System.out.println("Exception: " + e.getMessage());
                scanner.next(); // Clear invalid input
            } catch (OutOfRangeException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}
