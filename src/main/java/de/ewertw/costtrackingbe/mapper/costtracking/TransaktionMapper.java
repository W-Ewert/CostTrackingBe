package de.ewertw.costtrackingbe.mapper.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.Transaktion;
import de.ewertw.costtrackingbe.viewmodels.costtracking.TransaktionDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.TransaktionInsertDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransaktionMapper {
    @Mappings({
            @Mapping(target="kostenart.kostenartname", source = "kostenart"),
            @Mapping(target="kostenbereich.kostenbereichname", source = "kostenbereich"),
            @Mapping(target="kostentraeger.kostentraegername", source = "kostentraeger")
    })
    Transaktion transaktionInsertDtoToTransaktion (TransaktionInsertDto transaktionInsertDto);
    @Mappings({
            @Mapping(target="kostenart", source = "kostenart.kostenartname"),
            @Mapping(target="kostenbereich", source = "kostenbereich.kostenbereichname"),
            @Mapping(target="kostentraeger", source = "kostentraeger.kostentraegername")
    })
    TransaktionDto transaktionToTransaktionDto (Transaktion transaktion);
}
