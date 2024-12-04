package com.javaacademy.car_avito.controller;

import com.javaacademy.car_avito.announcement.Announcement;
import com.javaacademy.car_avito.service.AdStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnnouncementController {
    private final AdStorageService adStorageService;

    @PostMapping("/announcement")
    public void createAd(@RequestBody Announcement announcement) {
        adStorageService.saveAd(announcement);
    }

    @GetMapping("/announcement")
    public List<Announcement> getAllAd() {
        return adStorageService.getAllAnnouncement();
    }

    @GetMapping("/announcement/{id}")
    public Announcement findCar(@PathVariable String id) {
        return adStorageService.getAnnouncement(id).orElseThrow();
    }

    @DeleteMapping("/announcement/{id}")
    public boolean removeAd(@PathVariable String id) {
        return adStorageService.removeAnnouncement(id);
    }

    @GetMapping("/announcement/search")
    public List<Announcement> searchAds(@RequestParam(required = false) String brandName,
                                        @RequestParam(required = false) String color,
                                        @RequestParam(required = false) BigDecimal price) {
        return adStorageService.findAnnouncements(brandName, color, price);
    }
}
