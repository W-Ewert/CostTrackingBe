package de.ewertw.costtrackingbe.mapper.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.Transaktion;
import de.ewertw.costtrackingbe.viewmodels.costtracking.TransaktionDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.TransaktionInsertDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransaktionMapper {
    Transaktion transaktionInsertDtoToTransaktion (TransaktionInsertDto transaktionInsertDto);
    TransaktionDto transaktionToTransaktionDto (Transaktion transaktion);
}
