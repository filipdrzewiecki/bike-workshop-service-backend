package com.workshop.controller;

import com.workshop.component.BicycleTypePropertyEditor;
import com.workshop.enums.PartType;
import com.workshop.service.CustomPartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/{userName}/bicycles/{bicycleName}/{partType}")
public class CustomPartController {

    private final CustomPartService customPartService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(PartType.class, new BicycleTypePropertyEditor());
    }

    @GetMapping
    public Object getPartOfBicycle(@PathVariable String userName, @PathVariable String bicycleName,
                                   @PathVariable PartType partType) {
        return customPartService.fetchBicyclePart(userName, bicycleName, partType);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object addPartToBicycle(@PathVariable String userName, @PathVariable String bicycleName,
                                   @PathVariable PartType partType, @RequestBody String partJson) {
        return customPartService.addPartToBicycle(userName, bicycleName, partType, partJson);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteBicyclePart(@PathVariable String userName, @PathVariable String bicycleName,
                                  @PathVariable PartType partType) {
        customPartService.deleteBicyclePart(userName, bicycleName, partType);
    }

    @PostMapping("/{partId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addExistingPartToBicycle(@PathVariable String userName, @PathVariable String bicycleName,
                                           @PathVariable PartType partType, @PathVariable String partId) {
        return customPartService.addExistingPartToBicycle(userName, bicycleName, partType, partId);
    }
}
