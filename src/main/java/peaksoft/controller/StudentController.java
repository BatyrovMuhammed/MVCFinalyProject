package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Group;
import peaksoft.entity.Student;
import peaksoft.service.GroupService;
import peaksoft.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final GroupService groupService;

    @Autowired
    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping("/getStudent/{id}")
    public String showStudent(@PathVariable("id") long id, Model model ){
        model.addAttribute("showStudent",studentService.getByIdStudent(id));
        return "studentHtml/showStudent";
    }

    @GetMapping("/{id}")
    public String getAll(@PathVariable("id")long id,Model model){
        model.addAttribute("comstudent",studentService.getAllStudent(id));
        return "studentHtml/getAll";
    }
    @GetMapping("/add")
    public String addStudent(Model model){
         model.addAttribute("student",new Student());
        return "studentHtml/add";
    }

    @PostMapping("/sop")
    public String create(@ModelAttribute("student") Student student){
        student.setGroup(groupService.getByIdGroup(student.getGroupId()));
        studentService.saveStudent(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}/update")
    public String updateStudent(@PathVariable("id") long id,Model model){
        model.addAttribute("updateStudent",studentService.getByIdStudent(id));
        return "studentHtml/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") Student student,@PathVariable("id") long id){
        studentService.updateStudent(id,student);
        return "redirect:/student";
    }

    @DeleteMapping("/{id}")
    private String delete(@PathVariable("id") long id){
        studentService.deleteStudent(id);
        return "redirect:/student";
    }
}
