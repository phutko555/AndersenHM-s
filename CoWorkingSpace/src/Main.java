import dao.workspace.WorkSpaceDAO;
import dao.workspace.WorkSpaceDAOImpl;
import dao.reservations.ReservationsDAO;
import dao.reservations.ReservationsDAOImpl;
import model.WorkSpaces;
import service.workspace.WorkSpaceService;
import service.reservation.ReservationsService;

import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static String getMenu() {
        Scanner sc = new Scanner(System.in);
        String menu;
        while (true) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Options:\n1. Admin Login\n2. User Login\n3. Exit");
            System.out.print("Please, choose one of them (1, 2, 3): ");
            menu = sc.nextLine();
            if (menu.equals("1") || menu.equals("2") || menu.equals("3")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
            }
        }
        return menu;
    }
    public static void main(String[] args) throws SQLException {
        String directory = "/Users/giorgi/AndersenHM-s/CoWorkingSpace/classes";
        try {
            CustomClassLoader loader = new CustomClassLoader(directory);
            Class<?> clazz = loader.loadClass("Admin");

            Object adminInstance = clazz.getDeclaredConstructor().newInstance();
            System.out.println("Successfully loaded Admin class: " + adminInstance);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Welcome to The Coworking Space Reservation Application !");
        Scanner sc = new Scanner(System.in);
        String menu = getMenu();
        WorkSpaceDAO workSpaceDAO = new WorkSpaceDAOImpl();
        WorkSpaceService workSpaceService = new WorkSpaceService(workSpaceDAO);
        Admin ad = new Admin(workSpaceService);
        while (!menu.equals("3")) {
            switch (menu) {
                case "1":
                    while (true) {
                        String admOption = ("""
                                Admin Menu:
                                1. Add a new coworking space
                                2. Remove a \
                                coworking space
                                3. View all reservations
                                4. Return to the main Page""");
                        System.out.println("---------------------------------------------------------");
                        System.out.println(admOption);
                        System.out.print("Please, choose one of them (1, 2, 3, 4): ");
                        String adminOptionSc = sc.nextLine();
                        if (adminOptionSc.equals("1")) {
                            System.out.println("---------------------------------------------------------");
                            System.out.println("Enter WorkSpace attributes: ex:(\" 1 Giorgi 20.5 true \") separated by spaces:");
                            String attributes = sc.nextLine();
                            if (attributes.trim().isEmpty()) {
                                System.out.println("Attributes is empty, please input values ");
                            } else {
                                String[] split = attributes.split("\\s+");
                                if (split.length == 4) {
                                    int coId = Integer.parseInt(split[0]);
                                    String name = split[1];
                                    double price = Double.parseDouble(split[2]);
                                    boolean available = Boolean.parseBoolean(split[3]);
                                    System.out.println("^----------------------------------------------------------^");
                                    ad.addWorkSpace(new WorkSpaces(coId, name, price, available));
                                } else {
                                    System.out.println("Invalid input form. please provide 4 attributes");
                                }
                            }
                        } else if (adminOptionSc.equals("3")) {
                            System.out.println("^----------------------------------------------------------^");
                            ad.viewAllReservations();
                        } else if (adminOptionSc.equals("2")) {
                            System.out.println("----------------------------------------------------------");
                            System.out.print("Please choose ID which you want to delete: ");
                            try {
                                String input = sc.nextLine();
                                int parseInput = Integer.parseInt(input); // parse to clear input buffer
                                ad.removeWorkSpace(parseInput);
                            } catch (NumberFormatException e) {
                                System.out.println("Please, Enter number ");
                            }
                        } else if (adminOptionSc.equals("4")) {
                            menu = getMenu();
                            break;
                        } else {
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Please enter valid input (1, 2, 3, 4)");
                        }
                    }
                    break;
                case "2":
                    ReservationsDAO reservationsDAO = new ReservationsDAOImpl();
                    ReservationsService reservationsService = new ReservationsService(reservationsDAO);
                    Customer customer = new Customer(reservationsService);
                    while (true) {
                        String custOption = ("""
                                Customer Menu:
                                1. Browse available spaces
                                2. Make a \
                                reservation
                                3. View my reservations
                                4. Cancel a reservation\s
                                5 Return to the main Page""");
                        System.out.println("---------------------------------------------------------");
                        System.out.println(custOption);
                        System.out.print("Please, choose one of them (1, 2, 3, 4, 5): ");
                        String custOptionSc = sc.nextLine();
                        if (custOptionSc.equals("1")) {
                            customer.getAvailableSpaces();
                        } else if (custOptionSc.equals("5")) {
                            menu = getMenu();
                            break;
                        } else if (custOptionSc.equals("2")) {
                            System.out.println("---------------------------------------------------------");
                            System.out.println("Please enter the ID which you want to reserve");
                            try {
                                String input = sc.nextLine();
                                int parseInput = Integer.parseInt(input); // parse to clear input buffer
                                customer.makeReservation(parseInput);
                            } catch (NumberFormatException e) {
                                System.out.println("Please, Enter number ");
                            }
                        } else if (custOptionSc.equals("3")) {
                            System.out.println("---------------------------------------------------------");
                            customer.ownReservations();
                            } else if (custOptionSc.equals("4")) {
                                System.out.println("---------------------------------------------------------");
                                System.out.println("Please enter the ID which you want to cancel");
                                try {
                                    String input = sc.nextLine();
                                    int parseInput = Integer.parseInt(input); // parse to clear input buffer
                                    customer.cancelReservation(parseInput);
                                } catch (NumberFormatException e) {
                                    System.out.println("Please, Enter number ");
                                }
                        } else {
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Please enter valid input (1, 2, 3, 4, 5)");
                        }
                    }
                    break;
            }
        }
    }
}