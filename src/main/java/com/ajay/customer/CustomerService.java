package com.ajay.customer;

import com.ajay.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomers(Integer id) {
        return customerDao.selectCustomersById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer with id [%s] not found".formatted(id)));
    }
}
