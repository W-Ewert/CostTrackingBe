package de.ewertw.costtrackingbe.repositories.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.Kostenart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KostenartRepository extends JpaRepository<Kostenart, UUID> {
}
