package com.app.mybatis.mapper;

import com.app.mybatis.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test456@gmail.com");
        memberVO.setMemberName("이순신");
        memberVO.setMemberPassword("1234");
        memberMapper.insert(memberVO);
    };

    @Test
    public void selectTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test456@gmail.com");
        memberVO.setMemberName("이순신");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::toString).ifPresent(log::info);
    };


    @Test
    public void updateTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setId(1L);
        memberVO.setMemberEmail("update123@gmail.com");
        memberVO.setMemberName("세종");
        memberVO.setMemberPassword("1234567");
        memberMapper.update(memberVO);
    }

    @Test
    public void deleteTest(){
        MemberVO memberVO = new MemberVO();
        memberMapper.delete(2L);


    }


}
