package com.company.attendance.mapper;

import com.company.attendance.dto.OrganizationDto;
import com.company.attendance.entity.Organization;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-03T13:32:00+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public Organization toEntity(OrganizationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Organization.OrganizationBuilder organization = Organization.builder();

        organization.name( dto.getName() );
        organization.code( dto.getCode() );
        organization.description( dto.getDescription() );
        organization.logo( dto.getLogo() );
        organization.address( dto.getAddress() );
        organization.city( dto.getCity() );
        organization.state( dto.getState() );
        organization.country( dto.getCountry() );
        organization.pincode( dto.getPincode() );
        organization.contactEmail( dto.getContactEmail() );
        organization.contactPhone( dto.getContactPhone() );
        organization.website( dto.getWebsite() );
        organization.industry( dto.getIndustry() );
        organization.timezone( dto.getTimezone() );
        organization.dateFormat( dto.getDateFormat() );
        organization.timeFormat( dto.getTimeFormat() );
        organization.currency( dto.getCurrency() );
        organization.taxId( dto.getTaxId() );
        organization.registrationNumber( dto.getRegistrationNumber() );
        organization.fiscalYearStart( dto.getFiscalYearStart() );
        organization.fiscalYearEnd( dto.getFiscalYearEnd() );
        organization.primaryColor( dto.getPrimaryColor() );
        organization.secondaryColor( dto.getSecondaryColor() );
        organization.isActive( dto.getIsActive() );

        return organization.build();
    }

    @Override
    public OrganizationDto toDto(Organization entity) {
        if ( entity == null ) {
            return null;
        }

        OrganizationDto.OrganizationDtoBuilder<?, ?> organizationDto = OrganizationDto.builder();

        organizationDto.createdAt( entity.getCreatedAt() );
        organizationDto.updatedAt( entity.getUpdatedAt() );
        organizationDto.id( entity.getId() );
        organizationDto.createdBy( entity.getCreatedBy() );
        organizationDto.updatedBy( entity.getUpdatedBy() );
        organizationDto.name( entity.getName() );
        organizationDto.code( entity.getCode() );
        organizationDto.logo( entity.getLogo() );
        organizationDto.address( entity.getAddress() );
        organizationDto.city( entity.getCity() );
        organizationDto.state( entity.getState() );
        organizationDto.country( entity.getCountry() );
        organizationDto.pincode( entity.getPincode() );
        organizationDto.contactEmail( entity.getContactEmail() );
        organizationDto.contactPhone( entity.getContactPhone() );
        organizationDto.website( entity.getWebsite() );
        organizationDto.industry( entity.getIndustry() );
        organizationDto.description( entity.getDescription() );
        organizationDto.timezone( entity.getTimezone() );
        organizationDto.dateFormat( entity.getDateFormat() );
        organizationDto.timeFormat( entity.getTimeFormat() );
        organizationDto.currency( entity.getCurrency() );
        organizationDto.taxId( entity.getTaxId() );
        organizationDto.registrationNumber( entity.getRegistrationNumber() );
        organizationDto.fiscalYearStart( entity.getFiscalYearStart() );
        organizationDto.fiscalYearEnd( entity.getFiscalYearEnd() );
        organizationDto.primaryColor( entity.getPrimaryColor() );
        organizationDto.secondaryColor( entity.getSecondaryColor() );
        organizationDto.isActive( entity.getIsActive() );

        return organizationDto.build();
    }

    @Override
    public List<OrganizationDto> toDtoList(List<Organization> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrganizationDto> list = new ArrayList<OrganizationDto>( entities.size() );
        for ( Organization organization : entities ) {
            list.add( toDto( organization ) );
        }

        return list;
    }

    @Override
    public void updateOrganizationFromDto(OrganizationDto dto, Organization entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getCode() != null ) {
            entity.setCode( dto.getCode() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getLogo() != null ) {
            entity.setLogo( dto.getLogo() );
        }
        if ( dto.getAddress() != null ) {
            entity.setAddress( dto.getAddress() );
        }
        if ( dto.getCity() != null ) {
            entity.setCity( dto.getCity() );
        }
        if ( dto.getState() != null ) {
            entity.setState( dto.getState() );
        }
        if ( dto.getCountry() != null ) {
            entity.setCountry( dto.getCountry() );
        }
        if ( dto.getPincode() != null ) {
            entity.setPincode( dto.getPincode() );
        }
        if ( dto.getContactEmail() != null ) {
            entity.setContactEmail( dto.getContactEmail() );
        }
        if ( dto.getContactPhone() != null ) {
            entity.setContactPhone( dto.getContactPhone() );
        }
        if ( dto.getWebsite() != null ) {
            entity.setWebsite( dto.getWebsite() );
        }
        if ( dto.getIndustry() != null ) {
            entity.setIndustry( dto.getIndustry() );
        }
        if ( dto.getTimezone() != null ) {
            entity.setTimezone( dto.getTimezone() );
        }
        if ( dto.getDateFormat() != null ) {
            entity.setDateFormat( dto.getDateFormat() );
        }
        if ( dto.getTimeFormat() != null ) {
            entity.setTimeFormat( dto.getTimeFormat() );
        }
        if ( dto.getCurrency() != null ) {
            entity.setCurrency( dto.getCurrency() );
        }
        if ( dto.getTaxId() != null ) {
            entity.setTaxId( dto.getTaxId() );
        }
        if ( dto.getRegistrationNumber() != null ) {
            entity.setRegistrationNumber( dto.getRegistrationNumber() );
        }
        if ( dto.getFiscalYearStart() != null ) {
            entity.setFiscalYearStart( dto.getFiscalYearStart() );
        }
        if ( dto.getFiscalYearEnd() != null ) {
            entity.setFiscalYearEnd( dto.getFiscalYearEnd() );
        }
        if ( dto.getPrimaryColor() != null ) {
            entity.setPrimaryColor( dto.getPrimaryColor() );
        }
        if ( dto.getSecondaryColor() != null ) {
            entity.setSecondaryColor( dto.getSecondaryColor() );
        }
        if ( dto.getIsActive() != null ) {
            entity.setIsActive( dto.getIsActive() );
        }
    }
}
