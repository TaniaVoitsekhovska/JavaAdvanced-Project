package ua.lviv.home.JavaProject.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.home.JavaProject.daos.SpecialityRepository;
import ua.lviv.home.JavaProject.domain.Speciality;
import ua.lviv.home.JavaProject.domain.Subject;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialityService {
    private static final Logger LOG = LoggerFactory.getLogger(SpecialityService.class);

    private final SpecialityRepository specialityRepository;

    @Autowired
    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    public void save(Speciality speciality, List<Subject> subjectIds) {
        LOG.info("Creating new Speciality");
        speciality.setSubjects(new ArrayList<>());
        for (Subject subjectId : subjectIds) {
            speciality.getSubjects().add(subjectId);
        }
        specialityRepository.save(speciality);
        LOG.info(String.format("Successfully created Speciality with title %s.",speciality.getTitle()));
    }

    public void deleteAllSubjects(int id){
        LOG.info(String.format("Deleting  subjects in the Speciality with id %d.", id));
        specialityRepository.deleteSubjects(id);
        LOG.info(String.format("Successfully deleted subjects in the Speciality with id %d.", id));
    }

    public Speciality findById(int id) {
        LOG.info(String.format("Getting Speciality with id %d from database.", id));
        return specialityRepository.findById(id).orElse(null);
    }

    public List<Speciality> findAllSpecialities() {
        LOG.info("Getting all specialities from database.");
        return specialityRepository.findAll();
    }

    public void update(String title, int id) {
        specialityRepository.updateSpecialityById(title, id);
    }

    public void delete(int id) {
        LOG.info(String.format("Deleting Speciality with id %d.", id));
        specialityRepository.deleteById(id);
        LOG.info(String.format("Successfully deleted Speciality with id %d.", id));
    }


}
