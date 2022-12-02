import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        try {

            reader = new BufferedReader(new FileReader("/Users/ahmedbaig/work/Side_Projects/AOC2022/day1/data.txt"));
            String line = reader.readLine();

            int mostCalories = 0;
            int bulkiestElf = 0;
            int elfNumber = 0;
            int elfSum = 0;

            List<Integer> top3 = new ArrayList<Integer>();

            while (line != null) { 
                if (line.isEmpty()) {
                    elfNumber++;
                    if (elfSum > mostCalories) {
                        mostCalories = elfSum;
                        bulkiestElf = elfNumber;
                    }
                    if (top3.size() < 3) {            
                        top3.add(elfSum);
                    } else {
                        for (int i = 0; i < top3.size() - 1; i++) {
                            if (top3.get(i) < elfSum) { 
                                top3.set(i, elfSum); 
                                top3.sort(null);
                                break;
                            }
                        }
                    } 
                    elfSum = 0;
                } else {
                    elfSum += Integer.parseInt(line);
                }
                line = reader.readLine();
            } 
            reader.close(); 
            System.out.println(String.format("Elf: %d Calories: %d", bulkiestElf, mostCalories)); 
            System.out.println(top3.toString()); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}