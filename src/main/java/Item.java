import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item {

    private String name;
    private double price;
    private String type;
    private String expiration;
    private boolean isValid;  //I don't think I'll need this

    public Item(String input) {
        String regex = "[Nn]\\w{3}:(\\w*)\\S[Pp]\\w{4}:(\\d+.?\\d+)?\\S\\w+:(\\w+)\\S\\w+:(.*$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            if (!matcher.group(1).isEmpty()&&matcher.group(2)!=null){
            name = capitalize(matcher.group(1));
            price = Double.parseDouble((matcher.group(2)));
            type = matcher.group(3);
            expiration = matcher.group(4);
            isValid = true;
            }
            else {
                name = null;
                price = 0;
                type = null;
                expiration =null;
                isValid = false;}

        } else {
            throw new IllegalArgumentException("Oh no!");
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }

    public String capitalize(String input){

        return input.substring(0,1).toUpperCase()+input.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
