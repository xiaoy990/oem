package com.xiaoy.oem.controller.questionController;

import com.xiaoy.oem.entity.questionEntity.Question;
import com.xiaoy.oem.service.questionService.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class QuestionController {

    @Resource
    QuestionService questionService;

    @RequestMapping("addQuestions")
    public String addQuestions(Question question, String option0, String option1, String option2){
//        HttpSession session = request.getSession();
        question.setOptions(option0 + "," + option1  + "," + option2);
//        question.setPublisher(session.getAttribute("user").toString());
        questionService.addQuestion(question);
        System.out.println(question);
        return "redirect:toAddQuestion";
    }

    @RequestMapping("toAddQuestion")
    public String toAddQuestion(){
        return "question/addQuestion";
    }
}
