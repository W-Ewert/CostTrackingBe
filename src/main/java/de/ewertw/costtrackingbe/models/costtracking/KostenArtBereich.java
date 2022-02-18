package de.ewertw.costtrackingbe.models.costtracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KostenArtBereich implements Serializable {
    @Id
    private UUID id;
    private String kostenartbereichname;
    @ManyToOne
    @JoinColumn(name = "kostenartname", referencedColumnName = "kostenartname")
    private Kostenart kostenart;
    @ManyToOne
    @JoinColumn(name = "kostenbereichname", referencedColumnName = "kostenbereichname")
    private Kostenbereich kostenbereich;
}
