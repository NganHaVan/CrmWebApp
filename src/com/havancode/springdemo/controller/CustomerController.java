package com.havancode.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.havancode.springdemo.entity.Customer;
import com.havancode.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// Inject Customer Service
	@Autowired
	private CustomerService customerService;

	// @Autowired scan the components that implement customerDAO interface

	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		// Get customers from Service
		List<Customer> customers = customerService.getCustomers();
		// Add the customers to the model
		theModel.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// Create model attributes to bind form data
		Customer newCustomer = new Customer();
		theModel.addAttribute("customer", newCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	// @ModelAttribute is the modelAttribute attribute in the form tag
	public String saveCustomer(@ModelAttribute("customer") Customer newCustomer) {
		// Save customer in Service
		customerService.saveCustomer(newCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		// Get the customer from the database
		Customer updatedCustomer = customerService.getCustomer(id);
		// Set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", updatedCustomer);
		// Send over the form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";        
    }
}
