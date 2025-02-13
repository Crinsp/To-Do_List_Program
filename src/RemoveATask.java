public class RemoveATask {
    //removes a task when called (unfinished).
    public static void removeATask(){
        if(ListItself.listItself.taskList.isEmpty()){
            System.out.println("The list is empty. Nothing to remove.");
            SaveFile.saveFile();
            return;
        }

        System.out.println("Removing a task");
        System.out.println("Enter the number of the element you would like to remove: ");
        int taskToRemove = ToDoList.scnr.nextInt() - 1;
        if(taskToRemove >= 0){
            ListItself.listItself.taskList.remove(taskToRemove);
        }
        else {
            System.out.println("Element does not exist and/or exceeds the length of the list: ");
            OptionsList.listOfOptions();
        }
        OptionsList.listOfOptions();
    }
}
