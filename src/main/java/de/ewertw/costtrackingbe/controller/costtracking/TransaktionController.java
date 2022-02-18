package de.ewertw.costtrackingbe.controller.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.Kostenbereich;
import de.ewertw.costtrackingbe.models.costtracking.Transaktion;
import de.ewertw.costtrackingbe.services.costtracking.TransaktionService;
import de.ewertw.costtrackingbe.viewmodels.costtracking.KostenartDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.KostenbereichDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.KostentraegerDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.TransaktionInsertDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/costtracking/transaktion")
public class TransaktionController {

    @Autowired
    TransaktionService transaktionService;

    @GetMapping
    public List<Transaktion> getAllTransaktionen() {
        return transaktionService.getTransaktionenFromDb();
    }

    @GetMapping("/kostentraeger")
    public List<KostentraegerDto> getAllKostentraeger() {
        return transaktionService.getKostentraegerFromDb();
    }

    @GetMapping("/kostenbereich")
    public List<KostenbereichDto> getKostenbereichDependsOnKostentraeger(@RequestParam String kostentraeger) {
        return transaktionService.getKostenbereichDependsOnKostentraegerFromDb(kostentraeger);
    }

    @GetMapping("/kostenart")
    public List<KostenartDto> getKostenartDependsOnKostenbereich(@RequestParam String kostenbereich) {
        return transaktionService.getKostenartDependsOnKostenbereich(kostenbereich);
    }

    @PostMapping()
    public String saveTransaction(@RequestBody TransaktionInsertDto transaktionInsertDto) {
        return transaktionService.saveTransaktionIntoDb(transaktionInsertDto);
    }
}
