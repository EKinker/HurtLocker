import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

import java.util.List;

public class DataTest extends TestCase {
    private Data data;
    private List<String> tokens;
    private List<Item> itemList;

    @Before
    public void setUp() throws Exception {
        data = new Data();
        tokens = data.splitIntoTokens(data.readRawDataToString());
        itemList = data.createItemList(tokens);
    }

    public void testCreateItemList(){

        String expected = "Item{name='Milk', price=3.23}";
        String actual = itemList.get(0).toString();

        Assert.assertEquals(expected, actual);
    }

    public void testCreateItemList2(){

        int expected = 28;
        int actual = itemList.size();

        Assert.assertEquals(expected, actual);
    }

    public void testPopulateResults() {

        data.populateResults(itemList);
        System.out.println(data.getResults().size());
        System.out.println(data.toString());
    }
}