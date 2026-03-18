package com.recruitment.recruitment_system.controller;

import com.recruitment.recruitment_system.model.Application;
import com.recruitment.recruitment_system.service.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hr")
@CrossOrigin(origins = "https://recruitment-system-fro-git-282721-nkubitoyimanzi-8139s-projects.vercel.app/")
public class HRController {

    @Autowired
    private ApplicationService applicationService;


    @GetMapping("/applications")
    public Page<Application> getApplications(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return applicationService.getApplicationsForHR(search, page, size);
    }


    @PutMapping("/accept/{id}")
    public String acceptApplication(@PathVariable Long id) {
        applicationService.acceptApplication(id);
        return "Application accepted";
    }


    @PutMapping("/reject/{id}")
    public String rejectApplication(
            @PathVariable Long id,
            @RequestParam String reason
    ) {
        applicationService.rejectApplication(id, reason);
        return "Application rejected";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return "Application deleted";
    }
}