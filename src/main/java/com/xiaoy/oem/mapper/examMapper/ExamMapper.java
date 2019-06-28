package com.xiaoy.oem.mapper.examMapper;

import com.xiaoy.oem.entity.examEntity.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamMapper {

    List<Exam> queryExam(@Param("exam") Exam exam);

    void addExam(@Param("exam") Exam exam);

    Exam queryExamById(@Param("id") int id);
}
