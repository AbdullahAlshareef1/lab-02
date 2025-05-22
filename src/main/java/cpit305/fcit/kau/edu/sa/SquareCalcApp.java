package cpit305.fcit.kau.edu.sa;

import javax.swing.*;

public class SquareCalcApp {

    public static int square(int number) throws OutOfRangeException {
        if (number < 0 || number > 100) {
            throw new OutOfRangeException(0, 100);
        }
        return number * number;
    }

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter number to power it:");

        try {
            int x = Integer.parseInt(input);
            System.out.println(x + " * " + x + " = " + square(x));
        } catch (OutOfRangeException e) {
            System.err.println("Custom Exception: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please enter an integer.");
        } finally {
            System.out.println("This is Finally Block");
        }

        System.out.println("This is Next Statement");
    }
}
