package com.spangler.springfreecodecamp.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto createSchool(SchoolDto schoolDto) {
        School school = schoolMapper.schoolDtoToSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }

    public List<SchoolDto> getAllSchools() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::schoolToSchoolDto)
                .collect(Collectors.toList());
    }
}
