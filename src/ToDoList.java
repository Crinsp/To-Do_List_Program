import java.util.Scanner;

public class ToDoList {
    public static final Scanner scnr = new Scanner (System.in);
    public static final String FILE_NAME = "ToDoSave.txt";

    //Initialize the program and start off on the list of options.
    public static void main(String[] args) {
        LoadSave.loadSave();
        OptionsList.listOfOptions();
        System.exit(0);
    }
}
