package com.workshop.service;

import com.workshop.db.repository.PartRepositories;
import com.workshop.db.specification.Specifications;
import com.workshop.enums.PartType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.workshop.db.entity.BicyclePart;
import com.workshop.db.repository.BicyclePartRepository;

import com.workshop.db.specification.PartSpecification;
import com.workshop.enums.PartSpec;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Method;

import static com.workshop.utils.PartNamingUtils.PART_SPECIALIZATIONS;
import static com.workshop.utils.PartNamingUtils.createProductId;
import static com.workshop.utils.SerializationUtils.deserializeEntity;

/** Manages official parts */

@Service
@RequiredArgsConstructor
public class OfficialPartService {

    private final BicyclePartRepository partRepository;
    private final PartRepositories repositories;

    @SneakyThrows
    @Transactional
    public Object getOfficialParts(PartSpecification spec, Pageable pageable) {
        if (spec.getPartType() == null || spec.getPartType() == PartType.COMMON) {
            return repositories.findAllParts(spec, pageable);
        }
        return getParts(spec.getPartType(), pageable, spec);
    }

    @SneakyThrows
    @Transactional
    public BicyclePart addPart(PartType type, String partJson) {

        PartSpec spec = PART_SPECIALIZATIONS.get(type);

        Class<?> clazz = spec.getClazz();
        BicyclePart part = (BicyclePart) deserializeEntity(partJson, clazz);

        String productId = createProductId(part);
        part.setProductId(productId);
        part.setId(null);
        part.setProduct(type.getCommonName());
        part.setIsOfficial(true);

        return partRepository.save(part);
    }

    public Object getPart(PartType type, String id) {
        return partRepository.findByProductId(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Couldn't find part of type %s and if %s", type.getCommonName(), id)));
    }

    @SneakyThrows
    public Object getParts(PartType type, Pageable pageable, PartSpecification genericSpec) {
        Specification specification = Specifications.buildSpecification(genericSpec);

        Object[] parameters = {specification, pageable};
        Object repositoryInstance = repositories.getRepositoryInstance().get(type);

        Class<?> clazz = repositoryInstance.getClass();

        Method method = clazz.getMethod("findAll", Specification.class, Pageable.class);
        return method.invoke(repositoryInstance, parameters);
    }
}
