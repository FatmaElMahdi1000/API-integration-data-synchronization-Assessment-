package com.example.varthakassesment.Mapper;

import com.example.varthakassesment.DTO.External.ExCompanyDTO;
import com.example.varthakassesment.DTO.External.ExUserDTO;
import com.example.varthakassesment.Model.Company;
import com.example.varthakassesment.Model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-11T05:34:01+0300",
    comments = "version: 1.7.0.Beta2, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public void MapExUserToEntity(ExUserDTO ExternalUserDTO, User user) {
        if ( ExternalUserDTO == null ) {
            return;
        }

        user.setExternalUserId( ExternalUserDTO.getId() );
        user.setExternalCreatedAt( ExternalUserDTO.getCreatedAt() );
        user.setExternalUpdatedAt( ExternalUserDTO.getUpdatedAt() );
        if ( ExternalUserDTO.getCompany() != null ) {
            if ( user.getCompany() == null ) {
                user.setCompany( new Company() );
            }
            exCompanyDTOToCompany( ExternalUserDTO.getCompany(), user.getCompany() );
        }
        else {
            user.setCompany( null );
        }
        user.setName( ExternalUserDTO.getName() );
        user.setEmail( ExternalUserDTO.getEmail() );
        user.setPhone( ExternalUserDTO.getPhone() );
    }

    protected void exCompanyDTOToCompany(ExCompanyDTO exCompanyDTO, Company mappingTarget) {
        if ( exCompanyDTO == null ) {
            return;
        }

        mappingTarget.setIndustry( exCompanyDTO.getIndustry() );
        mappingTarget.setWebsite( exCompanyDTO.getWebsite() );
    }
}
