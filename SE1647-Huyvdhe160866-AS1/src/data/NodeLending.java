package data;

public class NodeLending {

    public Lending info;
    public NodeLending next;

    NodeLending(Lending x, NodeLending p) {
        info = x;
        next = p;
    }

    NodeLending(Lending x) {
        info = x;
        next = null; 
    }
}
