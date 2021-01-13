package ssau.esa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ssau.esa.model.Faculty;
import ssau.esa.model.FacultyXml;
import ssau.esa.model.Student;
import ssau.esa.model.StudentXml;
import ssau.esa.repo.FacultyRepo;
import ssau.esa.repo.StudentRepo;
import java.util.List;

@RestController
@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
public class MainRestController {

    private final StudentRepo studentRepo;
    private final FacultyRepo facultyRepo;

    @Autowired
    public MainRestController(StudentRepo studentRepo, FacultyRepo facultyRepo) {
        this.studentRepo = studentRepo;
        this.facultyRepo = facultyRepo;
    }

    @GetMapping(value = "/studentsJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Student> getAllStudent(){
        return this.studentRepo.findAll();
    }

    @GetMapping(value = "/studentsXml", produces = {MediaType.APPLICATION_XML_VALUE})
    public StudentXml getAllStudentsXml(){
        return new StudentXml((List<Student>) this.studentRepo.findAll());
    }

    @PostMapping(value = "/studentsAdd")
    public String addStudent(@RequestBody @ModelAttribute("student") Student student){
        studentRepo.save(student);
        return "student";
    }

    @GetMapping(value = "/facultiesJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Faculty> getAllFaculty(){
        return this.facultyRepo.findAll();
    }

    @GetMapping(value = "/facultiesXml", produces = {MediaType.APPLICATION_XML_VALUE})
    public FacultyXml getAllFacultyXml(){
        return new FacultyXml((List<Faculty>) this.facultyRepo.findAll());
    }

    @PostMapping(value = "/facultiesAdd")
    public String addFaculty(@ModelAttribute("faculty") Faculty faculty){
        facultyRepo.save(faculty);
        return "redirect:/faculty";
    }
}
