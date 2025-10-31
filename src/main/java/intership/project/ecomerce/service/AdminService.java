package intership.project.ecomerce.service;

import intership.project.ecomerce.dto.ProductDTO;
import intership.project.ecomerce.model.product.Product;
import intership.project.ecomerce.repository.admin.AdminRepository;
import intership.project.ecomerce.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ProductRepository productRepository;

    AdminService(AdminRepository adminRepository, ProductRepository productRepository) {
        this.adminRepository = adminRepository;
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productdto) {
        Product newProduct = new Product();
        newProduct.setCategory(productdto.category());
        newProduct.setName(productdto.name());
        newProduct.setDescription(productdto.description());
        newProduct.setImageURL(productdto.imageURL());
        productRepository.save(newProduct);

        return productdto;
    }

}
