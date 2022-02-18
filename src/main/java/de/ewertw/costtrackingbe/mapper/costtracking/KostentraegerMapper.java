package de.ewertw.costtrackingbe.mapper.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.Kostentraeger;
import de.ewertw.costtrackingbe.viewmodels.costtracking.KostentraegerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KostentraegerMapper {
    Kostentraeger kostentraegerDtoToKostentraeger (KostentraegerDto kostentraegerDto);
    KostentraegerDto kostentraegerToKostentraegerDto (Kostentraeger kostentraeger);
    List<KostentraegerDto> kostentraegerListToKostentraegerDtoList (List<Kostentraeger> kostentraegerList);
}
