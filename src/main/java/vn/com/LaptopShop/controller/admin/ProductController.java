package vn.com.LaptopShop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import vn.com.LaptopShop.domain.Product;
import vn.com.LaptopShop.service.ProductService;
import vn.com.LaptopShop.service.UploadFileService;


@Controller
public class ProductController {

    
    private final UploadFileService uploadFileService;

    private final ProductService productService;

    public ProductController(UploadFileService uploadFileService,
    ProductService productService){
        this.uploadFileService = uploadFileService;
        this.productService = productService;
    }



        @GetMapping("/admin/product")
    public String getProduct(Model model){
        List<Product> prs = this.productService.fetchProducts();
        model.addAttribute("products", prs);
        return "admin/dashboard/product";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model){
        model.addAttribute("newProduct", new Product());
        return "admin/dashboard/create";
    }

    @PostMapping("/admin/product/create")
    public String handleCreateProduct(
        @ModelAttribute("newProduct") @Valid Product pr,
        BindingResult newProductBindingResult,
        @RequestParam("laptopShopFile") MultipartFile file
    ){
        if(newProductBindingResult.hasErrors()){
            return "admin/product/create";
        }

        String image = this.uploadFileService.handleSaveUploadFile(file, "product");
        pr.setImage(image);

        this.productService.createProduct(pr);

        return "redirect:/admin/product";
    }

}
