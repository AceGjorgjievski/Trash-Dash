package com.itlabs.backend.models;

import com.itlabs.backend.models.enums.ReportStatus;
import com.itlabs.backend.models.enums.TrashType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TrashType trashType;

    @Enumerated(EnumType.STRING)
    private ReportStatus reportStatus;

    private String description;

    private LocalDateTime dateOfReport;

    @ManyToOne
    private User user;

    private Double longitude;

    private Double latitude;

    public Report() {
    }

    public Report(TrashType trashType, ReportStatus reportStatus, String description, User user, Double longitude, Double latitude) {
        this.trashType = trashType;
        this.reportStatus = reportStatus;
        this.description = description;
        this.dateOfReport = LocalDateTime.now();
        this.user = user;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
