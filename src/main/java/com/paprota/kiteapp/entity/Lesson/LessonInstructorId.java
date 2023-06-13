package com.paprota.kiteapp.entity.Lesson;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class LessonInstructorId implements Serializable {

    @Column(name = "lesson_id")
    private String lessonId;

    @Column(name = "bosman_id")
    private String bosmanId;

    public LessonInstructorId() {
    }

    public LessonInstructorId(String lessonId, String bosmanId) {
        this.lessonId = lessonId;
        this.bosmanId = bosmanId;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getBosmanId() {
        return bosmanId;
    }

    public void setBosmanId(String bosmanId) {
        this.bosmanId = bosmanId;
    }

    @Override
    public String toString() {
        return "LessonInstructorId{" +
                "lessonId='" + lessonId + '\'' +
                ", bosmanId='" + bosmanId + '\'' +
                '}';
    }
}
