package com.xiaoy.oem.service.examService;

import com.xiaoy.oem.entity.examEntity.Exam;

import java.util.List;

public interface ExamService {

    void addExam(Exam exam);

    List<Exam> queryExam(Exam exam);

    Exam queryExamById(Integer id);
}
