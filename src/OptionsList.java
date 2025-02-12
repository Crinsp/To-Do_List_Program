import java.util.Scanner;

public class OptionsList extends ToDoList{
    public static void listOfOptions(){
        Scanner scnr = new Scanner(System.in);
        while (true) { // Use a loop instead of recursion
            System.out.println("Enter a number to select: \n1. Add a task\n2. Remove a task\n3. View the list\n4. Exit the program\n5. Clear all tasks");
            if(scnr.hasNextInt()){
                int decision = scnr.nextInt();
                scnr.nextLine();

                if (decision == 4) {
                    System.out.println("Saving file and exiting...");
                    saveFile();
                    scnr.close();
                    System.exit(0);
                    break;
                }
                options(decision);
            }
            else{
                System.out.println("Invalid input. Please enter a number.");
                scnr.nextLine();
            }
        }
    }
}
