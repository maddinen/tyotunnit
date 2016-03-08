package fi.softala.yellow.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class MiscService {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void palveluAdmineille() {
		System.out.println("misc admineille");
	}
	
	@PreAuthorize("isAuthenticated()")
	public void palveluSisaankirjautuneille() {
		System.out.println("misc sisaankirjautuneille");
	}
	
	@PreAuthorize("permitAll")
	public void palveluKaikille() {
		System.out.println("misc kaikille");
	}

}
