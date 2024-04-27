package com.spangler.springfreecodecamp.school;

import org.springframework.stereotype.Component;

@Component
class SchoolMapper {
    School schoolDtoToSchool(SchoolDto schoolDto) {
        return new School(schoolDto.name());
    }

    SchoolDto schoolToSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }
}
