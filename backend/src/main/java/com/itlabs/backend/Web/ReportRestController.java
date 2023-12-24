package com.itlabs.backend.Web;

import com.itlabs.backend.Service.ReportService;
import com.itlabs.backend.Service.UserService;
import com.itlabs.backend.models.Report;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@AllArgsConstructor
public class ReportRestController {
    private final ReportService reportService;
    private final UserService userService;

//    @GetMapping
//    public List<Report> getMapReportsPage(Model model) {
//        model.addAttribute("reports", reportService.findAll());
//        model.addAttribute("bodyContent","map-reports");
//        return "master-template";
//    }
}
