package com.xiaoy.oem.service.examService.impl;

import com.xiaoy.oem.entity.examEntity.Exam;
import com.xiaoy.oem.entity.questionEntity.Question;
import com.xiaoy.oem.mapper.examMapper.ExamMapper;
import com.xiaoy.oem.mapper.questionMapper.QuestionMapper;
import com.xiaoy.oem.service.examService.ExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("examService")
public class ExamServiceImpl implements ExamService {

    @Resource
    ExamMapper examMapper;

    @Resource
    QuestionMapper questionMapper;

    @Override
    public void addExam(Exam exam) {
        int examQuestionNumber = exam.getQuestionNumber();
        List<Question> totalQuestionList = questionMapper.queryQuestion(new Question());
        int totalQuestionNumber = totalQuestionList.size();
        List<Question> resultList = new ArrayList<>();
        List<String> resultListId = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < examQuestionNumber; i++) {
            int r =  random.nextInt(totalQuestionNumber);
            resultList.add(totalQuestionList.get(r));
            resultListId.add(String.valueOf(totalQuestionList.get(r).getId()));
        }
        String questionsId = String.join(",",resultListId);
        exam.setQuestionCode(questionsId);
        examMapper.addExam(exam);
    }

    @Override
    public List<Exam> queryExam(Exam exam){
        return examMapper.queryExam(exam);
    }

    @Override
    public Exam queryExamById(Integer id) {
        return examMapper.queryExamById(id);
    }
}
