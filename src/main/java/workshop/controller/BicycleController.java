package workshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import workshop.component.BicycleTypePropertyEditor;
import workshop.db.dto.BicycleDto;
import workshop.db.entity.Bicycle;
import workshop.enums.PartType;
import workshop.service.BicycleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{userName}/bicycles")
public class BicycleController {

    private final BicycleService service;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(PartType.class, new BicycleTypePropertyEditor(PartType.class));
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
