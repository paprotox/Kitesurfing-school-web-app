package com.paprota.kiteapp.entity;

import com.paprota.kiteapp.entity.Lesson.LessonInstructor;
import com.paprota.kiteapp.entity.Report.BosmanReport;
import com.paprota.kiteapp.enums.EmployeeType;
import com.paprota.kiteapp.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee extends Person{

    @Column(name = "pay_rate")
    private double payRate;

    @Column(name = "license")
    private boolean gotLicense;

    @Column(name = "experience")
    private int experience;

    @ElementCollection(targetClass = EmployeeType.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private EnumSet<EmployeeType> employeeTypes = EnumSet.of(EmployeeType.Employee);

    @OneToMany(mappedBy = "bosman",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<BosmanReport> reports = new ArrayList<>();

    @OneToMany(mappedBy = "instructor",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<LessonInstructor> lessonInstructors = new ArrayList<>();
    public Employee() {
    }

    public static int calculateTotalHoursWorked(Employee employee) {
        int totalHoursWorked = 0;
        for (LessonInstructor lessonInstructor : employee.getLessonInstructors()) {
            totalHoursWorked += lessonInstructor.getHoursWorked();
        }
        return totalHoursWorked;
    }

    public Employee(String firstName, String lastName, Gender gender, LocalDate birthDate, Contact contact, double payRate) {
        super(firstName, lastName, gender, birthDate, contact);
        this.payRate = payRate;
    }

    public void setEmployeeTypes(EnumSet<EmployeeType> employeeTypes) {
        this.employeeTypes = employeeTypes;
    }

    public List<BosmanReport> getReports() {
        return reports;
    }

    public void setReports(List<BosmanReport> reports) {
        this.reports = reports;
    }

    public List<LessonInstructor> getLessonInstructors() {
        return lessonInstructors;
    }

    public void setLessonInstructors(List<LessonInstructor> lessonInstructors) {
        this.lessonInstructors = lessonInstructors;
    }

    public void setInstructor(boolean gotLicense) {
        this.gotLicense = gotLicense;
        this.employeeTypes.add(EmployeeType.Instructor);
    }
    public void unSetInstructor() {
        this.gotLicense = Boolean.parseBoolean(null);
        this.employeeTypes.remove(EmployeeType.Instructor);
    }

    public void setBosman(int experience) {
        this.experience = experience;
        this.employeeTypes.add(EmployeeType.Bosman);
    }

    public void unSetBosman() {
        this.experience = Integer.parseInt(null);
        this.employeeTypes.remove(EmployeeType.Instructor);
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        if(!this.employeeTypes.contains(EmployeeType.Instructor)) {
            try {
                throw new Exception("Employee " + this.getFirstName() + " " + this.getLastName() + " is not a Instructor");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        this.payRate = payRate;
    }

    public boolean isGotLicense() {
        if(!this.employeeTypes.contains(EmployeeType.Instructor)) {
            try {
                throw new Exception("Employee " + this.getFirstName() + " " + this.getLastName() + " is not a Instructor");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return gotLicense;
    }

    public void setGotLicense(boolean gotLicense) {
        this.gotLicense = gotLicense;
    }

    public int getExperience() {
        if(!this.employeeTypes.contains(EmployeeType.Bosman)) {
            try {
                throw new Exception("Employee " + this.getFirstName() + " " + this.getLastName() + " is not a Bosman");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return experience;
    }

    public void setExperience(int experience) {
        if(!this.employeeTypes.contains(EmployeeType.Bosman)) {
            try {
                throw new Exception("Employee " + this.getFirstName() + " " + this.getLastName() + " is not a Bosman");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        this.experience = experience;
    }

    public EnumSet<EmployeeType> getEmployeeTypes() {
        return employeeTypes;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "payRate=" + payRate +
                ", gotLicense=" + gotLicense +
                ", experience=" + experience +
                ", employeeTypes=" + employeeTypes +
                '}';
    }
}
