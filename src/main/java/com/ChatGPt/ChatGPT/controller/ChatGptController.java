package com.ChatGPt.ChatGPT.controller;

import com.ChatGPt.ChatGPT.doa.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ChatGPt.ChatGPT.serviceimpl.RecordsImpl;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/chatgpt")
public class ChatGptController {
    @Autowired
    private RecordsImpl recordsimpl;
    @GetMapping("/home")
    String home(Model model )
    {
        model.addAttribute("records",new Records());
        return "Home";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Records records, Model model)
    {
        recordsimpl.createRecords(records);
        model.addAttribute("Massage","Created Successfully");

        return "Result";
    }
@GetMapping("/get")
    public String findResult(Model model)
    {
        List<Records> records=recordsimpl.getRecords();
        model.addAttribute("Result",records);
        return "Data";
    }
    @GetMapping("/id")
    public String findId(@RequestParam String id ,Model model)
    {
      Optional<Records> records=recordsimpl.findById(id);
        model.addAttribute("Result",records);
      return "IdResult";
    }
    @GetMapping("/delete/id")
    public String deleteId(@RequestParam String id ,Model model)
    {
        recordsimpl.deleteById(id);
        model.addAttribute("Massage","Deleted Successfully");
        return "Result";
    }


}
