package com.workshop.db.specification;

import com.workshop.enums.PartType;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class SpecificationUtils {

    public Specification prepareSpecification(PartType type, GenericSpecification spec) {
        switch (type) {
            case FRAME:
                return buildSpecification(spec);
            case FORK:
                return buildSpecification(spec);
            default:
                return null;
        }
    }

    private static Specification buildSpecification(GenericSpecification spec) {
        return (Specification) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addIfSet(predicates, root, criteriaBuilder, "brand", spec.getBrand());
            addIfSet(predicates, root, criteriaBuilder, "model", spec.getModel());
            addIfSet(predicates, root, criteriaBuilder, "series", spec.getSeries());
            addIfSet(predicates, root, criteriaBuilder, "year", spec.getYear());
            addIfSet(predicates, root, criteriaBuilder, "size", spec.getSize());
            addIfSet(predicates, root, criteriaBuilder, "wheelSize", spec.getWheelSize());
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
