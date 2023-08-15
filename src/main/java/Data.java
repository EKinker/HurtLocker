import org.apache.commons.io.IOUtils;

import java.util.*;

public class Data {

    private Map<String, Map<Double, Integer>> results;
    private int errorCount;

    public Data() {
        this.results = new HashMap<>();
        this.errorCount = 0;
    }

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public List<String> splitIntoTokens(String input) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, "##");
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        return tokens;
    }

    public void printTokens(List<String> list) {  //for testing
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<Item> createItemList(List<String> list) {
        List<Item> result = new ArrayList<>();
        for (String s : list) {
            result.add(new Item(s));
        }
        return result;
    }

    public void populateResults(List<Item> items) {
        for (Item i : items) {
            addItem(i);
        }
    }

    public void addItem(Item item) {
        if (item.getName() == null) {
            errorCount++;
        } else {
            Map<Double, Integer> innerMap = results.get(item.getName());
            if (innerMap == null) {
                innerMap = new HashMap<>();
                innerMap.put(item.getPrice(), 1);
                results.put(item.getName(), innerMap);
            } else {
                if (innerMap.get(item.getPrice()) == null) {
                    innerMap.put(item.getPrice(), 1);
                } else {
                    innerMap.put(item.getPrice(), innerMap.get(item.getPrice()) + 1);
                }
            }
        }
    }

    public Map<String, Map<Double, Integer>> getResults() {
        return results;
    }

    public int getErrorCount() {
        return errorCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Map<Double, Integer>> map : results.entrySet()) {
            sb.append("Name: " + map.getKey() + "  Price: $");

        }
        return sb.toString();
//        return "Data{" +
//                "results=" + results +
//                ", errorCount=" + errorCount +
//                '}';
    }
//    public Map<Double, Integer> incrementItemCount(Map<Double, Integer> map, Item item) {
//        if (map.containsKey(item.getPrice())) {
//            map.put(item.getPrice(), map.get(item.getPrice()) + 1);
//        } else {
//            map.put(item.getPrice(), 1);
//        }
//        return map;
//    }
}
