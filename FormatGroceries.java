import java.io.*;
import java.text.DecimalFormat;

public class FormatGroceries {
    public static void main(String[] args) {
        String inputPath = "Groceries.txt";
        String outputPath = "FormattedGroceries.txt";
        double total = 0.0;
        DecimalFormat df = new DecimalFormat("0.00");

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) { // 修复此处缺少的右括号
            writer.write("*******************************************************");
            writer.newLine();
            writer.write("| ID    | Item    | Quantity (KG) | Price (€) |");
            writer.newLine();
            writer.write("|*******************************************************|");
            writer.newLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0].trim();
                String item = parts[1].trim();
                String quantity = parts[2].replace("KG", "").trim();
                String price = parts[3].trim();
                total += Double.parseDouble(price);

                writer.write(String.format("| %-5s | %-7s | %-13s | %-9s |", id, item, quantity, price));
                writer.newLine();
            }

            writer.write("*******************************************************");
            writer.newLine();
            writer.write("The grocery shopping total is: €" + df.format(total));
            writer.newLine();
            writer.write("*******************************************************");

        } catch (IOException e) {
            System.err.println("File processing error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Numerical analysis error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Data format error: row field incomplete");
        }
    }
}