/**
 * 
 */
package com.qaforum.service.test;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.qaforum.bo.LoginInfoBO;
import com.qaforum.service.LoginInfoService;
import com.qaforum.service.impl.LoginInfoServiceImpl;

/**
 * @author cdacr
 *
 */
public class LoginInfoServiceTest {

	LoginInfoService loginService = new LoginInfoServiceImpl();

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testGetLoginInfo() {
		final String loginId = "a@b.com";
		final LoginInfoBO loginInfoBO = loginService.getLoginInfo(loginId);
		Assert.assertNotNull(loginInfoBO);
		Assert.assertEquals(loginId, loginInfoBO.getLoginId());
	}

	@Test
	public void testIsAuthenticatedUser() {
		final String loginId = "a@b.com";
		final String password = "test123";

		final LoginInfoBO loginInfoBO = new LoginInfoBO();
		loginInfoBO.setLoginId(loginId);
		loginInfoBO.setPassword(password);

		final boolean flag = loginService.isAuthenticatedUser(loginInfoBO);
		Assert.assertTrue(flag);
	}

	@Test
	public void testSave() {
		final LoginInfoBO loginBo = new LoginInfoBO();
		loginBo.setLoginId("test2");
		loginBo.setPassword("testpassword");

		LoginInfoBO newLoginBo = loginService
				.getLoginInfo(loginBo.getLoginId());
		if (newLoginBo != null) {
			exception.expect(ConstraintViolationException.class);
		}

		loginService.save(loginBo);

		newLoginBo = loginService.getLoginInfo(loginBo.getLoginId());

		Assert.assertEquals(loginBo.getLoginId(), newLoginBo.getLoginId());
		Assert.assertEquals(loginBo.getPassword(), newLoginBo.getPassword());
	}

	@Test
	public void testUpdateSessionId() {
		final String loginId = "test1";
		final String sessionId = "testSessionId1";

		loginService.updateSessionId(loginId, sessionId);

		final LoginInfoBO loginInfoBO = loginService.getLoginInfo(loginId);

		Assert.assertEquals(loginId, loginInfoBO.getLoginId());
	}
}
