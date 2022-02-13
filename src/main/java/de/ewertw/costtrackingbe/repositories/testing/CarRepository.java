package de.ewertw.costtrackingbe.repositories.testing;

import de.ewertw.costtrackingbe.models.testing.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
