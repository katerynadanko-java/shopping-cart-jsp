package com.kate.shoppingcartjsp.controller;

import com.kate.shoppingcartjsp.dto.ProductDTO;
import com.kate.shoppingcartjsp.facade.ProductFacade;
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
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductFacade productFacade;

    @GetMapping("/registration")
    public String createProduct(Map<String, Object> model) {
        model.put("productDTO", new ProductDTO());
        return "prodRegistration";
    }

    @PostMapping("/home")
    public String createProduct(@ModelAttribute("productDto") ProductDTO productDTO) {
        productFacade.createProduct(convertToProduct(productDTO));
        return "redirect:api/product/list";
    }

    @GetMapping("/list")
    public String listOfProduct(Model model) {
        List<ProductDTO> productList = productFacade.getAll();
        model.addAttribute("ProductList", productList);
        return "productList";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("id") String id) {
        productService.deleteById(Long.parseLong(id));
        return "redirect:api/product/list";
    }

    @GetMapping("/edit")
    public String editProduct(@RequestParam("id") String id, Map<String, Object> model) {
        ProductDTO productDTO = productFacade.editProduct(Long.parseLong(id));
        model.put("productDTO", productDTO);
        return "prodRegistration";
    }

}
