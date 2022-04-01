package com.jrp.pma.controllers;


import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired //give responsibility to spring to inject an auto created instance without our input
    ProjectRepository proRepo;

    @RequestMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project();

        model.addAttribute("project", aProject);

        return "new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        //this should handle saving to database...
         proRepo.save(project);

         //use a redirect whenever save to a db to prevent duplicates!!!
        return "redirect:/projects/new ";
    }


}
