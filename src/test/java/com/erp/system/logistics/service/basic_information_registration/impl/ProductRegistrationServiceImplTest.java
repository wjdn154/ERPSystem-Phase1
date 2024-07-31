package com.erp.system.logistics.service.basic_information_registration.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.logistics.model.basic_information_registration.product_registration.Product;
import com.erp.system.logistics.model.basic_information_registration.product_registration.ProductGroup;
import com.erp.system.logistics.model.dto.ProductRegistrationDto;
import com.erp.system.logistics.repository.basic_information_registration.product_registration.ProductGroupRepository;
import com.erp.system.logistics.repository.basic_information_registration.product_registration.ProductRepository;
import com.erp.system.logistics.service.basic_information_registration.ProductRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRegistrationServiceImplTest {
    private ProductRegistrationService productRegistrationService;
    private ProductGroupRepository productGroupRepository;
    private ProductRepository productRepository;

    // 테스트 실행 전 초기 설정
    @BeforeEach
    void setUp() {
        // 싱글톤 인스턴스를 사용하여 저장소 초기화
        DependencyInjector di = DependencyInjector.getInstance();

        productRegistrationService = di.getInstance(ProductRegistrationService.class);
        productGroupRepository = di.getInstance(ProductGroupRepository.class);
        productRepository = di.getInstance(ProductRepository.class);

        productGroupRepository.reset();
        productRepository.reset();
    }

    @Test
    public void testRegisterProduct() {
        // Given: 테스트 데이터 설정
        ProductRegistrationDto productRegistrationDto = new ProductRegistrationDto();
        productRegistrationDto.setName("맥북 에어");
        productRegistrationDto.setProductionProcessName("1");
        productRegistrationDto.setGroupName("노트북");
        productRegistrationDto.setPurchasePrice(1500000.0);
        productRegistrationDto.setSalesPrice(2500000.0);
        productRegistrationDto.setStandard("31cm x 22cm");
        productRegistrationDto.setUnit("EA");
        productRegistrationDto.setProductType(Product.ProductType.FINISHED_GOOD);

        // When: 메소드 호출
        productRegistrationService.registerProduct(productRegistrationDto);

        // Then: 결과 검증
        productGroupRepository.findById(String.valueOf(ProductGroup.idIndex-1)).ifPresent(productGroup -> {
            assertEquals(productRegistrationDto.getGroupName(), productGroup.getName());
        });

        productRepository.findById(String.valueOf(Product.idIndex-1)).ifPresent(product -> {
            assertEquals("맥북 에어", product.getName());
            assertEquals(1500000.0, product.getPurchasePrice());
            assertEquals(2500000.0, product.getSalesPrice());
            assertEquals("31cm x 22cm", product.getStandard());
            assertEquals("EA", product.getUnit());
            assertEquals(productRegistrationDto.getProductType(), product.getProductType());
        });
    }
}