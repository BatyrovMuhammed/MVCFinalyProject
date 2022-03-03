package peaksoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.service.CompanyService;

@Controller
@RequestMapping("/com")
public class MyController {

   private final CompanyService companyService;

    @Autowired
    public MyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    public String showCompany(@PathVariable("id") long id,Model model ){
        model.addAttribute("showCompany",companyService.getByIdCompany(id));
        return "com/show";
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("comcompany",companyService.getAllCompany());
        return "com/index";
    }
    @GetMapping("/new")
    public String newCom(@ModelAttribute("company") Company company){
       // model.addAttribute("company",new Company());
        return "com/new";
    }

    @PostMapping("/sod")
    public String create(@ModelAttribute("company") Company company){
        companyService.saveCompany(company);
        return "redirect:/com";
    }

    @GetMapping("/{id}/edit")
    public String editCompany(@PathVariable("id") long id,Model model){
        model.addAttribute( "editCompany",companyService.getByIdCompany(id));
        return "com/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("company") Company company,@PathVariable("id") long id){
        companyService.updateCompany(id,company);
        return "redirect:/com";
    }

    @DeleteMapping("/{id}")
    private String delete(@PathVariable("id") long id){
        companyService.deleteCompany(id);
        return "redirect:/com";
    }
}
