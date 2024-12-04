package com.javaacademy.car_avito.service;

import com.javaacademy.car_avito.announcement.Announcement;
import com.javaacademy.car_avito.announcement.UniqueIdentifier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class AdStorageService {
    private final UniqueIdentifier uniqueIdentifier;
    private final Map<String, Announcement> storageService = new HashMap<>();

    public void saveAd(Announcement announcement) {
        announcement.setId(uniqueIdentifier.generateNumber());
        storageService.put(announcement.getId(), announcement);
        log.info("Объявление №{} успешно добавлено", announcement.getId());
    }

    public List<Announcement> getAllAnnouncement() {
        return new ArrayList<>(storageService.values());
    }

    public Optional<Announcement> getAnnouncement(String id) {
        return Optional.ofNullable(storageService.get(id));
    }

    public boolean removeAnnouncement(String id) {
        return storageService.remove(id) != null;
    }

    public List<Announcement> findAnnouncements(String brandName, String color, BigDecimal price) {
        return storageService.values().stream()
                .filter(ad -> (brandName == null || ad.getBrandName().equalsIgnoreCase(brandName))
                        && (color == null || ad.getColor().equalsIgnoreCase(color))
                        && (price == null || ad.getPrice().compareTo(price) == 0)).collect(Collectors.toList());
    }
}
