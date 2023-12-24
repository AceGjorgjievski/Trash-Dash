package com.itlabs.backend.Service;

import com.itlabs.backend.models.Report;
import com.itlabs.backend.models.User;
import com.itlabs.backend.models.enums.ReportStatus;
import com.itlabs.backend.models.enums.TrashType;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReportService {
    List<Report> findAll();

    Optional<Report> findById(Long id);


    void deleteById(Long id);
}
