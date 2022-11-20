package service;

import entity.Report;

import java.util.List;

public interface ReportService {
    List<Report> getAllReport();
    Report getReportById(long id);
    boolean updateReport(Report report);
    boolean saveReport(Report report);
    void deleteReport(Report report);
}

