package workshop.service.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import workshop.db.entity.seatpost.Seatpost;
import workshop.db.repository.SeatpostRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class SeatpostIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SeatpostRepository seatpostRepository;

    @Test
    public void whenFindByName_thenReturnSeatpost() {
        Seatpost seatpost = new Seatpost();
        seatpost.setName("Pro 2 Alloy");
        entityManager.persist(seatpost);
        entityManager.flush();

        Seatpost found = seatpostRepository.findOneByName(seatpost.getName());

        Assertions.assertThat(found.getName()).isEqualTo(seatpost.getName());
    }
}