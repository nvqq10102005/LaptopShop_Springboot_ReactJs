package vn.com.LaptopShop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/admin/product/delete/{id}")
    public String getPageDeleteProduct(Model model,@PathVariable long id){
        model.addAttribute("id", id);
        model.addAttribute("newProduct", new Product());

        return "admin/dashboard/delete-product";
    }

    @PostMapping("/admin/product/delete")
    public String postDeleteProduct(Model model,@ModelAttribute("newProduct") Product pr){
        this.productService.deleteProduct(pr.getId());
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/detail/{id}")
    public String getProductDetailPage(Model model, @PathVariable long id){
        Product product = this.productService.getProductById(id).get();
        model.addAttribute("product", product);
        model.addAttribute("id", id);

        return "admin/dashboard/view-product";
    }

    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable long id) {
        Optional<Product> currentProduct = this.productService.getProductById(id);
        model.addAttribute("newProduct", currentProduct.get());
        return "admin/dashboard/update-product";
    }

    @PostMapping("/admin/product/update")
    public String handleUpdateProduct(@ModelAttribute("newProduct") @Valid Product pr,
            BindingResult newProductBindingResult,
            @RequestParam("laptopShopFile") MultipartFile file) {

        // validate
        if (newProductBindingResult.hasErrors()) {
            return "admin/product/update";
        }

        Product currentProduct = this.productService.getProductById(pr.getId()).get();
        if (currentProduct != null) {
            // update new image
            if (!file.isEmpty()) {
                String img = this.uploadFileService.handleSaveUploadFile(file, "product");
                currentProduct.setImage(img);
            }

            currentProduct.setName(pr.getName());
            currentProduct.setPrice(pr.getPrice());
            currentProduct.setQuantity(pr.getQuantity());
            currentProduct.setDetailDesc(pr.getDetailDesc());
            currentProduct.setShortDesc(pr.getShortDesc());
            currentProduct.setFactory(pr.getFactory());
            currentProduct.setTarget(pr.getTarget());

            this.productService.createProduct(currentProduct);
        }

        return "redirect:/admin/product";
    }


}
