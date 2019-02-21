package personApi.utilidades;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncode {

  public static void main(String[] args) {
		String password = "admin";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);
		password = "user";
		hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);
		
		password = "ana";
		hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);
		
		
	}
  }

