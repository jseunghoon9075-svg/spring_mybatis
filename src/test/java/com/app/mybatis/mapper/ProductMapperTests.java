package com.app.mybatis.mapper;

import com.app.mybatis.domain.ProductVO;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ProductMapperTests {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void insertTest(){
        ProductVO productVO = new ProductVO();
        productVO.setProductName("피자");
        productVO.setProductPrice(25000);
        productVO.setProductStock(10);

        productMapper.insert(productVO);
    };

    @Test
    public void selectTest(){
        ProductVO productVO = new ProductVO();
        productVO.setId(2L);
        productMapper.select(productVO).map(ProductVO::toString).ifPresent(log::info);
    }

    @Test
    public void selectAllTest(){
        List<ProductVO> products = productMapper.selectAll();
        log.info("products: {}", products);
    }

    @Test
    public void updateTest(){
        ProductVO productVO = new ProductVO();
        productVO.setId(2L);
        productVO.setProductName("삼겹살");
        productVO.setProductPrice(12000);
        productVO.setProductStock(10);
        productMapper.update(productVO);
    }

    @Test
    public void deleteTest(){
        productMapper.delete(2L);
    }

}
