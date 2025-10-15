package com.app.mybatis.mapper;

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

    @Test
    public void insertTest(){
        PostVO postVO = new PostVO();
        postVO.setPostTitle("오늘 뭐 먹지?");
        postVO.setPostContent("오늘 메뉴 추천 좀!");
        postVO.setPostStatus("PUBLIC".equals("PUBLIC") ? PostStatus.PUBLIC : PostStatus.PRIVATE);
        postVO.setMemberId(1L);

        postMapper.insert(postVO);
    }
}
