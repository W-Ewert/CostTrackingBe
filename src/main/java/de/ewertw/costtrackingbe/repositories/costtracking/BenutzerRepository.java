package de.ewertw.costtrackingbe.repositories.costtracking;

import de.ewertw.costtrackingbe.mapper.costtracking.BenutzerMapper;
import de.ewertw.costtrackingbe.models.costtracking.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BenutzerRepository extends JpaRepository<Benutzer, UUID> {
    Benutzer findByEmail(String email);
}
