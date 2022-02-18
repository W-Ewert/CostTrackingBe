package de.ewertw.costtrackingbe.mapper.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.Kostenart;
import de.ewertw.costtrackingbe.models.costtracking.Kostenbereich;
import de.ewertw.costtrackingbe.viewmodels.costtracking.KostenartDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.KostenbereichDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KostenartMapper {
    List<KostenartDto> kostenartListToKostenartDtoList (List<Kostenart> kostenartList);
}
