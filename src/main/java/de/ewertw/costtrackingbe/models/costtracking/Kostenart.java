package de.ewertw.costtrackingbe.models.costtracking;

import lombok.*;

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
public class Kostenart implements Serializable {

    @Id
    private UUID id;
    private String kostenartname;
}
