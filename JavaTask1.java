package com.OasisInfobyte;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Reservation {
    private String name, train_name, class_type, source_place, destination_place, date;
    private int age, train_no;

    Scanner sc = new Scanner(System.in);

    public void getName() {
        System.out.println("Enter your name");
        name = sc.nextLine().trim();
    }

    public String getNameValue() {
        return name;
    }

    public void getAge() {
        System.out.println("Enter your age");
        age = sc.nextInt();

    }

    public void getTrain_no() {
        System.out.println("Enter 5-digit train number");
        train_no = sc.nextInt();
    }

    public void getTrain_name() {
        System.out.println("Enter train name");
        train_name = sc.next();
    }

    public void getClass_type() {
        System.out.println("Enter seat class type");
        class_type = sc.next();
    }

    public void getSource_place() {
        System.out.println("Enter source place");
        source_place = sc.next();
    }

    public void getDestination_place() {
        System.out.println("Enter destination place");
        destination_place = sc.next();
    }

    public void getDate() throws ParseException {
        System.out.println("Enter date in dd--MM--yyyy format");
        date = sc.next();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Reservation other = (Reservation) obj;
        return name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nTrain name: " + train_name +
                "\nTrain No: " + train_no +
                "\nClass type: " + class_type +
                "\nDate of journey: " + date +
                "\nFrom: " + source_place +
                "\nTo: " + destination_place;
    }
}

public class JavaTask1 {
    private static final ArrayList<Reservation> reservations = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    private static boolean validateLogin() {
        Scanner loginScanner = new Scanner(System.in);

        System.out.println("Enter Login ID:");
        String loginId = loginScanner.nextLine().trim();

        System.out.println("Enter Password:");
        String password = loginScanner.nextLine().trim();

        boolean isValidLogin = loginId.equals("admin") && password.equals("password");

        if (!isValidLogin) {
            System.out.println("Invalid Login ID or Password. Please try again.");
        }

        return isValidLogin;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println("********** Welcome to Online Reservation System **********");

        if (!validateLogin()) {
            System.out.println("Exiting. Authentication failed.");
            System.exit(0);
        }
        while (true) {
            displayMenuOptions();

            int num = sc.nextInt();

            switch (num) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    viewReservation();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    System.out.println("Visit again... Thank you");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMenuOptions() {
        System.out.println("Select any one option ");
        System.out.println("1. Make reservation");
        System.out.println("2. View reservation");
        System.out.println("3. Cancel reservation");
        System.out.println("4. Exit");
    }

    private static void makeReservation() throws ParseException {
        Reservation r = new Reservation();
        getReservationDetails(r);
        reservations.add(r);
        System.out.println("Booking confirmed");
    }

    private static void getReservationDetails(Reservation r) throws ParseException {
        r.getName();
        r.getAge();
        r.getTrain_no();
        r.getTrain_name();
        r.getClass_type();
        r.getSource_place();
        r.getDestination_place();
        r.getDate();
    }

    private static void viewReservation() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations available.");
        } else {
            System.out.println("Your reservation details are : ");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    private static void cancelReservation() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations available for cancellation.");
        } else {
            System.out.println("Enter name for cancellation:");
            sc.nextLine();  // Consume the newline character left by previous input

            String nameToCancel = sc.nextLine().trim();

            boolean found = false;
            Iterator<Reservation> iterator = reservations.iterator();
            while (iterator.hasNext()) {
                Reservation reservation = iterator.next();
                if (reservation.getNameValue().equalsIgnoreCase(nameToCancel)) {
                    iterator.remove();
                    found = true;
                    System.out.println("Cancellation successful");
                    break;
                }
            }

            if (!found) {
                System.out.println("No reservation found for the given name");
            }
        }
    }
}
