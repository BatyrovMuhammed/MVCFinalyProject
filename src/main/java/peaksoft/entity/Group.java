package peaksoft.entity;


import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@NoArgsConstructor
@Table(name = "groups")
public class Group {

    @Id
//    @SequenceGenerator(
//            name = "company_sequence",
//            sequenceName = "company_sequence",
//            allocationSize = 1
//    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
          //  generator = "company_sequence")
    private Long id;
    private String groupName;
   // @DateTimeFormat(pattern = "dd-mm-yyyy")
//    @Temporal(TemporalType.DATE)
    private String dateOfStart;
   // @DateTimeFormat(pattern = "dd-mm-yyyy")
//    @Temporal(TemporalType.DATE)
    private String dateOfFinish;

    @Transient
    private Long courseId;



    @ManyToMany(cascade = {PERSIST, MERGE, DETACH, REFRESH},fetch = FetchType.LAZY, mappedBy = "gro")
    private List<Course>courses;


    @OneToMany(cascade = MERGE,mappedBy = "group")
    private List<Student>students;

    public Group(String groupName, String dateOfStart, String dateOfFinish) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(String dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public String getDateOfFinish() {
        return dateOfFinish;
    }

    public void setDateOfFinish(String dateOfFinish) {
        this.dateOfFinish = dateOfFinish;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setCourse1(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setGroups1(this);
    }
    public Course course2(){
        Course course = new Course();
        return  course;
    }



    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setCourse(Course course) {
        this.courses.add(course);
    }
}
