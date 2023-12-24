package com.itlabs.backend.Web;

import com.itlabs.backend.Service.ReportService;
import com.itlabs.backend.Service.UserService;
import com.itlabs.backend.models.Report;
import com.itlabs.backend.models.User;
import com.itlabs.backend.models.enums.ReportStatus;
import com.itlabs.backend.models.enums.RoleType;
import com.itlabs.backend.models.enums.TrashType;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class ReportController {

    private final ReportService reportService;
    private final UserService userService;

    @GetMapping
    public String getMapReportsPage(Model model) {
        model.addAttribute("reports", reportService.findAll());
        model.addAttribute("bodyContent","map-reports");
        return "master-template";
    }

    @GetMapping("/createReport")
    public String getCreateReportPage(Model model) {
        model.addAttribute("bodyContent","createReport");
        model.addAttribute("trashTypes", TrashType.values());
        return "master-template";
    }

    @PostMapping("/createReport")
    public String addReport(@RequestParam String trashType,
                            @RequestParam String description,
                            @RequestParam String lat,
                            @RequestParam String lng,
                            HttpServletRequest request) {

        // Get the active user from the session
        HttpSession session = request.getSession();
//        String username = session.getAttribute("user").toString();
        String username = request.getRemoteUser();
        User user = null;

        try {
            user = this.userService.findUserByEmail(username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Save the report with the obtained user information
        this.reportService.save(new Report(TrashType.valueOf(trashType), ReportStatus.ACTIVE,
                description, LocalDateTime.now(), user, Double.parseDouble(lng), Double.parseDouble(lat)));

        return "redirect:/";
    }
}
