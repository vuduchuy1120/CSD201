package ui;

import data.Reader;
import data.NodeBook;
import data.BookList;
import data.Lending;
import data.NodeReader;
import data.ReaderList;
import data.Book;
import data.LendingList;
import java.io.IOException;
import java.util.Scanner;
import static util.Validator.*;

public class Gui {

    Scanner sc = new Scanner(System.in);

    public void display() throws IOException {
        BookList bookList = new BookList();
        ReaderList readerList = new ReaderList();
        LendingList lendingList = new LendingList();
        Menu menu = new Menu();
        String bname = "book.txt";
        String rname = "reader.txt";
        String lname = "lending.txt";

        int choice = -1, choice1, choice2, choice3;

        String bcode;
        String title;
        int quantity;
        int lended;
        double price;
        Book b;

        int position;
        NodeBook q;

        String rcode;
        String name;
        int byear;
        Reader r;
        NodeReader p;

        int state;
        Lending l;
        while (choice != 0) {
            menu.menuTong();
            choice = getInt("Enter choice from 0 to 3! Re-enter: ", 0, 3);
            switch (choice) {
                case 1:
                    choice1 = Integer.MAX_VALUE;
                    while (choice1 != 0) {
                        menu.menu1();
                        choice1 = getInt("Enter choice from 0 to 10! Re-enter: ", 0, 10);
                        switch (choice1) {
                            case 1:
                                bookList.loadFileFR(bname);
                                System.out.println("Load file successful!");
                                break;
                            case 2:
                                System.out.println("\n");
                                System.out.println("\t\t--------Add a book to the end of the list--------");
                                System.out.print("Enter code of book: ");
                                bcode = getBcode(bname);
                                System.out.print("Enter title of book: ");
                                title = sc.nextLine();
                                System.out.print("Enter quantities of book: ");
                                quantity = getInt("number of books must be > 0!Re-enter: ", 1, Integer.MAX_VALUE);
                                lended = 0;
                                System.out.print("Enter price of book: ");
                                price = getDouble("number of books must be >= 0!Re-enter: ", 0, Double.MAX_VALUE);
                                b = new Book(bcode, title, quantity, lended, price);
                                bookList.addLast(b);
                                System.out.println("Add a book to the end of the list successful!");
                                break;

                            case 3:
                                System.out.println("\n");
                                System.out.println("--------------------------List of Book--------------------------------");
                                System.out.printf("%-5s|%-25s|%-10s|%-8s|%-7s|%-8s\n",
                                        "Code", "          Title", " Quantity", "Lended", "Price", "Value"
                                );
                                System.out.println("----------------------------------------------------------------------");
                                bookList.traverse();
                                break;
                            case 4:
                                bookList.saveFileFR(bname);
                                System.out.println("Save to file successful");
                                break;
                            case 5:
                                System.out.println("\n");
                                System.out.print("Enter the code of book you want to find: ");
                                q = bookList.searchByBcode(sc.nextLine());
                                if (q == null) {
                                    System.out.println("Not found !!");
                                } else {
                                    System.out.println("The Book found is");
                                    System.out.printf("%-5s|%-25s|%-10s|%-8s|%-7s|%-8s\n",
                                            "Code", "          Title", " Quantity", "Lended", "Price", "Value"
                                    );
                                    System.out.println("----------------------------------------------------------------------");
                                    bookList.visit(q);
                                    System.out.println();
                                }
                                break;

                            case 6:
                                System.out.println("\n");
                                System.out.println("\t\t--------Delete a book by bcode--------");
                                System.out.print("Enter code of book you want to delete: ");
                                q = bookList.searchByBcode(sc.nextLine());
                                if(q == null){
                                    System.out.println("\nNot found book to delete!");
                                    break;
                                }
                                bookList.remove(q);
                                System.out.println("Delete a book successful!");
                                break;

                            case 7:
                                System.out.println("\n");
                                System.out.println("\t\t--------Sorted BookList by code--------");
                                System.out.printf("%-5s|%-25s|%-10s|%-8s|%-7s|%-8s\n",
                                        "Code", "          Title", " Quantity", "Lended", "Price", "Value"
                                );
                                System.out.println("----------------------------------------------------------------------");
                                bookList.sortByBcode();
                                bookList.traverse();
                                break;

                            case 8:
                                System.out.println("\n");
                                System.out.println("\t\t--------Add a book to the begin of the list--------");
                                System.out.print("Enter code of book: ");
                                bcode = getBcode(bname);
                                System.out.print("Enter title of book: ");
                                title = sc.nextLine();
                                System.out.print("Enter quantities of book: ");
                                quantity = getInt("number of books must be > 0!Re-enter: ", 1, Integer.MAX_VALUE);
                                lended = 0;
                                System.out.print("Enter price of book: ");
                                price = getDouble("number of books must be greater than 0. Re-enter:  ", 0, Double.MAX_VALUE);
                                b = new Book(bcode, title, quantity, lended, price);
                                bookList.addFirst(b);
                                System.out.println("Add a book to the begin of the list successful!");
                                break;

                            case 9:
                                System.out.println("\n");
                                System.out.println("\t\t--------Add a book after position which you enter--------");
                                System.out.print("Enter position of book you want to add after: ");
                                position = getInt("number of books must be > 0!Re-enter: ", 0, Integer.MAX_VALUE);
                                System.out.print("Enter code of book: ");
                                bcode = getBcode(bname);
                                System.out.print("Enter title of book: ");
                                title = sc.nextLine();
                                System.out.print("Enter quantities of book: ");
                                quantity = getInt("number of books must be > 0!Re-enter: ", 1, Integer.MAX_VALUE);
                                lended = 0;
                                System.out.print("Enter price of book: ");
                                price = getDouble("number of books must be greater than 0. Re-enter:  ", 0, Double.MAX_VALUE);
                                b = new Book(bcode, title, quantity, lended, price);
                                bookList.insertAfter(position, b);
                                System.out.println("Add a book after position successful!");
                                break;

                            case 10:
                                System.out.println("\n");
                                System.out.println("\t\t--------Delete a book where you entered--------");
                                System.out.print("Enter position of book you want to delete: ");
                                position = getInt("Number of books must be > 0!Re-enter: ", 0, Integer.MAX_VALUE);
                                bookList.removePos(position);
                                System.out.println("Remove a book at position " + position + " successful!");
                                break;

                            case 0:
                                break;
                        }
                    }
                    break;
                case 2:
                    choice2 = -1;
                    while (choice2 != 0) {
                        menu.menu2();
                        choice2 = getInt("Please enter your choice from 0 to 4. Re-enter: ", 0, 6);
                        switch (choice2) {
                            case 1:
                                readerList.loadFileFR(rname);
                                System.out.println("\nLoad file successful!");
                                break;
                            case 2:
                                System.out.println("\n");
                                System.out.println("--------Add a reader to the end of the list--------");
                                System.out.print("Enter the code of Reader: ");
                                rcode = getRcode(rname);
                                System.out.print("Enter the name of Reader: ");
                                name = sc.nextLine();
                                System.out.print("Enter the byear of Reader: ");
                                byear = getInt("byear must be from 1900 to 2010.  Re-enter:  ", 1900, 2010);
                                r = new Reader(rcode, name, byear);
                                readerList.addLast(r);
                                System.out.println("\nAdd a reader to the end of the list successful!");
                                break;
                            case 3:
                                System.out.println("\n");
                                System.out.println("--------------------List of Reader-----------------");
                                System.out.printf("%-5s|%-25s| %-8s\n",
                                        "Code", "          Name", "byear"
                                );
                                System.out.println("---------------------------------------------------");
                                readerList.traverse();
                                break;
                            case 4:
                                readerList.saveFileFR(rname);
                                System.out.println("\nSave file successful!");
                                break;
                            case 5:
                                System.out.println("\n");
                                System.out.print("Enter the code of reader you want to find: ");
                                p = readerList.searchByRcode(sc.nextLine());
                                if (p == null) {
                                    System.out.println("\nNot found");
                                } else {
                                    System.out.println("\nThe Reader found is");
                                    System.out.printf("%-5s|%-25s|%-8s\n",
                                            "Code", "          Name", "byear"
                                    );
                                    System.out.println("-------------------------------------------------------");
                                    readerList.visit(p);
                                    System.out.println();
                                }
                                break;

                            case 6:
                                System.out.println("\n");
                                System.out.println("\t\t--------Delete a Reader by rcode--------");
                                System.out.print("Enter code of book you want to delete: ");
                                p = readerList.searchByRcode(sc.nextLine());
                                if(p == null){
                                    System.out.println("\nNot found reader to delete!");
                                    break;
                                }
                                readerList.remove(p);
                                System.out.println("\nDelete a reader successful!");
                                break;

                            case 0:
                                break;
                        }
                    }
                    break;
                case 3:
                    choice3 = -1;
                    while (choice3 != 0) {
                        menu.menu3();
                        choice3 = getInt("Please enter your choice from 1 to 3. Re-enter: ", 0, 3);
                        switch (choice3) {
                            case 1:
                                System.out.println("\n");
                                System.out.println("\t\t--------Add a LENDING to the the list--------");
                                lendingList.clear();
                                lendingList.loadFileFR(lname);
                                boolean flag = true;
                                while (flag) {
                                    System.out.print("Enter the BOOK CODE: ");
                                    bcode = sc.nextLine().trim();
                                    System.out.print("Enter the READER CODE: ");
                                    rcode = sc.nextLine().trim();
                                    bookList.loadFileFR(bname);
                                    readerList.loadFileFR(rname);
                                    NodeBook checkbcode = bookList.searchByBcode(bcode);
                                    NodeReader checkrcode = readerList.searchByRcode(rcode);
                                    if (checkbcode == null || checkrcode == null) {
                                        System.out.println("Data is not valid. Re-enter!");
                                    } else if (checkbcode != null && checkrcode != null) {
                                        if (checkbcode.info.lended < checkbcode.info.quantity) {
                                            checkbcode.info.lended += 1;
                                            state = 1;
                                            System.out.print("Enter the state : 1\n");
                                            l = new Lending(bcode, rcode, state);
                                            lendingList.addLast(l);
                                            System.out.println("Add lending successful!");
                                            lendingList.saveFileFR(lname);
                                            flag = false;
                                        } else if (checkbcode.info.lended == checkbcode.info.quantity) {
                                            state = 0;
                                            System.out.print("Enter the state : 0");
                                            l = new Lending(bcode, rcode, state);
                                            lendingList.addLast(l);
                                            System.out.println("Add lending successful!");
                                            lendingList.saveFileFR(lname);
                                            flag = false;
                                        } else {
                                            System.out.println("Enter the state : ");
                                            state = getInt("Please enter from 0 to 2. Re-enter: ", 0, 2);
                                            if (state == 1) {
                                                System.out.println("Data is not valid. Re-enter!");
                                            } else {
                                                l = new Lending(bcode, rcode, state);
                                                lendingList.addLast(l);
                                                System.out.println("Add lending successful!");
                                                lendingList.saveFileFR(lname);
                                                flag = false;
                                            }
                                        }
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("\n");
                                lendingList.clear();
                                lendingList.loadFileFR(lname);
                                System.out.println("--------------------List of Lending-----------------");
                                System.out.printf("%-10s|%-10s|%-8s\n",
                                        "bCode", "rCode", "State"
                                );
                                System.out.println("---------------------------------------------------");
                                lendingList.traverse();
                                break;
                            case 3:
                                System.out.println("\n");
                                System.out.println("\n");
                                lendingList.clear();
                                lendingList.loadFileFR(lname);
                                System.out.println("--------------------List of Lending-----------------");
                                System.out.printf("%-10s|%-10s|%-8s\n",
                                        "bCode", "rCode", "State"
                                );
                                System.out.println("---------------------------------------------------");
                                lendingList.sortByBcodeAndRcode();
                                lendingList.traverse();
                                break;
                            case 0:
                                break;
                        }
                    }
                    break;
                case 0:
                    break;
            }
        }
    }

}
