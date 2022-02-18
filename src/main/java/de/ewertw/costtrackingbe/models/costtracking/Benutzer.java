package de.ewertw.costtrackingbe.models.costtracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Benutzer implements Serializable {
    @Id
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String passwort;
}
