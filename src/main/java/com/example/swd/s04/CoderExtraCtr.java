package com.example.swd.s04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.swd.dao.Coder;

@Controller
@RequestMapping("/s04")
public class CoderExtraCtr {
    private static final Logger log = LogManager.getLogger(CoderExtraCtr.class);

    private CoderExtraRepo repo;

    public CoderExtraCtr(CoderExtraRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/byFirstName")
    public String byFirstName(@RequestParam String name, Model model) {
        log.traceEntry("byFirstName");

        Iterable<Coder> coders = repo.findByFirstName(name);
        model.addAttribute("message", "Found: " + coders);

        return "/s04/result";
    }

    @GetMapping("/firstNameStarting")
    public String firstNameStarting(@RequestParam String prefix, Model model) {
        log.traceEntry("firstNameStarting");

        Iterable<Coder> coders = repo.findByFirstNameStartingWith(prefix);
        model.addAttribute("message", "Found: " + coders);

        return "/s04/result";
    }
}
