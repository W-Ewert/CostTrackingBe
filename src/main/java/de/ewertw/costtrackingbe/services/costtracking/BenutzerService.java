package de.ewertw.costtrackingbe.services.costtracking;

import de.ewertw.costtrackingbe.mapper.costtracking.BenutzerMapper;
import de.ewertw.costtrackingbe.models.costtracking.Benutzer;
import de.ewertw.costtrackingbe.models.testing.Car;
import de.ewertw.costtrackingbe.repositories.costtracking.BenutzerRepository;
import de.ewertw.costtrackingbe.viewmodels.costtracking.BenutzerInsertDto;
import de.ewertw.costtrackingbe.viewmodels.costtracking.BenutzerUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BenutzerService {

    @Autowired
    BenutzerRepository benutzerRepository;
    @Autowired
    BenutzerMapper benutzerMapper;

    public List<Benutzer> getBenutzer(){
        return benutzerRepository.findAll();
    }

    public String insertBenutzerIntoDb(BenutzerInsertDto newBenutzer) {
        String msg = "Benutzer ist erfolgreich hinzugefügt";
        try {
            Benutzer benutzerToSave = benutzerMapper.benuterInsertDtoToBenutzer(newBenutzer);
            benutzerToSave.setId(UUID.randomUUID());
            if (exists(benutzerToSave)){
                msg = "Failed. Customer with E-mail: " + newBenutzer.getEmail() + "is already exists";
            }else if (newBenutzer.getEmail().equals("") || newBenutzer.getEmail().isEmpty()){
                msg = "Failed. Email is empty";
            }else{
                benutzerRepository.save(benutzerToSave);
                msg = "Ok. Customer was successfully saved";
            }
            return (msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg = e.getMessage();
            return msg;
        }
    }

    public String updateBenutzerIntoDb(BenutzerUpdateDto updateBenutzer){
        String msg;
        try{
            Benutzer benutzerToSave = benutzerMapper.benuterUpdateDtoToBenutzer(updateBenutzer);
            if (exists(benutzerToSave)){
                benutzerToSave.setId(benutzerRepository.findByEmail(updateBenutzer.getEmail()).getId());
                benutzerToSave.setPasswort(benutzerRepository.findByEmail(updateBenutzer.getEmail()).getPasswort());
                benutzerToSave.setPhone(benutzerRepository.findByEmail(updateBenutzer.getEmail()).getPhone());
                benutzerRepository.save(benutzerToSave);
                msg = "Ok. Customer was successfully updated";
            }else{
                msg = "Failed. Customer with E-mail: " + updateBenutzer.getEmail() + " not exists in DB";
            }
            return msg;
        }catch (Exception e) {
            e.printStackTrace();
            msg = e.getMessage();
            return msg;
        }
    }

    private boolean exists(Benutzer benutzer){
        Benutzer benutzerDb = benutzerRepository.findByEmail(benutzer.getEmail());
        if (benutzerDb != null){
            return true;
        }else{
            return false;
        }
    }
}
