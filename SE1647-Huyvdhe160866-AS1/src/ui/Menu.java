/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author ASUS
 */
public class Menu {

    public void menuTong() {
        System.out.println("\n");
        System.out.println("\t\t--------Library Management System--------");
        System.out.println("1. Book List");
        System.out.println("2. Reader List");
        System.out.println("3. Lending List");
        System.out.println("0. Quit");
        System.out.print("Enter your choice: ");
    }

    public void menu1() {
        System.out.println("\n");
        System.out.println("\t\t--------Book Management System--------");
        System.out.println("1.  Load data from file");
        System.out.println("2.  Input & add to the end");
        System.out.println("3.  Display data");
        System.out.println("4.  Save to file!");
        System.out.println("5.  Search by bcode");
        System.out.println("6.  Delete by bcode");
        System.out.println("7.  Sort by bcode");
        System.out.println("8.  Input & add to beginning");
        System.out.println("9.  Add after position  k");
        System.out.println("10.  Delete position k");
        System.out.println("0.  Back to Library Management System");
        System.out.print("Enter your choice: ");
    }

    public void menu2() {
        System.out.println("\n");
        System.out.println("\t\t--------Reader Management System--------");
        System.out.println("1. Load data from file");
        System.out.println("2. Input & add to the end");
        System.out.println("3. Display data");
        System.out.println("4. Save reader list to file");
        System.out.println("5. Search by rcode");
        System.out.println("6. Delete by rcode");
        System.out.println("0. Back to Library Management System");
        System.out.print("Enter your choice: ");
    }

    public void menu3() {
        System.out.println("\n");
        System.out.println("\t\t--------Lending Management System--------");
        System.out.println("1. Input data");
        System.out.println("2. Display data");
        System.out.println("3. Sort  by bcode + rcode");
        System.out.println("0. Back to Library Management System");
        System.out.print("Enter your choice: ");
    }
}
