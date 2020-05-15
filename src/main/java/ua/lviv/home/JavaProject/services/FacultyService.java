package ua.lviv.home.JavaProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.home.JavaProject.daos.FacultyRepository;
import ua.lviv.home.JavaProject.domain.Faculty;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public void create(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public List<Faculty> findAll(){
        return facultyRepository.findAll();
    }
}
