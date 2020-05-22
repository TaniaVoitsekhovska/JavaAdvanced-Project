package ua.lviv.home.JavaProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.home.JavaProject.daos.SpecialityRepository;
import ua.lviv.home.JavaProject.domain.Speciality;
import ua.lviv.home.JavaProject.domain.Subject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SpecialityService {

    private final SpecialityRepository specialityRepository;

    @Autowired

    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    public void save(Speciality speciality, List<Subject> subjectIds) {
        speciality.setSubjects(new ArrayList<>());
        for (Subject subjectId : subjectIds) {
            speciality.getSubjects().add(subjectId);
        }
        specialityRepository.save(speciality);
    }

    public void deleteAllSubjects(int id){
        specialityRepository.deleteSubjects(id);
    }

    public Speciality findById(int id) {
        return specialityRepository.findById(id).orElse(null);
    }

    public List<Speciality> findAllSpecialities() {
        return specialityRepository.findAll();
    }

    public void update(String title, int id) {
        specialityRepository.updateSpecialityById(title, id);
    }

    public void delete(int id) {
        specialityRepository.deleteById(id);
    }


}
