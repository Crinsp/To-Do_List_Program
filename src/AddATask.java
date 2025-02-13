public class AddATask {
    //adds a task when called.
    public static void addATask(){
        System.out.println("Adding a task");
        String task = ToDoList.scnr.nextLine();
        ListItself.listItself.taskList.add(task);
        SaveFile.saveFile();
    }
}
