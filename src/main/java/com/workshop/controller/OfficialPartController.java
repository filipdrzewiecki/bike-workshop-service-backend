package com.workshop.controller;

import com.workshop.enums.PartType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.workshop.component.BicycleTypePropertyEditor;
import com.workshop.db.entity.BicyclePart;
import com.workshop.db.specification.GenericSpecification;
import com.workshop.service.OfficialPartService;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/parts")
public class OfficialPartController {

    private final OfficialPartService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(PartType.class, new BicycleTypePropertyEditor());
    }

    @GetMapping
    public Object getUserParts(@PageableDefault(size = 20) Pageable pageable,
                               @RequestParam(required = false) PartType partType,
                               @RequestParam(required = false) String brand,
                               @RequestParam(required = false) String model,
                               @RequestParam(required = false) String series,
                               @RequestParam(required = false) String year,
                               @RequestParam(required = false) String size,
                               @RequestParam(required = false) String wheelSize,
                               @RequestParam(required = false) String material,
                               @RequestParam(required = false) String speeds) {
        GenericSpecification spec = new GenericSpecification()
                .setOfficial(true)
                .setPartType(partType)
                .setBrand(brand)
                .setModel(model)
                .setSeries(series)
                .setYear(year)
                .setSize(size)
                .setWheelSize(wheelSize)
                .setProduct(partType != null ? partType.getCommonName() : null)
                .setMaterial(material)
                .setSpeeds(speeds);
        return service.getOfficialParts(spec, pageable);
    }

    @GetMapping("/{partType}/{partId}")
    public Object fetchPart(@PathVariable PartType partType, @PathVariable String partId) {
        return service.getPart(partType, partId);
    }


    @PostMapping("/{partType}")
    @ResponseStatus(HttpStatus.CREATED)
    public BicyclePart addPart(@PathVariable PartType partType, @RequestBody String partJson) {
        return service.addPart(partType, partJson);
    }
}
