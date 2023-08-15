import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

import java.util.List;

public class DataTest extends TestCase {
    private Data data;
    private List<String> tokens;

    @Before
    public void setUp() throws Exception {
        data = new Data();
        tokens = data.splitIntoTokens(data.readRawDataToString());
    }

    public void testCreateItemList(){

        List<Item> itemList= data.createItemList(tokens);

        String expected = "Item{name='Milk', price=3.23}";
        String actual = itemList.get(0).toString();

        Assert.assertEquals(expected, actual);
    }

    public void testCreateItemList2(){
        List<Item> itemList = data.createItemList(tokens);
        int expected = 28;
        int actual = itemList.size();

        Assert.assertEquals(expected, actual);
    }

    public void testIncrementItemCount() {
    }
}