package controller;

import service.customer.CustomerService;

import java.sql.SQLException;

public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void getAvailableSpaces() throws SQLException {
        customerService.getAvailableSpaces();
    }

    public void makeReservation(int id) throws SQLException{
        customerService.makeReservation(id);
    }
    public void ownReservations() throws SQLException{
        customerService.ownReservations();
    }
    public void cancelReservation(int id) throws SQLException{
        customerService.cancelReservation(id);
    }
}
