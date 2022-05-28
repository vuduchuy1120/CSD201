package data;

import java.io.*;

public class BookList {

    NodeBook head, tail;

    public BookList() {
        head = tail = null;
    }

    public void clear() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addFirst(Book x){
        NodeBook p = new NodeBook(x, head);
        head = p;
        if (tail == null) {
            tail = head;
        }
    }
    public void addLast(Book x) {
        NodeBook q = new NodeBook(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    public void visit(NodeBook p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    public void traverse() {
        NodeBook p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
    }

    public void loadFileFR(String fname) throws IOException { 
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] a;
        String xBcode;
        String xTitle;
        int xQuantity;
        int xLended;
        double xPrice;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 3) {
                break;
            }
            a = s.split("[|]");
            xBcode = a[0].trim();
            xTitle = a[1].trim();
            xQuantity = Integer.parseInt(a[2].trim());
            xLended = Integer.parseInt(a[3].trim());
            xPrice = Double.parseDouble(a[4].trim());
            addLast(new Book(xBcode, xTitle, xQuantity, xLended, xPrice));
        }
        fr.close();
        br.close();
    }

    public void saveFileFR(String fname) throws IOException { 
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        NodeBook p = head;
        while (p != null) {
            pw.printf("%10s | %10s| %3d | %3d | %.1f\r\n",
                    p.info.bcode, p.info.title, p.info.quantity, p.info.lended, p.info.price
            );
            p = p.next;
        }
        pw.close();
        fw.close();
    }

    public NodeBook searchByBcode(String xBcode) {
        NodeBook p = head;
        while (p != null) {
            if (p.info.bcode.equalsIgnoreCase(xBcode)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    public void remove(NodeBook q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        NodeBook f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;
        }
        NodeBook q1 = q.next;
        f.next = q1;
        if (q == tail) {
            tail = f;
        }
    }

    public void sortByBcode() {
        NodeBook pi, pj;
        Book x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.info.bcode.compareTo(pi.info.bcode) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }

    NodeBook pos(int k) {
        int i = 0;
        NodeBook p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            p = p.next;
            i++;
        }
        return (null);
    }

    public void insertAfter(int k, Book x) {
        NodeBook n = new NodeBook(x);
        NodeBook q = pos(k);
        if (q == null) {
            System.err.println("No Node at position "+ k +" to add after!");
            return;
        }
        n.next = q.next;
        q.next = n;
        if (q == tail) {
            tail = n;
        }
    }

    public void removePos(int k) {
        NodeBook q = pos(k);
        if(q == null){
            System.err.println("Not found book to delete!");
            return;
        }
        remove(q);
    }
}
