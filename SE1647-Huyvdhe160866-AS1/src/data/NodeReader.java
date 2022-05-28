package data;

public class NodeReader {

    public Reader info;
    public NodeReader next;

    public NodeReader(Reader x, NodeReader p) {
        info = x;
        next = p;
    }

    public NodeReader(Reader x) {
        info = x;
        next = null;
    }
}
