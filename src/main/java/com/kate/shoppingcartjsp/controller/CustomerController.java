package com.kate.shoppingcartjsp.controller;

import com.kate.shoppingcartjsp.dto.CustomerDTO;
import com.kate.shoppingcartjsp.facade.CustomerFacade;
import com.kate.shoppingcartjsp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import static com.kate.shoppingcartjsp.converter.CustomerConverter.convertToCustomer;

@Controller
@RequestMapping
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerFacade customerFacade;

    @GetMapping("/registration")
    public String createCustomer(Map<String, Object> model) {

        model.put("customerDTO", new CustomerDTO());

        return "СustomerRegistration";
    }

    @PostMapping("/home")
    public String createCustomer(@ModelAttribute("customerDto") CustomerDTO customerDTO) {
        customerFacade.createOrUpdateCustomer(convertToCustomer(customerDTO));
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listOfCustomer(Model model) {
        List<CustomerDTO> customerList = customerFacade.getAllCustomers();
        model.addAttribute("customerList", customerList);
        return "customerList";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("id") String id) {
        customerService.deleteCustomer(Long.parseLong(id));
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String editCustomer(@RequestParam("id") String id, Map<String, Object> model) {
        CustomerDTO customerDTO = customerFacade.editCustomer(Long.parseLong(id));
        model.put("customerDTO", customerDTO);
        return "СustomerRegistration";
    }
}
