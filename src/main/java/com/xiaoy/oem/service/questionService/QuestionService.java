package com.xiaoy.oem.service.questionService;

import com.xiaoy.oem.entity.questionEntity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionService {

    List<Question> queryQuestion(Question question);

    void addQuestion(@Param("question") Question question);

    Question queryQuestionById(@Param("id") Integer id);
}
