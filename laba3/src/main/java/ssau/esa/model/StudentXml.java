package ssau.esa.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "students")
public class StudentXml {

    @XmlElement
    List<Student> students = new ArrayList<>();

    public StudentXml(){
    }

    public StudentXml(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

}
