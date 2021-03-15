package ru.savin.minicrm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import ru.savin.minicrm.controller.LoginController;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class LoginTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private LoginController loginController;

	@Test
	public void accessDeniedTest() throws Exception {
		mockMvc.perform(get("/crm"))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("http://localhost/showMyLoginPage"));
	}

	@Test
	@Sql(value = {"/create-user-before.sql"}, executionPhase =
			Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(value = {"/create-user-after.sql"}, executionPhase =
			Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void correctLoginTest() throws Exception {
		mockMvc.perform(formLogin("/authenticateTheUser").user("alena").password("pass123"))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"));
	}

	@Test
	public void logoutTest() throws Exception {
		mockMvc.perform(logout());
	}

	@Test
	public void badCredentials() throws Exception {
		mockMvc.perform(formLogin("/authenticateTheUser").user("kolya").password("password"))
		.andDo(print())
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/showMyLoginPage?error"));
	}

}
