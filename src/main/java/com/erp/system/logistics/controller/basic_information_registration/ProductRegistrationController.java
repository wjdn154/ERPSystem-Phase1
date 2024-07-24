package com.erp.system.logistics.controller.basic_information_registration;

import com.erp.system.common.annotation.Component;
import com.erp.system.logistics.model.basic_information_registration.product_registration.Product;
import com.erp.system.logistics.model.basic_information_registration.product_registration.ProductGroup;
import com.erp.system.logistics.repository.basic_information_registration.product_registration.ProductGroupRepository;
import com.erp.system.logistics.repository.basic_information_registration.product_registration.ProductRepository;
import com.erp.system.logistics.service.basic_information_registration.ProductRegistrationService;

import java.util.Collection;
import java.util.Optional;

@Component
public class ProductRegistrationController {
    private final ProductRegistrationService productRegistrationService;
    private final ProductGroupRepository productGroupRepository;
    private final ProductRepository productRepository;

    public ProductRegistrationController(ProductRegistrationService productRegistrationService, ProductGroupRepository productGroupRepository, ProductRepository productRepository) {
        this.productRegistrationService = productRegistrationService;
        this.productGroupRepository = productGroupRepository;
        this.productRepository = productRepository;
    }

    /**
     * 품목 그룹을 저장함
     * @param productGroup 저장할 주소
     */
    public void saveProductGroup(ProductGroup productGroup){
        productGroupRepository.save(productGroup);
    }

    /**
     * 품목을 저장함
     * @param product 저장할 주소
     */
    public void saveProduct(Product product){
        productRepository.save(product);
    }

    /**
     * ID로 품목 그룹을 조회함
     * @param id 주소의 ID
     * @return 조회된 품목 그룹을 Optional로 반환
     */
    public Optional<ProductGroup> findProductGroupById(String id){
        return productGroupRepository.findById(id);
    }

    /**
     * ID로 품목을 조회함
     * @param id 주소의 ID
     * @return 조회된 품목을 Optional로 반환
     */
    public Optional<Product> findProductById(String id){
        return productRepository.findById(id);
    }

    /**
     * 모든 품목 그룹를 조회함
     * @return 저장된 모든 품목 그룹의 컬렉션
     */
    public Collection<ProductGroup> findAllProductGroup(){
        return productGroupRepository.findAll();
    }

    /**
     * 모든 품목을 조회함
     * @return 저장된 모든 품목의 컬렉션
     */
    public Collection<Product> findAllProduct(){
        return productRepository.findAll();
    }
}
