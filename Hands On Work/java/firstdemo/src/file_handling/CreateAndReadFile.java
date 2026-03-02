package file_handling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateAndReadFile {
    public static void main(String[] args) {
   
        String filePath = "D:\\Users\\Pushkar Ghosh\\Desktop\\Capgemini Program\\FileHandling\\myFile.txt";

       
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Hello Pushkar!\n");
            writer.write("This file was successfully created for your Capgemini training.\n");
            System.out.println("Success: File created and data written to it.");
        } catch (IOException e) {
            System.out.println("Error: Could not create or write to the file.");
            e.printStackTrace();
        }

        System.out.println("\n--- Reading File Contents ---");

   
        File myFile = new File(filePath);
        try (Scanner scanner = new Scanner(myFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: Could not read the file.");
            e.printStackTrace();
        }
    }
}