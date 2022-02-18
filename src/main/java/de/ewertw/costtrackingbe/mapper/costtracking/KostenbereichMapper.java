package de.ewertw.costtrackingbe.mapper.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.Kostenbereich;
import de.ewertw.costtrackingbe.models.costtracking.Kostentraeger;
import de.ewertw.costtrackingbe.viewmodels.costtracking.KostenbereichDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.KostentraegerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KostenbereichMapper {
    List<KostenbereichDto> kostenbereichListToKostenbereichDtoList (List<Kostenbereich> kostenbereichList);
}
