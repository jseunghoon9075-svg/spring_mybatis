package com.app.mybatis.mapper;

import com.app.mybatis.domain.MemberVO;
import com.app.mybatis.domain.PostDTO;
import com.app.mybatis.domain.PostVO;
import com.app.mybatis.enums.PostStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Random;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertTest() {

        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test123@gmail.com");
        memberVO.setMemberName("홍길동");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::getId).ifPresent(memberId -> {
            PostVO postVO = new PostVO();
            postVO.setPostTitle("나만의 비밀이야기!");
            postVO.setPostContent("오늘 사실 안 아픔!");
            postVO.setPostStatus("PRIVATE".equals("PUBLIC") ? PostStatus.PUBLIC : PostStatus.PRIVATE);
            postVO.setMemberId(memberId);

            postMapper.insert(postVO);
        });
    }

    @Test
    public void selectAll() {
        log.info("selectAll: {}", postMapper.selectAll());
    }

    @Test
    public void selectTest() {
        postMapper.updateReadCount(4L);
        postMapper.select(1L).map(PostDTO::toString).ifPresent(log::info);
    }

    @Test
    public void updateTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test123@gmail.com");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::getId).ifPresent(memberId -> {
            PostDTO postDTO = new PostDTO();
            postDTO.setId(4L);
            postDTO.setPostTitle("저녁에 맥주");
            postDTO.setPostContent("맥주한잔");
            postDTO.setPostStatus("PUBLIC".equals("PUBLIC") ? PostStatus.PUBLIC : PostStatus.PRIVATE);

            postMapper.update(postDTO);
        });
    }

    @Test
    public void deleteTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test123@gmail.com");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::getId).ifPresent(memberId -> {
            postMapper.delete(3L);
        });
    }

    @Test
    public void insertTests() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test123@gmail.com");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::getId).ifPresent(memberId -> {
            for (int i = 0; i < 50; i++) {
                PostVO postVO = new PostVO();
                postVO.setPostTitle("테스트 작성글" + (i + 1));
                postVO.setPostContent("테스트 작성글" + (i + 1));
                postVO.setMemberId(memberId);
                postMapper.insert(postVO);
            }
        });
    }

    @Test
    public void updateReadCountTest() {
        Random random = new Random();

        for(int i = 0; i < 10000; i++) {
            Long id = Long.valueOf(random.nextInt(1, 50));
            postMapper.select(id)
                    .map(PostDTO::getId)
                    .ifPresent(postMapper::updateReadCount);
        }
        random.nextInt(50);
    }

    @Test
    public void selectAllWithOrderTests(){
        String order = null;
        order = "popular";
        postMapper.selectAllWithOrder(order).stream().map(PostDTO::getPostReadCount).forEach(postDTO -> {
            log.info("인기순 : {}", postDTO);
        });
    }

    @Test
    public void selectAllWithParamsTests(){
        HashMap<String,Object> params = new HashMap<>();
        params.put("order","unpopular");
        params.put("cursor","1");
        params.put("direction","asc");

        postMapper.selectAllWithParam(params).stream().map(PostDTO::toString).forEach(log::info);
    }

}