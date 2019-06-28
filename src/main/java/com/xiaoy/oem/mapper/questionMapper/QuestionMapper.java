package com.xiaoy.oem.mapper.questionMapper;

import com.xiaoy.oem.entity.questionEntity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {

    List<Question> queryQuestion(@Param("question") Question question);

    void addQuestion(@Param("question") Question question);

    Question queryQuestionById(@Param("id") Integer id);
}
