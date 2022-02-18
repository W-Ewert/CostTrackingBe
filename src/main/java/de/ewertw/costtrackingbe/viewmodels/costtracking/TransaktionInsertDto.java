package de.ewertw.costtrackingbe.viewmodels.costtracking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaktionInsertDto {
    private String transaktionname;
    private String kostentraeger;
    private String kostenbereich;
    private String kostenart;
    private Double preis;
}
