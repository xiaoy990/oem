package com.xiaoy.oem.controller.examController;

import com.xiaoy.oem.entity.examEntity.Exam;
import com.xiaoy.oem.entity.examinationRecord.ExaminationRecord;
import com.xiaoy.oem.entity.questionEntity.Question;
import com.xiaoy.oem.entity.questionEntity.QuestionList;
import com.xiaoy.oem.service.examService.ExamService;
import com.xiaoy.oem.service.examinationRecordService.ExaminationRecordService;
import com.xiaoy.oem.service.questionService.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("")
public class ExamController {

    @Resource
    ExaminationRecordService examinationRecordService;

    @Resource
    QuestionService questionService;

    @Resource
    ExamService examService;

    @RequestMapping("/toExam")
    public String toExam(Exam exam,Model model){
        Exam curExam = examService.queryExamById(exam.getId());
        List<Question> list = new ArrayList<>();
        String questions = curExam.getQuestionCode();
        String[] questionsList = questions.split(",");
        for (int i = 0; i < questionsList.length; i++) {
            Question tempQuestion = questionService.queryQuestionById(Integer.valueOf(questionsList[i]));
            String[] options = tempQuestion.getOptions().split(",");
            tempQuestion.setOption1(options[0]);
            tempQuestion.setOption2(options[1]);
            tempQuestion.setOption3(options[2]);
            list.add(tempQuestion);
        }
        model.addAttribute("list",list);
        model.addAttribute("examId",exam.getId());
        return "exam/mainExam";
    }

    @RequestMapping("/homeExam")
    public String homeExam(Model model){
        Exam exam = new Exam();
        List<Exam> curExam = examService.queryExam(exam);
        model.addAttribute("curList",curExam);
        return "home";
    }

    @RequestMapping("toAddExam")
    public String toAddExam(Exam exam,Model model){
        return "exam/addExam";
    }

    @RequestMapping("addExam")
    public String addExam(Exam exam,HttpServletRequest req){
        HttpSession session = req.getSession();
        exam.setPublisher(session.getAttribute("username").toString());
        examService.addExam(exam);
        return "redirect:homeExam";
    }

    @RequestMapping("examHandler")
    public String examHandler(QuestionList question, String examId, HttpServletRequest req,Model model){
        HttpSession session = req.getSession();
        StringBuilder stringBuffer = new StringBuilder();
        ExaminationRecord examinationRecord = new ExaminationRecord();
        examinationRecord.setExamCode(examId);
        //参数中的question是QuestionList的一个实例，它事实上聚合了一个动态数组 使用get方法获得
        Integer count = question.getQuestion().size();
        for (Question q : question.getQuestion()
             ) {
            if (!q.getOption1().equals(q.getAnswer())){
                count--;
                stringBuffer
                        .append(q.getId())
                        .append(":")
                        .append(q.getOption1())
                        .append(",");
            }
        }
        if (stringBuffer.length()>0){
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        examinationRecord.setMistakesCollection(stringBuffer.toString());
        examinationRecord.setGrade(String.valueOf(count*3));
        examinationRecord.setId(UUID.randomUUID().toString().replaceAll("-",""));
        //待完善
//        examinationRecord.setUserNumber(session.getAttribute("userName").toString());
        examinationRecord.setUserNumber(session.getAttribute("username").toString());
        examinationRecordService.addExaminationRecord(examinationRecord);
        recordHandler(examinationRecord,model,session);
        return "exam/examGrades";
    }

    @RequestMapping("toHistory")
    public String toHistory(HttpServletRequest req,Model model){
        HttpSession session = req.getSession();
        ExaminationRecord examinationRecord = new ExaminationRecord();
        examinationRecord.setUserNumber(session.getAttribute("username").toString());
        List<ExaminationRecord> list = examinationRecordService.queryExaminationRecordByUsername(examinationRecord);
        for (ExaminationRecord e:list
             ) {
            e.setGrade(examService.queryExamById(Integer.valueOf(e.getExamCode())).getName_());
        }
        //实在懒得加属性了  临时借一下Grade属性来存考试名
//        List<Exam> list = new ArrayList<>();
//        for (ExaminationRecord e:recordList
//             ) {
//            list.add(examService.queryExamById(Integer.valueOf(e.getExamCode())));
//        }
        model.addAttribute("list",list);
        return "exam/examHistory";
    }

    @RequestMapping("toExamGrades")
    public String toExamResult(HttpSession session,ExaminationRecord examinationRecord,Model model){
        examinationRecord.setId(examinationRecord.getExamCode());
        recordHandler(examinationRecord,model,session);
        return "exam/examGrades";
    }

    public void recordHandler(ExaminationRecord examinationRecord,Model model,HttpSession session){
        System.out.println(examinationRecord);
        examinationRecord = examinationRecordService.queryExaminationRecord(examinationRecord).get(0);
        model.addAttribute("record",examinationRecord);
        model.addAttribute("rate","50%");

        List<String> idList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();

        String[] strings = examinationRecord.getMistakesCollection().split(",");

        for (int i = 0; i < strings.length; i++) {
            String[] temp = strings[i].split(":");
            if (temp.length>1){
                idList.add(temp[0]);
                answerList.add(temp[1]);
            }
        }
        int count = 0;
        List<Question> list = new ArrayList<>();
        for (String str:idList
        ) {
            Question question = null;
            question = questionService.queryQuestionById(Integer.valueOf(str));
            System.out.println(question);
            String[] tempOptions = question.getOptions().split(",");
            question.setOption1(tempOptions[0]);
            question.setOption2(tempOptions[1]);
            question.setOption3(tempOptions[2]);
            //借用options来存用户答案  实在懒得写了！
            question.setOptions(answerList.get(count++));
            list.add(question);
        }
        examinationRecord.setUserNumber(session.getAttribute("username").toString());
        model.addAttribute("list",list);
    }

}
