package com.rh.controller;

import java.util.List;

import com.rh.entity.Absense;
import com.rh.entity.Candidate;
import com.rh.entity.Employee;
import com.rh.entity.Vacation;
import com.rh.service.CandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/all")
    	public List<Candidate>getCandidate(){
    		List<Candidate> ListCandidates =candidateService.getAllCandidates();
    		return ListCandidates;
    		
    }

   

    @PostMapping("/add")

    @ResponseBody

    public Candidate addCandidate(@RequestBody Candidate c)

    {

    	Candidate candidate = candidateService.saveCandidate(c);;

    return candidate;

    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(value = "id") long id, Model model) {
        Candidate candidate = candidateService.getCandidateById(id);

        model.addAttribute("candidate", candidate);
        model.addAttribute("vacation", new Vacation());
        model.addAttribute("absense", new Absense());
        return "candidates/details";
    }

    @PutMapping("/modify")

    @ResponseBody

    public Candidate modifycandidate(@RequestBody Candidate c) {

    return candidateService.updateCandidate(c);
    }

    @DeleteMapping("/remove/{candidate-id}")

    @ResponseBody

    public void removeCandidate(@PathVariable("candidate-id") Long id) {

    	candidateService.deleteCandidateById(id);

    }
    
    @GetMapping("/retrieve/{candidate-id}")

    @ResponseBody

    public Candidate retrieveCandidate(@PathVariable("candidate-id") Long id) {

    return candidateService.getCandidateById(id);

    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 5;

        Page<Candidate> page = candidateService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Candidate> listCandidates = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listCandidates", listCandidates);
        return "index";
    }
}
