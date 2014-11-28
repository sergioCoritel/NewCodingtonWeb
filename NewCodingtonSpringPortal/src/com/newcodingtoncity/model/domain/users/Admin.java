package es.codington.model.domain.users;

public class Admin extends User {

	public Admin(int userId, String userName, String password,
			String firstName, String lastName, String dni, String email,
			String phoneNumber, String address, boolean isAdmin) {
		super(userId, userName, password, firstName, lastName, dni, email, phoneNumber,
				address, isAdmin);
	}
}
