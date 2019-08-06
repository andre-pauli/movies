package br.com.simples.api_movies.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.simples.api_movies.models.Following;
import br.com.simples.api_movies.models.Notification;
import br.com.simples.api_movies.repositorys.NotificationRepository;
import br.com.simples.api_movies.repositorys.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UsersController {

	@Autowired
	UserRepository userRopository;

	@Autowired
	NotificationRepository notificationRopository;

	@GetMapping("/following")
	public String listaAllUsers() {
		List<Notification> users = userRopository.findAllUsers();

		System.out.println(users);
		
		return "Olá Mundo";
	}

	@GetMapping("/{idUser}/following")
	public List<Following> listaFriendsFollowing(@PathVariable(value = "idUser") int idUser) {
		List<Following> users = userRopository.findUsersFollowing(idUser);

		return users;
	}

	@GetMapping("/{idUser}/following/remove/{idRemove}")
	public String removeFollowing(@PathVariable(value = "idRemove") Integer idRemove,
			@PathVariable(value = "idUser") Integer idUser) {
		userRopository.removeFollowing(idRemove, idUser);

		return "Usuário apagado com sucesso";
	}

	@GetMapping("/{idUser}/following/add/{idAdd}")
	public String addFollowing(@PathVariable(value = "idAdd") Integer idAdd,
			@PathVariable(value = "idUser") Integer idUser) {
		userRopository.addFollowing(idAdd, idUser);

		return "Usuário adicionado com sucesso";
	}
}
