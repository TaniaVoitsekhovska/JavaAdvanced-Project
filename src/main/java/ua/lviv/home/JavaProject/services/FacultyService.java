package ua.lviv.home.JavaProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.home.JavaProject.daos.FacultyRepository;
import ua.lviv.home.JavaProject.domain.Faculty;
import ua.lviv.home.JavaProject.dtos.FacultyRegisterRequest;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public void create(FacultyRegisterRequest facultyRegisterRequest) {
        Faculty faculty =new Faculty();
        faculty.setName(facultyRegisterRequest.getName());
        facultyRepository.save(faculty);
    }

    public List<Faculty> findAll(){
        return facultyRepository.findAll();
    }
}
