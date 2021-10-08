package com.kuba.comp.service.task2;

import com.kuba.comp.model.task2.Localisation;

import java.util.List;

public interface ILocalisationService {

    boolean save(Localisation localisation);

    boolean saveAll(List<Localisation> localisationList);

    boolean deleteById(Long id);

    Localisation findById(Long id);

    List<Localisation> findAll();

    List<Localisation> findAllByDeviceId(String deviceId);
}
