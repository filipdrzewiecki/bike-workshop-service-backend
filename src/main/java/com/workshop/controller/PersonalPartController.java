package com.workshop.controller;

import com.workshop.component.BicycleTypePropertyEditor;
import com.workshop.db.specification.PartSpecification;
import com.workshop.enums.PartType;
import com.workshop.service.PersonalPartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
@RequestMapping("/{userName}")
public class PersonalPartController {

    private final PersonalPartService personalPartService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(PartType.class, new BicycleTypePropertyEditor());
    }

    @GetMapping("/parts")
    public Object getUserParts(@PathVariable String userName,
                               @PageableDefault(size = 20) Pageable pageable,
                               PartSpecification spec) {
        spec.setOfficial(false);
        return personalPartService.getUserParts(spec, pageable, userName);
    }

    @GetMapping("/bicycles/{bicycleName}/{partType}")
    public Object getPartOfBicycle(@PathVariable String userName, @PathVariable String bicycleName,
                                   @PathVariable PartType partType) {
        return personalPartService.fetchBicyclePart(userName, bicycleName, partType);
    }

    @PostMapping("/bicycles/{bicycleName}/{partType}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addPartToBicycle(@PathVariable String userName, @PathVariable String bicycleName,
                                   @PathVariable PartType partType, @RequestBody String partJson) {
        return personalPartService.addPartToBicycle(userName, bicycleName, partType, partJson);
    }

    @DeleteMapping("/bicycles/{bicycleName}/{partType}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBicyclePart(@PathVariable String userName, @PathVariable String bicycleName,
                                  @PathVariable PartType partType) {
        personalPartService.deleteBicyclePart(userName, bicycleName, partType);
    }

    @PostMapping("/bicycles/{bicycleName}/{partType}/{partId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addExistingPartToBicycle(@PathVariable String userName, @PathVariable String bicycleName,
                                           @PathVariable PartType partType, @PathVariable String partId) {
        return personalPartService.addExistingPartToBicycle(userName, bicycleName, partType, partId);
    }
}
