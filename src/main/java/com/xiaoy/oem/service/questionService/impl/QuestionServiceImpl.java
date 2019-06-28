package com.xiaoy.oem.service.questionService.impl;

import com.xiaoy.oem.entity.questionEntity.Question;
import com.xiaoy.oem.mapper.questionMapper.QuestionMapper;
import com.xiaoy.oem.service.questionService.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Resource
    QuestionMapper questionMapper;

    @Override
    public List<Question> queryQuestion(Question question) {
//        List<Question> questions = questionMapper.queryQuestion(question);
        return questionMapper.queryQuestion(question);
    }

    @Override
    public void addQuestion(Question question) {
        questionMapper.addQuestion(question);
    }

    @Override
    public Question queryQuestionById(Integer id) {
        return questionMapper.queryQuestionById(id);
    }
}
