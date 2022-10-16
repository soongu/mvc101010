package com.spring.mvc.score.controller;

import com.spring.mvc.score.domain.Score;
import com.spring.mvc.score.repository.ScoreMemoryRepo;
import com.spring.mvc.score.repository.ScoreRepository;
import com.spring.mvc.score.service.ScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor // final필드 초기화 생성자를 만듦
public class ScoreController {

    private final ScoreRepository repository;
    private final ScoreService service;


    // 점수 등록 및 조회 화면 열기 요청
    @GetMapping("/score/list")
    public String list(
            @RequestParam(defaultValue = "num") String sort
            , Model model) {
        log.info("/score/list GET 요청!! - param1 : {}", sort);

        List<Score> scoreList = service.findAllService(sort);

        model.addAttribute("scores", scoreList);

        // /WEB-INF/score/list.jsp 포워딩해서 열어주는 코드
        return "score/list";
    }

    // 점수 신규 등록 요청
    @PostMapping("/score/register")
    public String register(Score score) {
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("/score/register POST! - " + score);

        return repository.save(score) ? "redirect:/score/list" : "redirect:/";
    }

    // 점수 삭제 요청
    @RequestMapping("/score/delete")
    public String delete(@RequestParam("stuNum") int sn) {
        log.info("/score/delete GET - param1: {}", sn);
        return repository.remove(sn) ? "redirect:/score/list" : "redirect:/";
    }

    // 점수 상세 조회 요청
    @GetMapping("/score/detail")
    public String detail(int stuNum, Model model) {
        log.info("/score/detail GET - param1: {}", stuNum);
        Score score = repository.findOne(stuNum);
        model.addAttribute("s", score);

        return "score/detail";
    }

}
