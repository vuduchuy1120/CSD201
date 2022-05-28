package data;

import java.io.*;

public class ReaderList {

     NodeReader head, tail;

    public ReaderList() {
        head = tail = null;
    }

    public void clear() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(Reader x) {
        NodeReader q = new NodeReader(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    public void visit(NodeReader p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    public void traverse() {
        NodeReader p = head;
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
        String xName;
        int xByear;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 3) {
                break;
            }
            a = s.split("[|]");
            xBcode = a[0].trim();
            xName = a[1].trim();
            xByear = Integer.parseInt(a[2].trim());
            addLast(new Reader(xBcode, xName, xByear));
        }
        fr.close();
        br.close();
    }

    public void saveFileFR(String fname) throws IOException {
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        NodeReader p = head;
        while (p != null) {
            pw.printf("%10s | %10s | %d\r\n", p.info.rcode, p.info.name, p.info.byear);
            p = p.next;
        }
        pw.close();
        fw.close();
    }

    public NodeReader searchByRcode(String xRcode) {
        NodeReader p = head;
        while (p != null) {
            if (p.info.rcode.equals(xRcode)) {
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

    public void remove(NodeReader p) {
        if (p == null) {
            return;
        }
        if (p == head) {
            removeFirst();
            return;
        }
        NodeReader f = head;
        while (f != null && f.next != p) {
            f = f.next;
        }
        if (f == null) {
            return;
        }
        NodeReader p1 = p.next;
        f.next = p1;
        if (p == tail) {
            tail = f;
        }
    }
}
