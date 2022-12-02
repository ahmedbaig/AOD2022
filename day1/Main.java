import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        try {

            reader = new BufferedReader(new FileReader("data.txt"));
            String line = reader.readLine();

            int mostCalories = 0;
            int bulkiestElf = 0;
            int elfNumber = 0;
            int elfSum = 0;

            while (line != null) {

                if (line.isEmpty()) {
                    elfNumber++; 
                    if (elfSum > mostCalories) {
                        mostCalories = elfSum;
                        bulkiestElf = elfNumber;
                    }
                    elfSum = 0;
                } else {
                    elfSum += Integer.parseInt(line);
                }
                line = reader.readLine();
            }

            reader.close();

            System.out.println(String.format("Elf: %d Calories: %d", bulkiestElf, mostCalories));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}