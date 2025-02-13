import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadSave {
    public static void loadSave() {
        File file = new File(ToDoList.FILE_NAME);

        try {
            if (!file.exists()) {
                //file.createNewFile(); // Create the file if it doesn't exist
                return;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    ListItself.listItself.taskList.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading your file: " + e.getMessage());
        }
    }
}
