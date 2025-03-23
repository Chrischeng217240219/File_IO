import java.io.*;
import java.util.Scanner;

public class DiaryWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String diaryFile = "Diary.txt";
        try (
            FileWriter fileWriter = new FileWriter(diaryFile);
            BufferedWriter writer = new BufferedWriter(fileWriter)
        ) {
            System.out.println("Enter your diary entries (type 'END' to finish):");
            String input;
            while (true) {
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("END")) {
                    break;
                }
                writer.write(input);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to diary: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}