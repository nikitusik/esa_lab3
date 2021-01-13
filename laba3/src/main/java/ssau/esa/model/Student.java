package ssau.esa.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement(name = "student")
@Table(name = "STUDENT")
public class Student {
    private long mobile;
    private String name;
    private  String surname;
    private int course;
    private Faculty faculty;
    public Student(){}

    @Id
    @Column(name = "mobile_phone", nullable = false, length = 100)
    @XmlElement
    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    @Column(name = "name", nullable = false, length = 100)
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", nullable = false, length = 100)
    @XmlElement
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "course", nullable = false)
    @XmlElement
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @ManyToOne(optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "faculty_id")
    @XmlElement
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
