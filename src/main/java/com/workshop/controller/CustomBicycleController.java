package com.workshop.controller;

import com.workshop.component.BicycleTypePropertyEditor;
import com.workshop.enums.PartType;
import com.workshop.service.CustomBicycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.workshop.db.dto.BicycleDto;
import com.workshop.db.entity.Bicycle;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{userName}/bicycles")
public class CustomBicycleController {

    private final CustomBicycleService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(PartType.class, new BicycleTypePropertyEditor());
    }

    @GetMapping
    @PreAuthorize("@userAuthorizationService.isUserAuthorized(#userName, authentication)")
    public List<BicycleDto> getAllBicycles(@PathVariable String userName) {
        return service.getAllBicycles(userName);
    }

    @GetMapping("/{bicycleName}")
    @PreAuthorize("@userAuthorizationService.isUserAuthorized(#userName, authentication)")
    public Bicycle getBicycle(@PathVariable String userName, @PathVariable String bicycleName) {
        return service.getBicycle(userName, bicycleName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("@userAuthorizationService.isUserAuthorized(#userName, authentication)")
    public Bicycle addBicycle(@PathVariable String userName, @RequestBody Bicycle bicycle) {
        return service.addBicycle(userName, bicycle);
    }

    @PutMapping("/{bicycleName}")
    @PreAuthorize("@userAuthorizationService.isUserAuthorized(#userName, authentication)")
    public Bicycle updateBicycle(@PathVariable String userName, @PathVariable String bicycleName, @RequestBody Bicycle bicycle) {
        return service.updateBicycle(userName, bicycleName, bicycle);
    }

    @DeleteMapping("/{bicycleName}")
    @PreAuthorize("@userAuthorizationService.isUserAuthorized(#userName, authentication)")
    public void updateBicycle(@PathVariable String userName, @PathVariable String bicycleName) {
        service.deleteBicycle(userName, bicycleName);
    }

}
