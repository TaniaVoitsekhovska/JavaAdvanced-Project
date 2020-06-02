package ua.lviv.home.JavaProject.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.home.JavaProject.daos.FacultyRepository;
import ua.lviv.home.JavaProject.domain.Faculty;

import java.util.List;

@Service
public class FacultyService {
    private static final Logger LOG = LoggerFactory.getLogger(FacultyService.class);
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public void save(Faculty faculty) {
        facultyRepository.save(faculty);
        LOG.info(String.format("Successfully created/updated Faculty with name %s ",faculty.getName()));

    }

    public Faculty findFacultyById(int id){
        LOG.info(String.format("Getting Faculty with id %d from database ",id));
        return facultyRepository.findById(id).orElse(null);
    }

    public List<Faculty> findAll(){
        LOG.info("Getting all faculties from database");
        return facultyRepository.findAll();
    }

    public void deleteFaculty(int id){
        facultyRepository.deleteById(id);
        LOG.info(String.format("Successfully deleted Faculty with id %d ",id));
    }

    public void updateFaculty(int id, Faculty faculty){
        facultyRepository.deleteById(id);
        facultyRepository.save(faculty);
    }
}
