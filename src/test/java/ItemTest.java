import org.junit.Test;

public class ItemTest {

    @Test
    public void getName() {
        String input = "NAMe:egggg;price:2.0;type:Food;expiration:1/25/2016";
        Item item = new Item(input);

        System.out.println(item.getName());
        System.out.println(item.getPrice());
        System.out.println(item.getExpiration());
        System.out.println(item.getType());
    }

    @Test
    public void getPrice() {
    }


}