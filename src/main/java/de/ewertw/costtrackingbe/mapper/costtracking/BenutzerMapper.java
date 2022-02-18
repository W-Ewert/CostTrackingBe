package de.ewertw.costtrackingbe.mapper.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.Benutzer;
import de.ewertw.costtrackingbe.viewmodels.costtracking.BenutzerInsertDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.BenutzerUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BenutzerMapper {
    BenutzerInsertDto benuterToBenutzerInsertDto(Benutzer benutzer);
    Benutzer benuterInsertDtoToBenutzer(BenutzerInsertDto benutzer);
    Benutzer benuterUpdateDtoToBenutzer(BenutzerUpdateDto benutzer);
}
