package com.kate.shoppingcartjsp.controller;

import com.kate.shoppingcartjsp.dto.ProductDTO;
import com.kate.shoppingcartjsp.service.ProductService;
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

import static com.kate.shoppingcartjsp.converter.ProductConverter.convertToProduct;

@Controller
public class ProductController {

    @Autowired private ProductService productService;

    @GetMapping("api/product/registration")
    public String createProduct(Map<String, Object> model) {
        model.put("productDTO", new ProductDTO());
        return "prodRegistration";
    }

    @PostMapping("api/product/home")
    public String createProduct(@ModelAttribute("productDto") ProductDTO productDTO) {
        productService.createProduct(convertToProduct(productDTO));
        return "redirect:api/product/list";
    }

    @GetMapping("api/product/list")
    public String listOfProduct(Model model) {
        List<ProductDTO> productList = productService.getAll();
        model.addAttribute("ProductList", productList);
        return "productList";
    }

    @PostMapping("api/product/delete")
    public String deleteProduct(@RequestParam("id") String id) {
        productService.deleteById(Long.parseLong(id));
        return "redirect:api/product/list";
    }

    @GetMapping("api/product/edit")
    public String editProduct(@RequestParam("id") String id, Map<String, Object> model) {
        ProductDTO productDTO = productService.editProduct(Long.parseLong(id));
        model.put("productDTO", productDTO);
        return "prodRegistration";
    }

}
