package trial2;

import org.apache.commons.io.IOUtils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Round2Fight {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        return IOUtils.toString(Objects.requireNonNull(classLoader.getResourceAsStream("RawData.txt")));
    }

    public static void main(String[] args) throws Exception {
        String output = (new Round2Fight()).readRawDataToString();
        //System.out.println(output);

        String regexPattern = "[Nn]\\w{3}:(\\w*)\\S[Pp]\\w{4}:(\\d+.?\\d+)?";
        Pattern pattern = Pattern.compile(regexPattern);
        Map<String, Map<String, Integer>> results = new HashMap<>();
        int errorCounter = 0;

        Matcher matcher = pattern.matcher(output);
        while (matcher.find()) {
            String outerKey = matcher.group(1);
            String innerKey = matcher.group(2);

            if (outerKey != null && !outerKey.isEmpty() && innerKey != null && !innerKey.isEmpty()) {
                String formattedName = capitalize(replaceZeroes(outerKey));

                results.computeIfAbsent(formattedName, k -> new HashMap<>())
                        .merge(innerKey, 1, Integer::sum);
            } else {
                errorCounter++;
            }
        }

        results.forEach((outerKey, innerMap) -> {
            System.out.printf("Name: %-15s Seen: %3d times\n", outerKey, innerMap.values().stream().mapToInt(Integer::intValue).sum());
            System.out.println("=============\t\t =============");
            innerMap.forEach((innerKey, count) -> System.out.printf("Price: %-14s Seen: %3d times\n", innerKey, count));
            System.out.println("-------------\t\t -------------\n");
        });
        System.out.printf("%-21s Seen: %3s times\n", "Errors", errorCounter);


        String outputFile = "finalAnswer.txt";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            results.forEach((outerKey, innerMap) -> {

                try {
                    bw.write(String.format("Name: %-15s Seen: %d times\n", outerKey, innerMap.values().stream()
                            .mapToInt(Integer::intValue).sum()));
                    bw.write("=============\t\t =============\n");
                    innerMap.forEach((innerKey, count) -> {
                        try {
                            bw.write(String.format("Price: %-14s Seen: %d times\n", innerKey, count));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    bw.write("-------------\t\t -------------\n\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            bw.write(String.format("%-21s Seen: %s times\n", "Errors", errorCounter));
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String capitalize(String input) {

        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static String replaceZeroes(String input) {
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                charArray[i] = 'o';
            }
        }
        return new String(charArray);
    }
}

