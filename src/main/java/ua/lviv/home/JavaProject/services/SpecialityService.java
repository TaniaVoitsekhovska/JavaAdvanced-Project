package ua.lviv.home.JavaProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.home.JavaProject.daos.SpecialityRepository;
import ua.lviv.home.JavaProject.domain.Speciality;

import java.util.List;

@Service
public class SpecialityService {

    private final SpecialityRepository specialityRepository;

    @Autowired

    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    public void save(Speciality speciality) {

        specialityRepository.save(speciality);
    }

    public Speciality findById(int id) {
        return specialityRepository.findById(id).orElse(null);
    }

    public List<Speciality> findAllSpecialities() {
        return specialityRepository.findAll();
    }

    public void update(String title,int enrollmentPlan, int id) {
        specialityRepository.updateSpecialityById(title,enrollmentPlan, id);
    }

    public void delete(int id) {
        specialityRepository.deleteById(id);
    }
}
