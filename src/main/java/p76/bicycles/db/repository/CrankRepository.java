package p76.bicycles.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import p76.bicycles.db.entity.Pedals;
import p76.bicycles.db.entity.drivetrain.Crank;
import p76.bicycles.db.entity.drivetrain.FrontDerailleur;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "crank", path = "crank")
public interface CrankRepository extends PagingAndSortingRepository<Crank, Long> {

    List<Crank> findByName(@Param("name") String name);

    boolean existsByProductId (String productId);

    Optional<Crank> findByProductId (String productId);

}