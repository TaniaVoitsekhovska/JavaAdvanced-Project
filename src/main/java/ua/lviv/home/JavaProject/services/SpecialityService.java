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

    public List<Speciality> findAllSpecialities() {
        return specialityRepository.findAll();
    }
}
