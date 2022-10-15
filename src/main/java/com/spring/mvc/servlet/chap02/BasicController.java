package com.spring.mvc.servlet.chap02;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

// 클라이언트의 요청, 응답처리 클래스
@Controller // 빈 등록 : 스프링컨테이너에 객체 생성을 위임
// 스프링의 프론트 컨트롤러가 이 클래스를 HandlerMapping으로 찾음
@Log4j2
public class BasicController {


    @Getter @Setter @ToString
    static class Order {
        private int num;
        private String goods;
        private int price;
    }


    @RequestMapping("/spring/about")
    public String about() {
        log.trace("/about 요청 발생!");
        log.debug("/about 요청 발생!");
        log.info("/about 요청 발생!");
        log.warn("/about 요청 발생!");
        log.error("/about 요청 발생!");
        return "test";
    }

    @RequestMapping("/spring/hello")
    public String hello() {
        System.out.println("/hello 요청 발생!");
        return "redirect:/spring/about";
    }

//    클라이언트의 요청파라미터 읽기
    @RequestMapping("/spring/join")
    public String join(HttpServletRequest request) {
        String id = request.getParameter("id");
        System.out.println("id = " + id);
        return "";
    }
    @RequestMapping("/spring/join2")
    public String join(
            @RequestParam("h") String hobby
            , int age
    ) {
        System.out.println("hobby = " + hobby);
        return "";
    }

    // 커맨드 객체로 파라미터 읽기
    // /spring/order?num=5566&goods=book&price=5000
    @RequestMapping("/spring/order")
    public String order(Order order) {
        System.out.println("order = " + order);


        return "";
    }

}
