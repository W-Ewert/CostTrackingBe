package de.ewertw.costtrackingbe.viewmodels.costtracking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenutzerInsertDto {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String passwort;
}
