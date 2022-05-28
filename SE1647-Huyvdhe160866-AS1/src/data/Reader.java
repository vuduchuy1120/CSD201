
package data;

public class Reader {
    public String rcode;
    public String name;
    public int byear;

    public Reader() {
    }

    public Reader(String rcode, String name, int byear) {
        this.rcode = rcode;
        this.name = name;
        this.byear = byear;
    }

    @Override
    public String toString() {
        return String.format(
                  "%-5s| %-24s| %5d|",
                 rcode, name , byear
        );
    }
    
    
}
