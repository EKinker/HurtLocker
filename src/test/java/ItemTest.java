import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    @Test
    public void getName() {
        String input = "NAMe:mIlK;price:2.0;type:Food;expiration:1/25/2016";
        Item item = new Item(input);

        String expected = "Milk";
        String actual = item.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPrice() {
    }


}