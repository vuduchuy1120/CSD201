
package util;

import data.NodeBook;
import data.BookList;
import data.NodeReader;
import data.ReaderList;
import java.io.IOException;
import java.util.Scanner;

public class Validator {

    public static final Scanner SC = new Scanner(System.in);
    
    public static int getInt(String message,int min, int max) throws NumberFormatException {
        int num;
        while (true) {            
            try {
                num = Integer.parseInt(SC.nextLine());
                if(num < min || num > max) throw new NumberFormatException();
                return num;
            } catch (NumberFormatException e) {
                System.out.print(message);
            }
        }
    }

    public static double getDouble(String message, double min, double max) throws NumberFormatException {
        double num;
        while (true) {            
            try {
                num = Double.parseDouble(SC.nextLine());
                if(num < min || num > max) throw new NumberFormatException();
                return num;
            } catch (NumberFormatException e) {
                System.out.print(message);
            }
        }
    }

    public static String getBcode(String bname) throws IOException {
        BookList bookList = new BookList();
        bookList.clear();
        bookList.loadFileFR(bname);
        String bcode = null;
        boolean k = true;
        while(k == true) {
            bcode = SC.nextLine();
            NodeBook q = bookList.searchByBcode(bcode);
            if (q != null) {
                System.err.println("bCode already exists! Please re-enter: ");
            } else {
                k = false;
            }
        }
        return bcode;
    }
    
    public static String getRcode(String rname) throws IOException {
        ReaderList readerList = new ReaderList();
        readerList.clear();
        readerList.loadFileFR(rname);
        String rcode = null;
        boolean k = true;
        while(k == true) {
            rcode = SC.nextLine();
            NodeReader q = readerList.searchByRcode(rcode);
            if (q != null) {
                System.err.print("rCode already exists! Please re-enter: ");
            } else {
                k = false;
            }
        }
        return rcode;
    }
    
    public static String getLBcode(String bname) throws IOException {
        BookList bookList = new BookList();
        bookList.clear();
        bookList.loadFileFR(bname);
        String bcode = null;
        boolean k = true;
        while(k == true) {
            bcode = SC.nextLine();
            NodeBook q = bookList.searchByBcode(bcode);
            if (q != null) {
                k = false;
            } else {
                System.err.println("bcode does not exist! Please re-enter: ");
            }
        }
        return bcode;
    }
    
    public static String getLRcode(String rname) throws IOException {
        ReaderList readerList = new ReaderList();
        readerList.clear();
        readerList.loadFileFR(rname);
        String rcode = null;
        boolean flag = false;
        while(flag == false) {
            rcode = SC.nextLine();
            NodeReader q = readerList.searchByRcode(rcode);
            if (q != null) {
                flag = true;
            } else {
                System.err.println("rcode does not exist! Please re-enter: ");
            }
        }
        return rcode;
    }
    
    

}
