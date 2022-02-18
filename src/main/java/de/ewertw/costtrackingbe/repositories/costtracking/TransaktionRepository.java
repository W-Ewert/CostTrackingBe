package de.ewertw.costtrackingbe.repositories.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.Transaktion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransaktionRepository extends JpaRepository<Transaktion, UUID> {
}
