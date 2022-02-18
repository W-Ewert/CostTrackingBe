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
public class KostenBereichTraeger implements Serializable {
    @Id
    private UUID id;
    private String kostenbereichtraegername;
    @ManyToOne
    @JoinColumn(name = "kostenbereichname", referencedColumnName = "kostenbereichname")
    private Kostenbereich kostenbereich;
    @ManyToOne
    @JoinColumn(name = "kostentraegername", referencedColumnName = "kostentraegername")
    private Kostentraeger kostentraeger;
}
