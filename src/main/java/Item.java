import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item {

    private final String name;
    private final double price;
    private final String type;
    private final String expiration;
    private final boolean isValid;  //I don't think I'll need this

    public Item(String input) {
        String regex = "[Nn]\\w{3}:(\\w*)\\S[Pp]\\w{4}:(\\d+.?\\d+)?\\S\\w+:(\\w+)\\S\\w+:(.*$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            if (!matcher.group(1).isEmpty() && matcher.group(2) != null) {
                name = capitalize(replaceZeroes(matcher.group(1)));
                price = Double.parseDouble((matcher.group(2)));
                type = matcher.group(3);
                expiration = matcher.group(4);
                isValid = true;
            } else {
                name = null;
                price = 0;
                type = null;
                expiration = null;
                isValid = false;
            }

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

    public String capitalize(String input) {

        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public String replaceZeroes(String input) {
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                charArray[i] = 'o';
            }
        }
        return new String(charArray);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
