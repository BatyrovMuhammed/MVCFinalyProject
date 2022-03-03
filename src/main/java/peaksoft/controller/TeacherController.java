package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Teacher;
import peaksoft.service.CourseService;
import peaksoft.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    private final CourseService courseService;

    @Autowired
    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }


    @GetMapping("/getTeacher/{id}")
    public String showTeacher(@PathVariable("id") long id, Model model ){
        model.addAttribute("showTeacher",teacherService.getByIdTeacher(id));
        return "teacherHtml/showTeacher";
    }

    @GetMapping("/{id}")
    public String getAll(@PathVariable("id")long id, Model model){
        model.addAttribute("comteacher",teacherService.getAllTeacher(id));
        model.addAttribute("courseId", id);
        return "teacherHtml/getAll";
    }
    @GetMapping("/add")
    public String addTeacher(@ModelAttribute("teacher") Teacher teacher){
        // model.addAttribute("company",new Company());
        return "teacherHtml/add";
    }

    @PostMapping("/sot")
    public String create(@ModelAttribute("teacher") Teacher teacher){
        teacher.setCourse(courseService.getByIdCourse(teacher.getCourseId()));
        teacherService.saveTeacher(teacher);
        return "redirect:/teacher";
    }

    @GetMapping("/{id}/update")
    public String updateTeacher(@PathVariable("id") long id,Model model){
        model.addAttribute("updateTeacher",teacherService.getByIdTeacher(id));
        return "teacherHtml/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("teacher") Teacher teacher,@PathVariable("id") long id){
        teacherService.updateTeacher(id,teacher);
        return "redirect:/teacher";
    }

    @DeleteMapping("/{id}")
    private String delete(@PathVariable("id") long id){
        teacherService.deleteTeacher(id);
        return "redirect:/teacher";
    }
}
