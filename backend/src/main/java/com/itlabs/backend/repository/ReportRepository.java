package com.itlabs.backend.repository;

import com.itlabs.backend.models.Report;
import com.itlabs.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
    List<Report> findByUser(User user);
}
