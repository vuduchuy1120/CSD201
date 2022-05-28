package data;

public class Book {

    public String bcode;
    public String title;
    public int quantity;
    public int lended;
    public double price;

    public Book() {
    }

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "%-5s| %-24s|%10d|%8d|%7.1f|%7.1f",
                bcode, title, quantity, lended, price, price * quantity
        );

    }
}
