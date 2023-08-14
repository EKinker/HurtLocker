import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception{
        Data data = new Data();

        String output = data.readRawDataToString();
        System.out.println(output);

        data.printTokens(data.splitIntoTokens(output));

    }


}
