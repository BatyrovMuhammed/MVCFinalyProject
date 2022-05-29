package peaksoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Course;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;
import peaksoft.service.GroupService;

@Controller
@RequestMapping("/course/{companyId}")
public class CourseController {

    private final CourseService courseService;
    private final CompanyService companyService;

    @Autowired
    public CourseController(CourseService courseService, CompanyService companyService, GroupService groupService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @GetMapping
    public String getAll(@PathVariable("companyId") Long id, Model model) {
        model.addAttribute("comcourse", courseService.getAllCourse(id));
        model.addAttribute("companyId", id);
        return "courseHtml/getAll";
    }

    @GetMapping("/add")
    public String newCourse(Model model) {
        model.addAttribute("course", new Course());
        return "courseHtml/add";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("course") Course course) {

        course.setCompany(companyService.getByIdCompany(course.getCompanyId()));
//        course.setGroups((List<Group>) groupService.getByIdGroup(course.getGroupId()));
        courseService.saveCourse(course);
        return "redirect:/course/{companyId}";
    }


    @GetMapping("/getCourse/{id}")
    public String showCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("showCourse", courseService.getByIdCourse(id));
        return "courseHtml/showCourse";
    }

    @GetMapping("/updateCourse/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("updateCourse", courseService.getByIdCourse(id));
        return "courseHtml/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("updateCourse") Course course, @PathVariable("id") long id) {
        course.setCompany(courseService.getByIdCourse(id).getCompany());
        courseService.updateCourse(id, course);
        long companyId = courseService.getByIdCourse(id).getCompany().getId();
        return "redirect:/course/" + companyId;
    }

    @DeleteMapping("/deleteCourse/{id}")
    private String delete(@PathVariable("id") long id) {
        courseService.deleteCourse(id);
        return "redirect:/course/{companyId}";
    }
}
