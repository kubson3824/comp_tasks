package com.kuba.comp.repo.task2;

import com.kuba.comp.model.task2.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalisationRepository extends JpaRepository<Localisation, Long> {

    List<Localisation> getAllByDeviceId(String deviceId);
}
