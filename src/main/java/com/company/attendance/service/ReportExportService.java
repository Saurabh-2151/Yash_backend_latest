package com.company.attendance.service;

import com.company.attendance.entity.Attendance;
import org.springframework.stereotype.Service;
import java.io.OutputStream;
import java.util.List;

@Service
public class ReportExportService {
    // Placeholder service: implement exporting List<Attendance> to CSV/PDF, etc.
    public void exportToCsv(List<Attendance> records, OutputStream out) {
        // Write CSV logic here
    }
    public void exportToPdf(List<Attendance> records, OutputStream out) {
        // Write PDF logic here
    }
}

