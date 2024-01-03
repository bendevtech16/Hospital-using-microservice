package uy1.inf331.facturationservice.web;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import uy1.inf331.facturationservice.dto.FacturationDTO;
import uy1.inf331.facturationservice.services.FacturationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@AllArgsConstructor
@RequestMapping("/facturation-service")
public class FacturationRestController {

    private final FacturationService facturationService;

    @GetMapping("/facturations")
    public List<FacturationDTO> handLeFindAll() {
        return facturationService.findAll();
    }

    @GetMapping("/facturations/{id}")
    public FacturationDTO handLeFindById(@PathVariable Long id) {
        return facturationService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void handLeDeleById(@PathVariable Long id) {
        facturationService.deleteById(id);
    }

    @PutMapping("update/{id}")
    public FacturationDTO handleUpdate(@PathVariable long id, @RequestBody FacturationDTO facturationDTO) {
        return facturationService.update(id, facturationDTO);
    }

    @PostMapping("/save")
    public FacturationDTO handLeSave(@RequestBody FacturationDTO facturationDTO) {
        return facturationService.savingFacturation(facturationDTO);
    }

}