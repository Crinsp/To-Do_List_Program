public class PrintItOut {
    //Printing out the ArrayList above if called within the options() class.
    public static void printItOut(){
        System.out.println("here is the current list!");
        for (int i = 0; i < ListItself.listItself.taskList.size(); i++) {
            System.out.println((i + 1) + ". " + ListItself.listItself.taskList.get(i));
        }
        System.out.println();
    }
}
