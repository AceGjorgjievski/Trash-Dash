package com.itlabs.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itlabs.backend.models.enums.ReportStatus;
import com.itlabs.backend.models.enums.TrashType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
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
    @JsonIgnore
    private User user;

    private Double longitude;

    private Double latitude;

    public Report() {
    }

    public Report(TrashType trashType, ReportStatus reportStatus, String description,
                  LocalDateTime dateOfReport, User user, Double longitude, Double latitude) {
        this.trashType = trashType;
        this.reportStatus = reportStatus;
        this.description = description;
        this.dateOfReport = dateOfReport;
        this.user = user;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", trashType=" + trashType +
                ", reportStatus=" + reportStatus +
                ", description='" + description + '\'' +
                ", dateOfReport=" + dateOfReport +
                ", user=" + (user != null ? user.getEmail() : "null") +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
