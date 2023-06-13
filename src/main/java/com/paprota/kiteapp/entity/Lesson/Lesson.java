package com.paprota.kiteapp.entity.Lesson;

import com.paprota.kiteapp.entity.Group;
import com.paprota.kiteapp.enums.LessonType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;

    @Column(name = "tile", unique = true)
    private String tile;

    @Enumerated(EnumType.STRING)
    @Column(name = "lesson_type")
    private LessonType lessonType;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @OneToMany(mappedBy = "lesson",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<LessonInstructor> lessonInstructors = new ArrayList<>();

    public Lesson(String tile, LessonType lessonType, Group group) {
        this.tile = tile;
        this.lessonType = lessonType;
        this.group = group;
    }

    public Lesson() {
    }


    public List<LessonInstructor> getLessonInstructors() {
        return lessonInstructors;
    }

    public void setLessonInstructors(List<LessonInstructor> lessonInstructors) {
        this.lessonInstructors = lessonInstructors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", tile='" + tile + '\'' +
                ", lessonType=" + lessonType +
                ", group=" + group +
                ", lessonInstructors=" + lessonInstructors +
                '}';
    }
}
