public class Options {
    //Where your options go to when making the decision within listOfOptions().
    public static void options(int decision){
        switch(decision){
            case 1:
                AddATask.addATask();
                break;
            case 2:
                RemoveATask.removeATask();
                break;
            case 3:
                PrintItOut.printItOut();
                break;
            case 5:
                ClearAll.clearAll();
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }
}
