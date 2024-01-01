package uy1.inf331.facturationservice.web;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import uy1.inf331.facturationservice.dto.FacturationDTO;
import uy1.inf331.facturationservice.services.FacturationService;

@RestController
@AllArgsConstructor
@RequestMapping("/facturation-service")
public class FacturationRestController {

    private final FacturationService facturationService;

    // @GetMapping("/facturations")
    // public List<FacturationDTO> handLeFindAll() {
    // return facturationService.findAll();
    // }

    @GetMapping("/facturations/{id}")
    public FacturationDTO handLeFindById(@PathVariable Long id) {
        return facturationService.handleFindById(id);
    }

    @PostMapping("/save")
    public FacturationDTO handLeSave(@RequestBody FacturationDTO facturationDTO) {
        return facturationService.savingFacturation(facturationDTO);
    }

}