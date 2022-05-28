package data;

import java.io.*;

public class LendingList {

    public NodeLending head, tail;

    public LendingList() {
        head = tail = null;
    }

    public void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    public void addLast(Lending x) {
        NodeLending q = new NodeLending(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    public void visit(NodeLending p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    public void traverse() {
        NodeLending p = head;
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
        String xRcode;
        int xState;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 3) {
                break;
            }
            a = s.split("[|]");
            xBcode = a[0].trim();
            xRcode = a[1].trim();
            xState = Integer.parseInt(a[2].trim());
            addLast(new Lending(xBcode, xRcode, xState));
        }
        fr.close();
        br.close();
    }

    public void saveFileFR(String fname) throws IOException {
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        NodeLending p = head;
        while (p != null) {
            pw.printf("%-5s| %-5s| %d\r\n", p.info.bcode, p.info.rcode, p.info.state);
            p = p.next;
        }
        pw.close();
        fw.close();
    }

    public void sortByBcodeAndRcode() {
        NodeLending pi, pj;
        Lending x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.info.bcode.compareTo(pi.info.bcode) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                } else if (pj.info.bcode.compareTo(pi.info.bcode) == 0) {
                    if (pj.info.rcode.compareTo(pi.info.rcode) < 0) {
                        x = pi.info;
                        pi.info = pj.info;
                        pj.info = x;
                    }
                }
            }
        }
    }
}
