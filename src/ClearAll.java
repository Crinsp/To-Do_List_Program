public class ClearAll {
    //Unfinished atm, needs to be edited.
    public static void clearAll(){
        System.out.println("Are you sure you want to clear all tasks from the list? (y/n)");
        String clearDecision = ToDoList.scnr.nextLine();
        if(clearDecision.equalsIgnoreCase("y")){
            ListItself.listItself.taskList.clear();
            SaveFile.saveFile();
        }
        else if(clearDecision.equals("n")){
            OptionsList.listOfOptions();
        }
    }
}
