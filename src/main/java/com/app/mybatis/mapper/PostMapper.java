package com.app.mybatis.mapper;

import com.app.mybatis.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
//    게시글 작성
    public void insert(PostVO postVO);

//    게시글 목록
//    게시글 조회
//    게시글 수정
//    게시글 삭제
//    조회수 증가
//    게시글 정렬
}
