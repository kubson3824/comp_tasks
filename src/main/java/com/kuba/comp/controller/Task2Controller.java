package com.kuba.comp.controller;

import com.kuba.comp.library.task3.StripeLibrary;
import com.kuba.comp.model.task2.Localisation;
import com.kuba.comp.model.task2.LocalisationDTO;
import com.kuba.comp.service.task2.ILocalisationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/localisation")
public class Task2Controller {

    private final ILocalisationService localisationService;

    public Task2Controller(ILocalisationService localisationService) {
        this.localisationService = localisationService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getItems() {
        List<Localisation> localisations = localisationService.findAll();
        return ResponseEntity.ok(localisations);
    }

    @GetMapping(value = "/device", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getEntryFromDevice(@RequestParam String deviceId) {
        List<Localisation> localisations = localisationService.findAllByDeviceId(deviceId);
        return ResponseEntity.ok(localisations);
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> save(@RequestBody final LocalisationDTO localisation) {
        localisationService.save(new Localisation(localisation.getDeviceId(), localisation.getLatitude(), localisation.getLongitude()));
        return ResponseEntity.ok(localisation);
    }
}
