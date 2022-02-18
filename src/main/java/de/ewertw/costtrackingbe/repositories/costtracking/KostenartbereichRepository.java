package de.ewertw.costtrackingbe.repositories.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.KostenArtBereich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KostenartbereichRepository extends JpaRepository<KostenArtBereich, UUID> {
}
