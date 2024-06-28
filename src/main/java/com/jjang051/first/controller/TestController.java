package com.jjang051.first.controller;

import com.jjang051.first.dto.Member;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class TestController {

    //private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/user")
    @ResponseBody
    public String testController02(Model model) {
        return "html/test02";
    }
    //@GetMapping("/test")
    public String testController(Model model, HttpServletRequest request) {
        String userName = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("model = " + model + ", request = " + request);
        System.out.println(userName);
        System.out.println(age);
        model.addAttribute("name","jjang051");
        model.addAttribute("data","spring fighting");
        model.addAttribute("data02","<strong>hello</strong>");
        return "html/test";
    }
    //@GetMapping("/test")
    public String testControllerRequestParam(
                                 Model model,
                                 @RequestParam("username") String username,
                                 @RequestParam("age") int age) {
        int myAge = age+20;
        log.info("username={},age={}",username,age);
        model.addAttribute("name","jjang051");
        model.addAttribute("data","spring fighting");
        model.addAttribute("data02","<strong>hello</strong>");
        return "html/test";
    }

    @GetMapping("/test")
    public String testControllerRequestParam02(
            Model model,
            @RequestParam String username,
            @RequestParam(defaultValue = "10") Integer age) {
        //required= false 쓰면 데이터 없을때 null 떨어짐...
        //int myAge = age+20;
        log.info("username={},age={}",username,age);
        model.addAttribute("name",username);
        model.addAttribute("data","spring fighting");
        model.addAttribute("data02","<strong>hello</strong>");
        return "html/test";
    }

    @GetMapping("/variable")
    public String testController03(Model model) {
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member("kim",30));
        memberList.add(new Member("yang",40));

        Member member01 = new Member("jjang051",20);
        Member member02 = new Member("jjang052",30);

        Map<String,Member> map = new HashMap<>();
        map.put("member01",member01);
        map.put("member02",member02);

        model.addAttribute("member",member01);
        model.addAttribute("memberList",memberList);
        model.addAttribute("map",map);
        return "html/variable";
    }

    @GetMapping("/link")
    public String link(Model model) {
        //view Resolver  ("/template/"+html/link+".html");
        model.addAttribute("param01","jjang051");
        model.addAttribute("param02","30");
        return "html/link";
    }
}
