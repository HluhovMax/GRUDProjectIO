package mvc.controller;

import mvc.model.Developer;
import mvc.repository.DeveloperRepository;
import mvc.repository.JavaIODeveloperRepositoryImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Hluhov on 23.10.2018.
 */
public class DeveloperController {
    private DeveloperRepository developerRepository;
    private Developer developer;
    private List<Developer> developerList;

    public DeveloperController() {
        developerRepository = new JavaIODeveloperRepositoryImpl();
        developer = new Developer();
        developerList = new ArrayList<>();
    }

    public void saveToDeveloperRepo(Developer developer) {
        if (developer != null) {
            try {
                developerRepository.save(developer);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateToDeveloperRepo(Developer developer) {
        if (developer != null) {
            try {
                developerRepository.update(developer);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteFromDeveloperRepo(Long id) {
        if (id != 0) {
            try {
                developerRepository.delete(id);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Developer getByIdFromDeveloperRepo(Long id) {
        if (id != 0) {
            try {
                developer = developerRepository.getById(id);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
        return developer;
    }

    public List<Developer> getAll() {
        try {
            developerList = developerRepository.getAll();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return developerList;
    }
}
