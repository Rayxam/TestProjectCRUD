package ru.testproject.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.testproject.spring.dao.PersonDAO;

@Controller
@RequestMapping("/test-batch-update")
public class BatchController {
    private PersonDAO personDAO;

    @Autowired
    public BatchController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index() {
        return "/batch/index";
    }

    @GetMapping("withuot")
    public String withuotBatch() {
        personDAO.testMultipleUpdate();
        return "redirect:/people";
    }

    @GetMapping("with")
    public String withBatch() {
        personDAO.testBatchUpdate();
        return "redirect:/people";
    }
}
