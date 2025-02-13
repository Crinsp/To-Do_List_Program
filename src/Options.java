public class Options {
    //Where your options go to when making the decision within listOfOptions().
    public static void options(int decision){
        switch(decision){
            case 1:
                ToDoList.addATask();
                break;
            case 2:
                ToDoList.removeATask();
                break;
            case 3:
                ToDoList.printItOut();
                break;
            case 5:
                ToDoList.clearAll();
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }
}
