package de.ewertw.costtrackingbe.repositories.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.Kostentraeger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface KostentraegerRepository extends JpaRepository<Kostentraeger, UUID> {
}
