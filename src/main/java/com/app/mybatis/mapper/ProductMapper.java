package com.app.mybatis.mapper;

import com.app.mybatis.domain.MemberVO;
import com.app.mybatis.domain.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductMapper {
//    상품등록
    public void insert(ProductVO productVO);
//    상품조회 1개
    public Optional<ProductVO> select(ProductVO productVO);
//    전체상품조회
    public List<ProductVO> selectAll();
//    상품수정
    public void update(ProductVO productVO);
//    상품삭제
    public void delete(Long id);



}
