package com.company.attendance.mapper;

import com.company.attendance.dto.EmployeeDto;
import com.company.attendance.entity.Department;
import com.company.attendance.entity.Designation;
import com.company.attendance.entity.Employee;
import com.company.attendance.entity.Organization;
import com.company.attendance.entity.Role;
import com.company.attendance.entity.Shift;
import com.company.attendance.entity.Team;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-03T13:31:57+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEntity(EmployeeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( dto.getId() );
        employee.userId( dto.getUserId() );
        employee.employeeId( dto.getEmployeeId() );
        employee.firstName( dto.getFirstName() );
        employee.lastName( dto.getLastName() );
        employee.email( dto.getEmail() );
        employee.phone( dto.getPhone() );
        employee.subadminId( dto.getSubadminId() );
        if ( dto.getStatus() != null ) {
            employee.status( Enum.valueOf( Employee.Status.class, dto.getStatus() ) );
        }
        employee.profileImageUrl( dto.getProfileImageUrl() );
        employee.hiredAt( dto.getHiredAt() );
        employee.terminationDate( dto.getTerminationDate() );
        employee.locationLat( dto.getLocationLat() );
        employee.locationLng( dto.getLocationLng() );
        employee.employeeCode( dto.getEmployeeCode() );
        employee.attendanceAllowed( dto.getAttendanceAllowed() );

        return employee.build();
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDto.EmployeeDtoBuilder employeeDto = EmployeeDto.builder();

        employeeDto.roleId( entityRoleId( entity ) );
        employeeDto.roleName( entityRoleName( entity ) );
        employeeDto.teamId( entityTeamId( entity ) );
        employeeDto.teamName( entityTeamName( entity ) );
        employeeDto.designationId( entityDesignationId( entity ) );
        employeeDto.designationName( entityDesignationName( entity ) );
        employeeDto.reportingManagerId( entityReportingManagerId( entity ) );
        employeeDto.organizationId( entityOrganizationId( entity ) );
        employeeDto.organizationName( entityOrganizationName( entity ) );
        employeeDto.departmentId( entityDepartmentId( entity ) );
        employeeDto.departmentName( entityDepartmentName( entity ) );
        employeeDto.shiftId( entityShiftId( entity ) );
        employeeDto.shiftName( entityShiftName( entity ) );
        employeeDto.id( entity.getId() );
        employeeDto.userId( entity.getUserId() );
        employeeDto.employeeId( entity.getEmployeeId() );
        employeeDto.firstName( entity.getFirstName() );
        employeeDto.lastName( entity.getLastName() );
        employeeDto.email( entity.getEmail() );
        employeeDto.phone( entity.getPhone() );
        employeeDto.subadminId( entity.getSubadminId() );
        if ( entity.getStatus() != null ) {
            employeeDto.status( entity.getStatus().name() );
        }
        employeeDto.profileImageUrl( entity.getProfileImageUrl() );
        employeeDto.hiredAt( entity.getHiredAt() );
        employeeDto.terminationDate( entity.getTerminationDate() );
        employeeDto.locationLat( entity.getLocationLat() );
        employeeDto.locationLng( entity.getLocationLng() );
        employeeDto.employeeCode( entity.getEmployeeCode() );
        employeeDto.attendanceAllowed( entity.getAttendanceAllowed() );

        employeeDto.reportingManagerName( entity.getReportingManager() != null ? entity.getReportingManager().getFirstName() + " " + entity.getReportingManager().getLastName() : null );

        return employeeDto.build();
    }

    @Override
    public void updateEntityFromDto(EmployeeDto dto, Employee entity) {
        if ( dto == null ) {
            return;
        }

        entity.setFirstName( dto.getFirstName() );
        entity.setLastName( dto.getLastName() );
        entity.setEmail( dto.getEmail() );
        entity.setPhone( dto.getPhone() );
        entity.setSubadminId( dto.getSubadminId() );
        if ( dto.getStatus() != null ) {
            entity.setStatus( Enum.valueOf( Employee.Status.class, dto.getStatus() ) );
        }
        else {
            entity.setStatus( null );
        }
        entity.setProfileImageUrl( dto.getProfileImageUrl() );
        entity.setHiredAt( dto.getHiredAt() );
        entity.setTerminationDate( dto.getTerminationDate() );
        entity.setLocationLat( dto.getLocationLat() );
        entity.setLocationLng( dto.getLocationLng() );
        entity.setEmployeeCode( dto.getEmployeeCode() );
        entity.setAttendanceAllowed( dto.getAttendanceAllowed() );
        entity.setCreatedBy( dto.getCreatedBy() );
        entity.setUpdatedBy( dto.getUpdatedBy() );
    }

    private Long entityRoleId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Role role = employee.getRole();
        if ( role == null ) {
            return null;
        }
        Long id = role.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityRoleName(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Role role = employee.getRole();
        if ( role == null ) {
            return null;
        }
        String name = role.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long entityTeamId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Team team = employee.getTeam();
        if ( team == null ) {
            return null;
        }
        Long id = team.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityTeamName(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Team team = employee.getTeam();
        if ( team == null ) {
            return null;
        }
        String name = team.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long entityDesignationId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Designation designation = employee.getDesignation();
        if ( designation == null ) {
            return null;
        }
        Long id = designation.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityDesignationName(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Designation designation = employee.getDesignation();
        if ( designation == null ) {
            return null;
        }
        String name = designation.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long entityReportingManagerId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Employee reportingManager = employee.getReportingManager();
        if ( reportingManager == null ) {
            return null;
        }
        Long id = reportingManager.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityOrganizationId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Organization organization = employee.getOrganization();
        if ( organization == null ) {
            return null;
        }
        Long id = organization.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityOrganizationName(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Organization organization = employee.getOrganization();
        if ( organization == null ) {
            return null;
        }
        String name = organization.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long entityDepartmentId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Department department = employee.getDepartment();
        if ( department == null ) {
            return null;
        }
        Long id = department.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityDepartmentName(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Department department = employee.getDepartment();
        if ( department == null ) {
            return null;
        }
        String name = department.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long entityShiftId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Shift shift = employee.getShift();
        if ( shift == null ) {
            return null;
        }
        Long id = shift.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityShiftName(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Shift shift = employee.getShift();
        if ( shift == null ) {
            return null;
        }
        String name = shift.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
