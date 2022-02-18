package de.ewertw.costtrackingbe.controller.costtracking;

import de.ewertw.costtrackingbe.models.costtracking.Kostenart;
import de.ewertw.costtrackingbe.services.costtracking.TransaktionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/costtracking/kostenart")
public class KostenartController {

    @Autowired
    TransaktionService transaktionService;

    @GetMapping
    public List<Kostenart> getAllKostenarten() {
        return transaktionService.getKostenartenFromDb();
    }
}
