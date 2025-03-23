import java.io.*;

public class ReadGroceries {
    public static void main(String[] args) {
        String path = "Groceries.txt"; // 修改为实际路径
        try (
            FileReader filtered = new FileReader(path);
            BufferedReader reader = new BufferedReader(filtered)
        ) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}