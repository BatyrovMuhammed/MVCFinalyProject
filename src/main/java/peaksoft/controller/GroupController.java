package peaksoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Course;
import peaksoft.entity.Group;
import peaksoft.service.CourseService;
import peaksoft.service.GroupService;

import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;
//    private final CourseService courseService;

    @Autowired
    public GroupController(GroupService groupService, CourseService courseService) {
        this.groupService = groupService;
    }



    @GetMapping("/{id}")
    public String showGroup(@PathVariable("id") long id, Model model ){
        model.addAttribute("showGroup",groupService.getByIdGroup(id));
        return "groupHtml/showGroup";
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("comgroup",groupService.getAllGroup());
        return "groupHtml/getAll";
    }
    @GetMapping("/add")
    public String newGroup(@ModelAttribute("group") Group group){
        // model.addAttribute("company",new Company());
        return "groupHtml/add";
    }

    @PostMapping("/sob")
    public String create(@ModelAttribute("group") Group group){
//        group.setCourses((List<Course>) courseService.getByIdCourse(group.getCourseId()));
        groupService.saveGroup(group);
        return "redirect:/group";
    }

    @GetMapping("/{id}/update")
    public String updateGroup(@PathVariable("id") long id,Model model){
        model.addAttribute("updateGroup",groupService.getByIdGroup(id));
        return "groupHtml/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("group") Group group,@PathVariable("id") long id){
        groupService.updateGroup(id,group);
        return "redirect:/group";
    }

    @DeleteMapping("/{id}")
    private String delete(@PathVariable("id") long id){
        groupService.deleteGroup(id);
        return "redirect:/group";
    }
}
