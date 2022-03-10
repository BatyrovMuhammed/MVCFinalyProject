package peaksoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Course;
import peaksoft.entity.Group;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;
import peaksoft.service.GroupService;

import java.util.List;

@Controller
@RequestMapping("/group/{courseId}")
public class GroupController {

    private final GroupService groupService;
    private final CourseService courseService;
//      private  final CompanyService companyService;

    @Autowired
    public GroupController(GroupService groupService, CourseService courseService ) {
        this.groupService = groupService;
        this.courseService = courseService;

    }
    @GetMapping("/getGroup/{id}")
    public String showGroup(@PathVariable("id") long id, Model model ){
        model.addAttribute("showGroup",groupService.getByIdGroup(id));
        return "groupHtml/showGroup";
    }

    @GetMapping
    public String getAll(@PathVariable("courseId")Long id, Model model){
        model.addAttribute("comgroup",groupService.getAllGroup(id));
        model.addAttribute("groupId",id);
        return "groupHtml/getAll";
//        @PathVariable("id")long id,
    }
    @GetMapping("/add")
    public String newGroup(Model model){
         model.addAttribute("group",new Group());
        return "groupHtml/add";
    }

    @PostMapping("/sob")
    public String create(@ModelAttribute("group") Group group){
//        group.setCourses( companyService.getByIdCompany(id).getCourses());
        group.setCourse1(courseService.getByIdCourse(group.getCourseId()));
        groupService.saveGroup(group);
        return "redirect:/group/{courseId}";
    }

    @GetMapping("/updateGroup/{id}")
    public String updateGroup(@PathVariable("id") Long id,Model model){
        model.addAttribute("updateGroup",groupService.getByIdGroup(id));
        return "groupHtml/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("updateGroup") Group group,@PathVariable("id") Long id){
        groupService.updateGroup(id,group);
        long courseId =groupService.getByIdGroup(id).course2().getId();
        return "redirect:/group/"+1;
    }

    @DeleteMapping("/deleteGroup/{id}")
    private String delete(@PathVariable("id") Long id){
        groupService.deleteGroup(id);
        return "redirect:/group/{courseId}";
    }
}
