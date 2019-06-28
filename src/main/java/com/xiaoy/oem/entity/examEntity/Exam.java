package com.xiaoy.oem.entity.examEntity;

import javax.persistence.*;

@Entity
@Table(name = "t_exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    private int questionNumber;
    @Column
    private String questionCode;
    @Column
    private String time_;
    @Column
    private String date_;
    @Column
    private String name_;
    @Column
    private String type_;
    @Column
    private String course;
    //发起人
    @Column
    private String publisher;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public String getTime_() {
        return time_;
    }

    public void setTime_(String time_) {
        this.time_ = time_;
    }

    public String getDate_() {
        return date_;
    }

    public void setDate_(String date_) {
        this.date_ = date_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getType_() {
        return type_;
    }

    public void setType_(String type_) {
        this.type_ = type_;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "Id=" + Id +
                ", questionNumber=" + questionNumber +
                ", questionCode='" + questionCode + '\'' +
                ", time_='" + time_ + '\'' +
                ", date_='" + date_ + '\'' +
                ", name_='" + name_ + '\'' +
                ", type_='" + type_ + '\'' +
                ", course='" + course + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
