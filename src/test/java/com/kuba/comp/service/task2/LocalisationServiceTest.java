package com.kuba.comp.service.task2;

import com.kuba.comp.TasksApplication;
import com.kuba.comp.model.task2.Localisation;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TasksApplication.class)
class LocalisationServiceTest {

    @Autowired
    private ILocalisationService localisationService;

    @BeforeEach
    void prepare() {
        localisationService.save(new Localisation("123", 123, 123));
    }

    @AfterEach
    void purge() {
        List<Localisation> localisationList = localisationService.findAll();
        for (Localisation localisation : localisationList) {
            localisationService.deleteById(localisation.getId());
        }
    }

    @Test
    void testSave() {
        Localisation localisation = new Localisation("456", 456, 456);
        assertTrue(localisationService.save(localisation));
    }

    @Test
    void testSaveAll() {
        List<Localisation> localisationList = Arrays.asList(new Localisation("123", 456, 456),
                new Localisation("456", 123, 123));
        assertTrue(localisationService.saveAll(localisationList));
    }

    @Test
    void testDeleteById() {
        List<Localisation> localisationList = localisationService.findAll();
        assertTrue(localisationService.deleteById(localisationList.get(0).getId()));
    }

    @Test
    void testFindById() {
        List<Localisation> localisationList = localisationService.findAll();
        assertNotNull(localisationService.findById(localisationList.get(0).getId()));
    }

    @Test
    void testFindAll() {
        assertEquals(1, localisationService.findAll().size());
    }

    @Test
    void testFindAllByDeviceId() {
        assertEquals(1, localisationService.findAllByDeviceId("123").size());
        assertEquals(0, localisationService.findAllByDeviceId("1111").size());

    }
}