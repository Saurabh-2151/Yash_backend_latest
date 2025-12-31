package com.company.attendance.mapper;

import com.company.attendance.dto.AttendanceDto;
import com.company.attendance.entity.Attendance;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-31T18:23:33+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AttendanceMapperImpl implements AttendanceMapper {

    @Override
    public AttendanceDto toDto(Attendance attendance) {
        if ( attendance == null ) {
            return null;
        }

        AttendanceDto attendanceDto = new AttendanceDto();

        attendanceDto.setId( attendance.getId() );
        attendanceDto.setDate( attendance.getDate() );
        attendanceDto.setPunchInTime( attendance.getPunchInTime() );
        attendanceDto.setPunchOutTime( attendance.getPunchOutTime() );
        attendanceDto.setInLocationLat( attendance.getInLocationLat() );
        attendanceDto.setInLocationLng( attendance.getInLocationLng() );
        attendanceDto.setOutLocationLat( attendance.getOutLocationLat() );
        attendanceDto.setOutLocationLng( attendance.getOutLocationLng() );
        if ( attendance.getStatus() != null ) {
            attendanceDto.setStatus( attendance.getStatus().name() );
        }
        attendanceDto.setNote( attendance.getNote() );
        attendanceDto.setDeviceInfo( attendance.getDeviceInfo() );
        attendanceDto.setIsLunchIn( attendance.getIsLunchIn() );
        attendanceDto.setIsLunchOut( attendance.getIsLunchOut() );

        return attendanceDto;
    }

    @Override
    public Attendance toEntity(AttendanceDto dto) {
        if ( dto == null ) {
            return null;
        }

        Attendance.AttendanceBuilder attendance = Attendance.builder();

        attendance.date( dto.getDate() );
        attendance.punchInTime( dto.getPunchInTime() );
        attendance.punchOutTime( dto.getPunchOutTime() );
        attendance.inLocationLat( dto.getInLocationLat() );
        attendance.inLocationLng( dto.getInLocationLng() );
        attendance.outLocationLat( dto.getOutLocationLat() );
        attendance.outLocationLng( dto.getOutLocationLng() );
        if ( dto.getStatus() != null ) {
            attendance.status( Enum.valueOf( Attendance.Status.class, dto.getStatus() ) );
        }
        attendance.note( dto.getNote() );
        attendance.deviceInfo( dto.getDeviceInfo() );
        attendance.isLunchIn( dto.getIsLunchIn() );
        attendance.isLunchOut( dto.getIsLunchOut() );

        return attendance.build();
    }
}
