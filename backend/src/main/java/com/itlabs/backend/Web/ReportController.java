package com.itlabs.backend.Web;

import com.itlabs.backend.Service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping
    public String getReportsPage(Model model) {
        model.addAttribute("bodyContent","reports");

        return "master-template";
    }


}