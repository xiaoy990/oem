package com.xiaoy.oem.entity.examinationRecord;

import javax.persistence.*;

@Entity
@Table(name = "t_examinationRecord")
public class ExaminationRecord {

    @Id
    String id;

    @Column
    private String userNumber;

    @Column
    private String examCode;

    @Column
    private String mistakesCollection;

    @Column
    private String grade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getMistakesCollection() {
        return mistakesCollection;
    }

    public void setMistakesCollection(String mistakesCollection) {
        this.mistakesCollection = mistakesCollection;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ExaminationRecordMapper{" +
                "id=" + id +
                ", userNumber='" + userNumber + '\'' +
                ", examCode='" + examCode + '\'' +
                ", mistakesCollection='" + mistakesCollection + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
