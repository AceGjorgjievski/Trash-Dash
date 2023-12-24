package com.itlabs.backend.Web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/createReport")
@AllArgsConstructor
public class createReportController {

    @GetMapping
    public String getCreateReportPage(Model model) {
        model.addAttribute("bodyContent","createReport");

        return "master-template";
    }
}
