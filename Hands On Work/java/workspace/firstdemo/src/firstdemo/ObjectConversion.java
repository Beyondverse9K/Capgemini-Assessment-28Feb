package firstdemo;

import java.util.Scanner;

public class ObjectConversion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Object[] objectArray = new Object[10];
        int index = 0;
        System.out.println("Enter number of inputs:");
        int n = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter value (String):");
            String input = sc.nextLine();
            Object convertedObject = convertInput(input);
            objectArray[index++] = convertedObject;
        }
        System.out.println("\nStored Objects:");
        for (Object obj : objectArray) {
            if (obj != null) {
                System.out.println(obj + " -> " + obj.getClass());
            }
        }
        sc.close();
    }
    public static Object convertInput(String input) {
        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            return Boolean.valueOf(input);
        }
        if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
            return Character.valueOf(input.charAt(0));
        }
        try {
            return Long.valueOf(input);
        } catch (NumberFormatException ignored) {}
        try {
            return Double.valueOf(input);
        } catch (NumberFormatException ignored) {}
        return input;
    }
}

