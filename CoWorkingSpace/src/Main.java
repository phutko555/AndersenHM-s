import controller.AdminController;
import controller.CustomerController;
import model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AdminController ad = (AdminController) applicationContext.getBean("adminController");
        System.out.println("Welcome to The Coworking Space Reservation Application !");
        Scanner sc = new Scanner(System.in);
        String menu = getMenu();
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
                            System.out.println("Enter WorkSpace attributes: ex:(\" Giorgi 20.5 true \") separated by spaces:");
                            String attributes = sc.nextLine();
                            if (attributes.trim().isEmpty()) {
                                System.out.println("Attributes is empty, please input values ");
                            } else {
                                String[] split = attributes.split("\\s+");
                                if (split.length == 3) {
                                    String name = split[0];
                                    double price = Double.parseDouble(split[1]);
                                    boolean available = Boolean.parseBoolean(split[2]);
                                    System.out.println("^----------------------------------------------------------^");
                                    ad.addWorkSpace(new WorkSpacesE(name, price, available));
                                } else {
                                    System.out.println("Invalid input form. please provide 3 attributes");
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
                                ad.removeWorkspace(parseInput);
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
                    CustomerController customer = (CustomerController) applicationContext.getBean("customerController");
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
