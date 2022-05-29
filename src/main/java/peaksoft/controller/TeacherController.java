package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Teacher;
import peaksoft.service.CourseService;
import peaksoft.service.TeacherService;

@Controller
@RequestMapping("/teacher/{courseId}")
public class TeacherController {

    private final TeacherService teacherService;
    private final CourseService courseService;

    @Autowired
    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }


    @GetMapping("/getTeacher/{id}")
    public String showTeacher(@PathVariable("id") long id, Model model) {
        model.addAttribute("showTeacher", teacherService.getByIdTeacher(id));
        return "teacherHtml/showTeacher";
    }

    @GetMapping
    public String getAll(@PathVariable("courseId") long id, Model model) throws Exception {
        model.addAttribute("comteacher", teacherService.getAllTeacher(id));
        model.addAttribute("courseId", id);
        return "teacherHtml/getAll";
    }

    @GetMapping("/add")
    public String addTeacher(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        model.addAttribute("courseId", teacher.getId());
        return "teacherHtml/add";
    }

    @PostMapping("/sot")
    public String create(@ModelAttribute("teacher") Teacher teacher, @ModelAttribute("courseId") long id) throws Exception {
        if (courseService.getByIdCourse(id).getTeacher() == null) {
            teacher.setCourse(courseService.getByIdCourse(teacher.getCourseId()));
            teacherService.saveTeacher(teacher);
        } else {
            throw new Exception();
        }
        return "redirect:/teacher/{courseId}";
    }

    @GetMapping("/updateTeacher/{id}")
    public String updateTeacher(@PathVariable("id") long id, Model model) {
        model.addAttribute("updateTeacher", teacherService.getByIdTeacher(id));
        return "teacherHtml/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("updateTeacher") Teacher teacher, @PathVariable("id") long id) {
        teacher.setCourse(teacherService.getByIdTeacher(id).getCourse());
        teacherService.updateTeacher(id, teacher);
        long courseId = teacherService.getByIdTeacher(id).getCourse().getId();
        return "redirect:/teacher/" + courseId;
    }

    @DeleteMapping("/deleteTeacher/{id}")
    private String delete(@PathVariable("id") long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teacher/{courseId}";
    }
}
