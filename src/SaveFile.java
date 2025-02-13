import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
    public static void saveFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(ToDoList.FILE_NAME))){
            for(String task : ListItself.listItself.taskList){
                writer.write(task);
                writer.newLine();
            }
        }
        catch(IOException e){
            System.out.println("Error saving your tasks: " + e.getMessage());
        }
    }
}
