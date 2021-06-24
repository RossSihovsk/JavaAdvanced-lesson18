package spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.domain.Participant;
import spring.service.IParticipantService;

@Controller
public class ParticipantController {

	@Autowired
	private IParticipantService IParticipantService;

	@GetMapping("/")
	public String init(HttpServletRequest request) {
		request.setAttribute("participants", IParticipantService.findAll());
		request.setAttribute("mode", "VIEW");
		return "index";
	}

	@GetMapping("/new")
	public String newBook(HttpServletRequest request) {
		request.setAttribute("mode", "CREATE");
		return "index";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Participant participant, HttpServletRequest request) {
		IParticipantService.update(participant);
		request.setAttribute("participants", IParticipantService.findAll());
		request.setAttribute("mode", "VIEW");
		return "index";
	}

	@GetMapping("/update")
	public String update(@RequestParam Integer id, HttpServletRequest request) {
		request.setAttribute("participant", IParticipantService.findById(id));
		request.setAttribute("mode", "EDIT");
		return "index";
	}

	@GetMapping("/delete")
	public String deleteBook(@RequestParam Integer id, HttpServletRequest request) {
		IParticipantService.deleteById(id);
		request.setAttribute("participants", IParticipantService.findAll());
		request.setAttribute("mode", "VIEW");
		return "index";
	}
	     
}