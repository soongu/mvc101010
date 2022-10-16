package com.spring.mvc.score.repository;

import com.spring.mvc.score.domain.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 점수 저장소
// 역할: 성적정보를 저장하고 조회하고 삭제하는 일을 수행
@Mapper
public interface ScoreMapper {

    // 점수 저장
    boolean save(Score score);

    // 전체 점수 정보 조회
    List<Score> findAll(String sort);

    // 개별 점수 조회
    Score findOne(int stuNum);

    // 점수 정보 삭제
    boolean remove(int stuNum);

}
