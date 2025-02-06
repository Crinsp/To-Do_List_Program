import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private static Scanner scnr = new Scanner (System.in);
    private static final String FILE_NAME = "ToDoSave.txt";

    //Listing out the options the user has to work with.
    public static void listOfOptions(){
        while (true) { // Use a loop instead of recursion
            System.out.println("Enter a number to select: \n1. Add a task\n2. Remove a task\n3. View the list\n4. Exit the program");
            if(scnr.hasNextInt()){
                int decision = scnr.nextInt();
                scnr.nextLine();

                if (decision == 4) {
                    System.out.println("Saving file and exiting...");
                    saveFile();
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

    public static void saveFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(String task : listItself.taskList){
                writer.write(task);
                writer.newLine();
            }
        }
        catch(IOException e){
            System.out.println("Error saving your tasks: " + e.getMessage());
        }
    }

    public static void loadSave(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null){
                listItself.taskList.add(line);
            }
        }
        catch(IOException e){
            System.out.println("Error while reading your file: " + e.getMessage());
        }
    }

    //Class in charge of storing the ArrayList.
    public class listItself{
        public static ArrayList<String> taskList = new ArrayList<>();
    }

    //Printing out the ArrayList above if called within the options() class.
    public static void printItOut(){
        System.out.println("here is the current list!");
        for (int i = 0; i < listItself.taskList.size(); i++) {
            System.out.println((i + 1) + ". " + listItself.taskList.get(i));
        }
        System.out.println();
    }

    //adds a task when called.
    public static void addATask(){
        System.out.println("Adding a task");
        String task = scnr.nextLine();
        listItself.taskList.add(task);
        //saveFile();
    }

    //removes a task when called (unfinished).
    public static void removeATask(){
        if(listItself.taskList.isEmpty()){
            System.out.println("The list is empty. Nothing to remove.");
            //saveFile();
            return;
        }

        System.out.println("Removing a task");
        System.out.println("Enter the number of the element you would like to remove: ");
        int taskToRemove = scnr.nextInt() - 1;
        if(taskToRemove >= 0){
            listItself.taskList.remove(taskToRemove);
        }
        else {
            System.out.println("Element does not exist and/or exceeds the length of the list: ");
            listOfOptions();
        }
        listOfOptions();
    }

    //Where your options go to when making the decision within listOfOptions().
    public static void options(int decision){
        switch(decision){
            case 1:
                addATask();
                break;
            case 2:
                removeATask();
                break;
            case 3:
                printItOut();
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    //Initialize the program and start off on the list of options.
    public static void main(String[] args) {
        loadSave();
        listOfOptions();
        System.exit(0);
    }
}
