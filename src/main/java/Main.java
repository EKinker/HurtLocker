import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

        printTokens(splitIntoTokens(output));

    }

    public static List<String> splitIntoTokens(String input){
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, "##");
        while (st.hasMoreTokens()){
        tokens.add(st.nextToken());}
        return tokens;
    }

    public static void printTokens(List<String> list){
        for(String s : list){
            System.out.println(s);
        }
    }

    public List<Item> stringToItemList(List<String> list){

        return null;
    }
}
