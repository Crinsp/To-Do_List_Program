import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class ToDoList {

    private static Scanner scnr = new Scanner (System.in);
    public static final String FILE_NAME = "ToDoSave.txt";

    /*public static void saveFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(String task : listItself.taskList){
                writer.write(task);
                writer.newLine();
            }
        }
        catch(IOException e){
            System.out.println("Error saving your tasks: " + e.getMessage());
        }
    }*/

    public static void loadSave() {
        File file = new File(FILE_NAME);

        try {
            if (!file.exists()) {
                file.createNewFile(); // Create the file if it doesn't exist
                return;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    listItself.taskList.add(line);
                }
            }
        } catch (IOException e) {
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
        SaveFile.saveFile();
    }

    //removes a task when called (unfinished).
    public static void removeATask(){
        if(listItself.taskList.isEmpty()){
            System.out.println("The list is empty. Nothing to remove.");
            SaveFile.saveFile();
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
            OptionsList.listOfOptions();
        }
        OptionsList.listOfOptions();
    }

    //Unfinished atm, needs to be edited.
    public static void clearAll(){
        System.out.println("Are you sure you want to clear all tasks from the list? (y/n)");
        String clearDecision = scnr.nextLine();
        if(clearDecision.equalsIgnoreCase("y")){
            listItself.taskList.clear();
            SaveFile.saveFile();
        }
        else if(clearDecision == "n"){
           OptionsList.listOfOptions();
        }
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
            case 5:
                clearAll();
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    //Initialize the program and start off on the list of options.
    public static void main(String[] args) {
        loadSave();
        OptionsList.listOfOptions();
        System.exit(0);
    }
}
