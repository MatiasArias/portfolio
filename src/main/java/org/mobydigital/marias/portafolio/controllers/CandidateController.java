package org.mobydigital.marias.portafolio.controllers;




import org.mobydigital.marias.portafolio.models.views.CandidateDto;
import org.mobydigital.marias.portafolio.services.impl.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateServiceImpl candidateService;
    @PostMapping("/create")
    public ResponseEntity<CandidateDto> createCandidato(@RequestBody CandidateDto candidate){
        return new ResponseEntity<CandidateDto>(candidateService.createCandidate(candidate), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CandidateDto>> getCandidates(){
        return new ResponseEntity<List<CandidateDto>>(candidateService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<CandidateDto> getCandidatoPorId(@PathVariable("id") Long id){
        return new ResponseEntity<CandidateDto>(candidateService.getCandidateById(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCandidate(@PathVariable Long id,@RequestBody CandidateDto candidate){
        candidateService.updateCandidate(id,candidate);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCandidate(@PathVariable("id") Long id){
        candidateService.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
