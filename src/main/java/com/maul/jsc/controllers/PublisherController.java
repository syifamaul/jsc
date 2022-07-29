package com.maul.jsc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maul.jsc.dao.PublisherService;
import com.maul.jsc.models.Book;
import com.maul.jsc.models.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	@GetMapping("")
	public String viewHomePage(Model model) {
		model.addAttribute("listpublishers", publisherService.getAll());
		return "publishers/index";
	}

	@GetMapping("/new")
	public String showNewPublisherForm(Model model) {
		Publisher Publisher = new Publisher();
		model.addAttribute("Publisher", Publisher);

		return "publishers/new_publisher";
	}
	
	@PostMapping("/savePublisher")
    public String savePublisher(@ModelAttribute("Publisher") Publisher Publisher) {
		publisherService.savePublisher(Publisher);
        return "redirect:/publisher/";
    }
	
	@GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		Publisher Publisher = publisherService.getPublisherById(id);
        model.addAttribute("listpublisher", publisherService.getAll());
        model.addAttribute("Publisher", Publisher);
        return "publishers/update_publisher";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable(value = "id") long id) {

        this.publisherService.deletePublisherById(id);
        return "redirect:/publisher/";
    }
}
