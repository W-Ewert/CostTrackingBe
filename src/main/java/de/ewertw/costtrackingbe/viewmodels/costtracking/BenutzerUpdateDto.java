package de.ewertw.costtrackingbe.viewmodels.costtracking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenutzerUpdateDto {
    private String firstname;
    private String lastname;
    private String email;
}
