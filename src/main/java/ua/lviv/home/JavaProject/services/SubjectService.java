package ua.lviv.home.JavaProject.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.home.JavaProject.daos.SubjectRepository;
import ua.lviv.home.JavaProject.domain.Subject;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void save(Subject subject) {
        subjectRepository.save(subject);
        LOG.info(String.format("Successfully created new Subject with name %s. ",subject.getName()));
    }

    public Subject findSubjectById(int id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    public void deleteSubjectById(int id) {
        subjectRepository.deleteById(id);
    }

    public void updateSubject(String name, int maxGrade, int id) {
        subjectRepository.updateSubjectById(name, maxGrade, id);
        LOG.info(String.format("Successfully updated  Subject with id %d. ",id));
    }
}
