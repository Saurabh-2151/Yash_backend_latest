package com.company.attendance.controller;

// Temporarily disabled to fix compilation issues
// import com.company.attendance.dto.AttendanceDto;
// import com.company.attendance.service.AttendanceService;
// import jakarta.servlet.http.HttpServletResponse;
// import lombok.RequiredArgsConstructor;
// import org.springframework.format.annotation.DateTimeFormat;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import java.io.IOException;
// import java.time.LocalDate;
// import java.util.List;

// @RestController
// @RequestMapping("/api/reports")
// @RequiredArgsConstructor
// public class ReportsController {
//     // private final AttendanceService attendanceService;
//     // // You may inject report exporter PDF/CSV helpers as well

//     // @GetMapping("/attendance")
//     // public void exportAttendanceReport(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
//     //                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
//     //                                    @RequestParam(required = false) Long teamId,
//     //                                    @RequestParam(defaultValue = "csv") String format,
//     //                                    HttpServletResponse response) throws IOException {
//     //     if ("pdf".equalsIgnoreCase(format)) {
//     //         // TODO: Export logic to PDF
//     //         response.setContentType("application/pdf");
//     //         response.setHeader("Content-Disposition", "attachment; filename=attendance-report.pdf");
//     //         // Generate and stream PDF (use JasperReports/iText etc.)
//     //     } else {
//     //         // TODO: Export logic to CSV
//     //         response.setContentType("text/csv");
//     //         response.setHeader("Content-Disposition", "attachment; filename=attendance-report.csv");
//     //         // Generate and stream CSV
//     //     }
//     // }

//     // @GetMapping("/salary")
//     // public ResponseEntity<?> exportSalaryReport(@RequestParam String month,
//     //                                             @RequestParam(required = false) Long teamId) {
//     //     // TODO: Implement salary calculation/export
//     //     return ResponseEntity.ok("Salary report would be generated here");
//     // }
// }
