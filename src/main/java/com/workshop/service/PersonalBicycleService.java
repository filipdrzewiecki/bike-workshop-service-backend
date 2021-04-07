package com.workshop.service;

import java.util.List;
import java.util.stream.Collectors;

import com.workshop.config.security.entity.Profile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.workshop.db.dto.BicycleDto;
import com.workshop.db.entity.Bicycle;

import com.workshop.db.repository.BicycleRepository;

import javax.persistence.EntityNotFoundException;

/** Manages bicycles added by the user */

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalBicycleService {

    private final UserService userService;
    private final BicycleRepository repository;

    public List<BicycleDto> getAllBicycles(String userName) {
        Profile profile = userService.getUserByUserName(userName);
        List<Bicycle> bicycles = repository.findAllByProfile(profile);
        return mapToDto(bicycles);
    }

    public Bicycle getBicycle(String userName, String bicycleName) {
        Profile profile = userService.getUserByUserName(userName);

        return repository.findByNameAndProfile(StringUtils.trimAllWhitespace(bicycleName), profile)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Couldn't find the bicycle of name %s", bicycleName)));
    }

    public Bicycle addBicycle(String userName, Bicycle bicycle) {
        Profile profile = userService.getUserByUserName(userName);
        if (repository.existsByNameAndProfile(bicycle.getName(), profile)) {
            throw new IllegalArgumentException("User has already bicycle with that name");
        }
        bicycle.setProfile(profile);
        return repository.save(bicycle);
    }

    public Bicycle updateBicycle(String userName, String name, Bicycle update) {
        Bicycle bicycle = getBicycle(userName, name);
        Bicycle updatedBicycle = updateBicycleFields(bicycle, update);
        return repository.save(updatedBicycle);
    }

    public Bicycle updateBicycle(Bicycle bicycle) {
        return repository.save(bicycle);
    }

    public void deleteBicycle(String userName, String name) {
        Bicycle bicycle = getBicycle(userName, name);
        repository.deleteById(bicycle.getId());
        log.info("Deleted bicycle with name {}", name);
    }

    private List<BicycleDto> mapToDto(List<Bicycle> bicycles) {
        return bicycles.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private BicycleDto mapToDto(Bicycle bicycle) {
        return BicycleDto.builder()
                .id(bicycle.getId())
                .name(bicycle.getName())
                .type(bicycle.getType())
                .brand(bicycle.getBrand())
                .model(bicycle.getModel())
                .weight(bicycle.getPredefinedWeight() == null ? bicycle.getCountedWeight() : bicycle.getPredefinedWeight())
                .type(bicycle.getType())
                .build();
    }

    private Bicycle updateBicycleFields(Bicycle oldBicycle, Bicycle updated) {
        return oldBicycle.toBuilder()
                .brand(updated.getBrand())
                .model(updated.getModel())
                .name(updated.getName())
                .predefinedWeight(updated.getPredefinedWeight())
                .type(updated.getType())
                .year(updated.getYear())
                .build();
    }
}


