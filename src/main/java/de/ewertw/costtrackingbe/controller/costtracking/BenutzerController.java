package de.ewertw.costtrackingbe.controller.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.Benutzer;
import de.ewertw.costtrackingbe.services.costtracking.BenutzerService;
import de.ewertw.costtrackingbe.viewmodels.costtracking.BenutzerInsertDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.BenutzerUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/costtracking/benutzer")
public class BenutzerController {

    @Autowired
    BenutzerService benutzerService;

    @GetMapping
    public List<Benutzer> getAllBenutzer() {
        return benutzerService.getBenutzer();
    }

    @PostMapping
    public String saveBenutzer(@RequestBody BenutzerInsertDto benutzerInsertDto) {
        return benutzerService.insertBenutzerIntoDb(benutzerInsertDto);
    }

    @PutMapping
    public String updateBenutzer(@RequestBody BenutzerUpdateDto benutzerUpdateDto) {
        return benutzerService.updateBenutzerIntoDb(benutzerUpdateDto);
    }
}
