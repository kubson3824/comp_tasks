package com.kuba.comp.service.task2;

import com.kuba.comp.model.task2.Localisation;
import com.kuba.comp.repo.task2.LocalisationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalisationService implements ILocalisationService {

    private final LocalisationRepository repo;

    public LocalisationService(LocalisationRepository repo) {
        this.repo = repo;
    }

    @Override
    public boolean save(Localisation localisation) {
        repo.save(localisation);
        return true;
    }

    @Override
    public boolean saveAll(List<Localisation> localisationList) {
        repo.saveAll(localisationList);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }

    @Override
    public Localisation findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Localisation> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Localisation> findAllByDeviceId(String deviceId) {
        return repo.getAllByDeviceId(deviceId);
    }
}
