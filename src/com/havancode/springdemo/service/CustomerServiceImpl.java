package com.havancode.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.havancode.springdemo.dao.CustomerDAO;
import com.havancode.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	// Inject Customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer newCustomer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(newCustomer);
	}
	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(id);
	}
	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(id);
	}
	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		// TODO Auto-generated method stub
		return customerDAO.searchCustomers(theSearchName);
	}

}
