package com.spring.mvc.score.domain;

import lombok.*;

import static com.spring.mvc.score.domain.Grade.*;

@Setter @Getter @ToString
//@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드 초기화 생성자
public class Score {

    // 클라이언트가 전달할 데이터
    private String name; // 학생 이름
    private int kor, eng, math; // 국, 영, 수 점수

    private static int seq; // 일련번호

    // 서버에서 생성하는 데이터
    private int stuNum; // 학번
    private int total; // 총점
    private double average; // 평균
    private Grade grade; // 학점

    public Score() {
        this.stuNum = ++seq;
    }

    // 총점 평균 계산
    public void calcTotalAndAvg() {
        this.total = kor + eng + math;
        this.average = total / 3.0;
    }
    // 학점 계산
    public void calcGrade() {
        if (this.average >= 90) {
            this.grade = A;
        } else if (this.average >= 80) {
            this.grade = B;
        } else if (this.average >= 70) {
            this.grade = C;
        } else if (this.average >= 60) {
            this.grade = D;
        } else {
            this.grade = F;
        }

    }


}
