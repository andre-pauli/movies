package br.com.simples.api_movies.repositorys;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.simples.api_movies.models.Following;
import br.com.simples.api_movies.models.User;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByEmail(String email);

	Optional<User> findById(Long id);
	
	@Query(value = "SELECT u.name, " + 
			"(group_users->>'text') " + 
			"FROM tb_user as a " + 
			"CROSS JOIN LATERAL json_array_elements (a.notifications\\:\\: json) group_users" + 
			"  inner join tb_user u on u.id = (group_users ->> 'idNotification')\\:\\: BIGINT " + 
			"where a.id = 1", nativeQuery = true)
	List<Following> findAllUsers();
	
	@Query(value = "SELECT (group_users->>'id')\\:\\:integer as id, u.name " + "FROM tb_user as a "
			+ "CROSS JOIN LATERAL json_array_elements (a.friends\\:\\:json) group_users "
			+ "  inner join tb_user u on u.id = (group_users->> 'id')\\:\\:BIGINT "
			+ "where a.id = ?1", nativeQuery = true)
	List<Following> findUsersFollowing(int id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE tb_user a SET friends = friends#-('{' || ( " + "   select i "
			+ "   from generate_series(0, jsonb_array_length(a.friends) - 1) as i "
			+ "   where (a.friends->i->>'id')\\:\\:BIGINT = ?1 " + ") || '}')\\:\\:text[] "
			+ "where a.id = ?2", nativeQuery = true)
	public void removeFollowing(Integer idRemove, Integer idUser);

	@Transactional
	@Modifying
	@Query(value = "UPDATE tb_user SET friends = friends||('{\"id\":\"'||?1||'\"}' )\\:\\:jsonb "
			+ "WHERE id = ?2", nativeQuery = true)
	void addFollowing(Integer idAdd, Integer idUser);

}
