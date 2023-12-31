package com.itlabs.backend.Service.Impl;

import com.itlabs.backend.Service.ReportService;
import com.itlabs.backend.models.Report;
import com.itlabs.backend.models.User;
import com.itlabs.backend.models.enums.ReportStatus;
import com.itlabs.backend.models.enums.RoleType;
import com.itlabs.backend.models.enums.TrashType;
import com.itlabs.backend.repository.ReportRepository;
import com.itlabs.backend.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImp implements ReportService{

    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    public ReportServiceImp(ReportRepository reportRepository, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Optional<Report> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Report> save(TrashType trashType, ReportStatus reportStatus, String description, User user, Double longitude, Double latitude) {
        return Optional.empty();
    }

    @Override
    public Report save(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Optional<Report> edit(Long id, TrashType trashType, ReportStatus reportStatus, String description, User user, Double longitude, Double latitude) {
        return Optional.empty();
    }

    @Override
    public Optional<Report> edit(Long id, TrashType trashType) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Report> findReportsByUsername(String username) {
        User u = this.userRepository.findByEmail(username)
                .orElseThrow(() ->  new UsernameNotFoundException(username));
        if(u.getRole() == RoleType.USER){
            return reportRepository.findByUser(u);
        }
        return findAll();
    }
}
