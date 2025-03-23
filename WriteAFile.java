import java.io.*;

public class WriteAFile {
    public static void main(String[] args) {
        String writtenFile = "WriteAFileExample.txt";
        try (
            FileWriter filewrite = new FileWriter(writtenFile);
            BufferedWriter writer = new BufferedWriter(filewrite)
        ) {
            writer.write("Hello, World!");
            writer.newLine();
            writer.write("This is a sample text.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}