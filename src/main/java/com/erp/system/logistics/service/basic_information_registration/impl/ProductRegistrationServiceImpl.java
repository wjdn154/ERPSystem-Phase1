package com.erp.system.logistics.service.basic_information_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.logistics.model.basic_information_registration.product_registration.Product;
import com.erp.system.logistics.model.basic_information_registration.product_registration.ProductGroup;
import com.erp.system.logistics.model.dto.ProductRegistrationDto;
import com.erp.system.logistics.repository.basic_information_registration.product_registration.ProductGroupRepository;
import com.erp.system.logistics.repository.basic_information_registration.product_registration.ProductRepository;
import com.erp.system.logistics.service.basic_information_registration.ProductRegistrationService;

@Component
public class ProductRegistrationServiceImpl implements ProductRegistrationService {
    // 리포지토리 인스턴스
    private final ProductGroupRepository productGroupRepository;
    private final ProductRepository productRepository;

    /**
     * 생성자. 각 리포지토리의 인스턴스를 초기화함.
     */
    public ProductRegistrationServiceImpl(ProductGroupRepository productGroupRepository, ProductRepository productRepository) {
        this.productGroupRepository = productGroupRepository;
        this.productRepository = productRepository;
    }

    /**
     * 품목 등록 메소드. 주어진 DTO를 바탕으로 품목과 관련된 모든 정보를 생성하고 저장함.
     * @param productRegistrationDto 회사 등록을 위한 정보가 담긴 DTO
     * @throws RuntimeException 등록 중 발생한 예외를 처리함
     */
    @Override
    public void registerProduct(ProductRegistrationDto productRegistrationDto) {
        try{
            ProductGroup productGroup = createProductGroup(productRegistrationDto);
            Product product = createProduct(productRegistrationDto, "1", productGroup.getId());

            productGroupRepository.save(productGroup);
            productRepository.save(product);

        } catch (Exception e){
            System.err.println("품목 등록 중 에러 발생: " + e.getMessage());
            throw new RuntimeException("등록 실패", e);
        }
    }

    /**
     * 품목 그룹 정보를 생성하고 저장함.
     * @param dto 품목 등록을 위한 정보가 담긴 DTO
     * @return 저장된 주소 객체
     */
    public ProductGroup createProductGroup(ProductRegistrationDto dto) {
        return new ProductGroup.Builder()
                .name(dto.getGroupName())
                .build();
    }

    /**
     * 품목 정보를 생성하고 저장함.
     * @param dto 품목 등록을 위한 정보가 담긴 DTO
     * @return 저장된 주소 객체
     */
    public Product createProduct(ProductRegistrationDto dto, String productionProcessId, String groupId){
        return new Product.Builder()
                .name(dto.getName())
                .productionProcessId(productionProcessId)
                .groupId(groupId)
                .purchasePrice(dto.getPurchasePrice())
                .salesPrice(dto.getSalesPrice())
                .standard(dto.getStandard())
                .unit(dto.getUnit())
                .productType(dto.getProductType())
                .build();
    }
}
