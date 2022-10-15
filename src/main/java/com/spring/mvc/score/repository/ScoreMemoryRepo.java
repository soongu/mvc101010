package com.spring.mvc.score.repository;

import com.spring.mvc.score.domain.Score;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//빈 등록
@Repository
public class ScoreMemoryRepo implements ScoreRepository {

    // 메모리 저장소
//  // key: 학번, value: 성적정보
    private static final Map<Integer, Score> scoreMap
            = new HashMap<>();

    @Override
    public boolean save(Score score) {
        scoreMap.put(score.getStuNum(), score);
        return true;
    }

    @Override
    public List<Score> findAll(String sort) {
        List<Score> scoreList = new ArrayList<>();

        for (Integer stuNum : scoreMap.keySet()) {
            Score score = scoreMap.get(stuNum);
            scoreList.add(score);
        }
        return scoreList;
    }

    @Override
    public Score findOne(int stuNum) {
        return scoreMap.get(stuNum);
    }

    @Override
    public boolean remove(int stuNum) {
        scoreMap.remove(stuNum);
        return true;
    }
}
