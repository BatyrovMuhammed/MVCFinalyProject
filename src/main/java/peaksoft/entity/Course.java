package peaksoft.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "courses")
public class Course {

    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "company_sequence")
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private String duration;

    @Transient
    private Long companyId;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
       // @JoinTable(name = "groups_course",joinColumns = @JoinColumn(name = "course_id"),inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group>gro;



    @OneToOne(cascade = CascadeType.MERGE,mappedBy = "course")
    private Teacher teacher;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "company_id")
    private  Company company;

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Group> getGroups() {
        return gro;
    }

    public void setGroups(List<Group> groups) {
        this.gro = groups;
    }

    public void setGroups1(Group group) {
        if (gro == null) {
            gro = new ArrayList<>();
        }
        gro.add(group);
    }



    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }




}
