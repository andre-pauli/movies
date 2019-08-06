package br.com.simples.api_movies.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.simples.api_movies.models.Notification;
import br.com.simples.api_movies.repositorys.NotificationRepository;

@RestController
@RequestMapping("/teste")
public class notificationController {

	@Autowired
	NotificationRepository notificationRopository;

	@GetMapping("/following")
	public List<Notification> listaAllUsers() {
		List<Notification> users = notificationRopository.findAllUsers();

		return users;
	}
}
