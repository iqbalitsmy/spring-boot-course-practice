package com.iqbaliitsmy.restapi.first_rest_api.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;

	static {
		users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(13)));
		users.add(new User(++userCount, "Eve", LocalDate.now().minusYears(5)));
		users.add(new User(++userCount, "Arham", LocalDate.now().minusYears(20)));
		users.add(new User(++userCount, "Forhad", LocalDate.now().minusYears(26)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		users.removeIf(predicate);
	}
}
