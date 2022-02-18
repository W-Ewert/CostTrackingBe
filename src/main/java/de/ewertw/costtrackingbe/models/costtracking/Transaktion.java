package de.ewertw.costtrackingbe.models.costtracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaktion implements Serializable {
    @Id
    private UUID id;
    private String transaktionname;
    private Timestamp tagderbezahlung;
    private Double preis;
    @ManyToOne
    @JoinColumn(name = "createdby", referencedColumnName = "email")
    private Benutzer benutzer;
    @ManyToOne
    @JoinColumn(name = "kostenartname", referencedColumnName = "kostenartname")
    private Kostenart kostenart;
    @ManyToOne
    @JoinColumn(name = "kostenbereichname", referencedColumnName = "kostenbereichname")
    private Kostenbereich kostenbereich;
    @ManyToOne
    @JoinColumn(name = "kostentraegername", referencedColumnName = "kostentraegername")
    private Kostentraeger kostentraeger;
}
