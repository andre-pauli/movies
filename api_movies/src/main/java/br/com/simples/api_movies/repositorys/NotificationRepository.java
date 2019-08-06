package br.com.simples.api_movies.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.simples.api_movies.models.Notification;

public interface NotificationRepository extends JpaRepository<Notification, String> {

	@Query(value = "SELECT (group_users->>'descricao') as descricao " + 
			"FROM tb_user as a " + 
			"CROSS JOIN LATERAL json_array_elements (a.notifications\\:\\: json) group_users " + 
			"  inner join tb_user u on u.id = (group_users ->> 'idNotification')\\:\\: BIGINT", nativeQuery = true)
	List<Notification> findAllUsers();

}
