package com.workshop.db.specification;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class Specifications {

    public static Specification buildCommonSpecification(PartSpecification spec) {
        return (Specification) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfSet(predicates, root, criteriaBuilder, "brand", spec.getBrand());
            addIfSet(predicates, root, criteriaBuilder, "model", spec.getModel());
            addIfSet(predicates, root, criteriaBuilder, "series", spec.getSeries());
            addIfSet(predicates, root, criteriaBuilder, "year", spec.getYear());
            addIfSet(predicates, root, criteriaBuilder, "product", spec.getProduct());
            addIfSet(predicates, root, criteriaBuilder, "isOfficial", true);

            Predicate[] pred = predicates.toArray(Predicate[]::new);
            return criteriaBuilder.and(pred);
        };
    }

    public static Specification buildSpecification(PartSpecification spec) {
        return (Specification) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfSet(predicates, root, criteriaBuilder, "material", spec.getMaterial());
            addIfSet(predicates, root, criteriaBuilder, "brand", spec.getBrand());
            addIfSet(predicates, root, criteriaBuilder, "model", spec.getModel());
            addIfSet(predicates, root, criteriaBuilder, "series", spec.getSeries());
            addIfSet(predicates, root, criteriaBuilder, "year", spec.getYear());
            addIfSet(predicates, root, criteriaBuilder, "size", spec.getSize());
            addIfSet(predicates, root, criteriaBuilder, "wheelSize", spec.getWheelSize());
            addIfSet(predicates, root, criteriaBuilder, "product", spec.getProduct());
            addIfSet(predicates, root, criteriaBuilder, "speeds", spec.getSpeeds());
            addIfSet(predicates, root, criteriaBuilder, "isOfficial", true);
            
            Predicate[] pred = predicates.toArray(Predicate[]::new);
            return criteriaBuilder.and(pred);
        };
    }

    private static <T> void addIfSet(final List<Predicate> predicates, final Root root, final CriteriaBuilder criteriaBuilder, String attr, T value) {
        if (isSet(value)) {
            predicates.add(criteriaBuilder.equal(root.get(attr), value));
        }
    }

    private static <T> boolean isSet(final T value) {
        return value != null;
    }
}
