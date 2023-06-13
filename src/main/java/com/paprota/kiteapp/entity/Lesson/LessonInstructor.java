package com.paprota.kiteapp.entity.Lesson;

import com.paprota.kiteapp.entity.Employee;
import com.paprota.kiteapp.entity.Report.BosmanReportId;
import com.paprota.kiteapp.entity.Report.Report;
import com.paprota.kiteapp.enums.EmployeeType;
import jakarta.persistence.*;

@Entity
public class LessonInstructor {

    @EmbeddedId
    private LessonInstructorId id;

    @Column(name = "hours_worked")
    private int hoursWorked;

    @ManyToOne
    @MapsId("lessonId")
    private Lesson lesson;

    @ManyToOne
    @MapsId("instructorId")
    private Employee instructor;

    public LessonInstructor() {
    }

    public LessonInstructor(Lesson lesson, Employee instructor) {
        this.lesson = lesson;
        this.instructor = instructor;
        this.hoursWorked = 0;
    }

    public LessonInstructorId getId() {
        return id;
    }

    public void setId(LessonInstructorId id) {
        this.id = id;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Employee getInstructor() {
        return instructor;
    }

    public void setInstructor(Employee instructor) {
        if (!instructor.getEmployeeTypes().contains(EmployeeType.Instructor)) {
            throw new IllegalArgumentException("Employee " + instructor.getFirstName() + " " + instructor.getLastName() + " is not an Instructor");
        }
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "LessonInstructor{" +
                "id=" + id +
                ", hoursWorked=" + hoursWorked +
                ", lesson=" + lesson +
                ", instructor=" + instructor +
                '}';
    }
}
