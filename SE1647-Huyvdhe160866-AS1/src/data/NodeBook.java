package data;

public class NodeBook {

    public Book info;
    public NodeBook next;

    public NodeBook(Book x, NodeBook p) {
        info = x;
        next = p;
    }

    public NodeBook(Book x) {
        info = x;
        next = null; 
    }
}
