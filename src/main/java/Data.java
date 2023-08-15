import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Data {

    Map<String, Map<Double, Integer>> results;


    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public List<String> splitIntoTokens(String input){
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, "##");
        while (st.hasMoreTokens()){
            tokens.add(st.nextToken());}
        return tokens;
    }

    public void printTokens(List<String> list){  //for testing
        for(String s : list){
            System.out.println(s);
        }
    }

    public List<Item> createItemList(List<String> list){
        List<Item> result = new ArrayList<>();
        for(String s: list){
            result.add(new Item(s));
        }
        return result;
    }

    public Map<Double, Integer> incrementItemCount(Map<Double,Integer> map, Item item){
        if (map.containsKey(item.getPrice())){
            map.put(item.getPrice(),map.get(item.getPrice())+1);
        } else {
            map.put(item.getPrice(),1);
        }
        return map;
    }
}
