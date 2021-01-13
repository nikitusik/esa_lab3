package ssau.esa.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "faculties")
public class FacultyXml {

    @XmlElement
    List<Faculty> faculties = new ArrayList<>();

    public FacultyXml(){
    }

    public FacultyXml(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

}
