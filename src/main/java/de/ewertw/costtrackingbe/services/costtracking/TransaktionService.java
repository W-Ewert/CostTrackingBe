package de.ewertw.costtrackingbe.services.costtracking;

import com.sun.istack.Nullable;
import de.ewertw.costtrackingbe.mapper.costtracking.KostenartMapper;
import de.ewertw.costtrackingbe.mapper.costtracking.KostenbereichMapper;
import de.ewertw.costtrackingbe.mapper.costtracking.KostentraegerMapper;
import de.ewertw.costtrackingbe.mapper.costtracking.TransaktionMapper;
import de.ewertw.costtrackingbe.models.costtracking.*;
import de.ewertw.costtrackingbe.repositories.costtracking.KostenartRepository;
import de.ewertw.costtrackingbe.repositories.costtracking.KostenbereichRepository;
import de.ewertw.costtrackingbe.repositories.costtracking.KostentraegerRepository;
import de.ewertw.costtrackingbe.repositories.costtracking.TransaktionRepository;
import de.ewertw.costtrackingbe.viewmodels.costtracking.KostenartDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.KostenbereichDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.KostentraegerDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.TransaktionInsertDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TransaktionService {

    @Autowired
    KostenartRepository kostenartRepository;
    @Autowired
    KostentraegerRepository kostentraegerRepository;
    @Autowired
    KostenbereichRepository kostenbereichRepository;
    @Autowired
    TransaktionRepository transaktionRepository;
    @Autowired
    KostentraegerMapper kostentraegerMapper;
    @Autowired
    KostenbereichMapper kostenbereichMapper;
    @Autowired
    KostenartMapper kostenartMapper;
    @Autowired
    TransaktionMapper transaktionMapper;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Kostenart> getKostenartenFromDb(){
        return kostenartRepository.findAll();
    }

    public List<KostentraegerDto> getKostentraegerFromDb(){
        List<Kostentraeger> kostentraegerList =  kostentraegerRepository.findAll();
        if (kostentraegerList != null || !kostentraegerList.isEmpty()) {
            return kostentraegerMapper.kostentraegerListToKostentraegerDtoList(kostentraegerList);
        } else {
            return List.of(null);
        }
    }

    public List<KostenbereichDto> getKostenbereichDependsOnKostentraegerFromDb(String kostentraeger) {
        String sql = "select kostenbereich.kostenbereichname \n" +
                "from Kostenbereich\n" +
                "inner join Kostenbereichtraeger on kostenbereichtraeger.KostenbereichName = Kostenbereich.Kostenbereichname\n" +
                "inner join Kostentraeger on Kostentraeger.KostentraegerName = Kostenbereichtraeger.KostentraegerName\n" +
                "where Kostentraeger.Kostentraegername = ?;";
        List<Kostenbereich> kostenbereichList = jdbcTemplate.query(sql,new Object[] {kostentraeger}, new BeanPropertyRowMapper<>(Kostenbereich.class));
        return kostenbereichMapper.kostenbereichListToKostenbereichDtoList(kostenbereichList);
    }

    public List<KostenartDto> getKostenartDependsOnKostenbereich(String kostenbereich) {
        String sql = "select Kostenart.Kostenartname \n" +
                "from Kostenart\n" +
                "inner join Kostenartbereich on Kostenartbereich.KostenartName = Kostenart.Kostenartname\n" +
                "inner join Kostenbereich on Kostenbereich.KostenbereichName = Kostenartbereich.KostenbereichName\n" +
                "where Kostenbereich.Kostenbereichname = ?;";
        List<Kostenart> kostenartList = jdbcTemplate.query(sql, new Object[] {kostenbereich}, new BeanPropertyRowMapper<>(Kostenart.class));
        return kostenartMapper.kostenartListToKostenartDtoList(kostenartList);
    }

    public String saveTransaktionIntoDb(TransaktionInsertDto transaktionInsertDto) {
        String message = "";
        if(transaktionInsertDto != null) {
            Transaktion transaktionToSave = transaktionMapper.transaktionInsertDtoToTransaktion(transaktionInsertDto);
            transaktionToSave.setId(UUID.randomUUID());
            transaktionToSave.setTagderbezahlung(new Timestamp(new Date().getTime()));

        }
        return message;
    }

    public List<Transaktion> getTransaktionenFromDb() {return transaktionRepository.findAll(); }
}
