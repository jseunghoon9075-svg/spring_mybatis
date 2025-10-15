package com.app.mybatis.mapper;

import com.app.mybatis.domain.MemberVO;
import com.app.mybatis.domain.PostDTO;
import com.app.mybatis.domain.PostVO;
import com.app.mybatis.enums.PostStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertTest(){

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
        public void selectAll(){
            log.info("selectAll: {}", postMapper.selectAll());
        }

        @Test
        public void selectTest(){
            postMapper.updateReadCount(4L);
            postMapper.select(1L).map(PostDTO::toString).ifPresent(log::info);
        }

        @Test
        public void updateTest(){
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
        public void deleteTest(){
        MemberVO memberVO = new MemberVO();
            memberVO.setMemberEmail("test123@gmail.com");
            memberVO.setMemberPassword("1234");
            memberMapper.select(memberVO).map(MemberVO::getId).ifPresent(memberId -> {
               postMapper.delete(3L);
            });
        }

}
