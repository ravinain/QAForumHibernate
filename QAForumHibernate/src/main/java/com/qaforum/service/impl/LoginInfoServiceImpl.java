/**
 * 
 */
package com.qaforum.service.impl;

import com.qaforum.bo.LoginInfoBO;
import com.qaforum.dao.LoginInfoDAO;
import com.qaforum.dao.impl.LoginInfoDAOImpl;
import com.qaforum.service.LoginInfoService;

/**
 * @author cdacr
 *
 */
public final class LoginInfoServiceImpl implements LoginInfoService {
	/** */
	private final LoginInfoDAO loginDao = new LoginInfoDAOImpl();

	@Override
	public LoginInfoBO save(final LoginInfoBO loginBo) {
		final LoginInfoBO retLoginBo = loginDao.save(loginBo);
		return retLoginBo;
	}

	@Override
	public void delete(final String loginId) {
		loginDao.delete(loginId);
	}

	@Override
	public LoginInfoBO getLoginInfo(final String loginId) {
		final LoginInfoBO retLoginBo = loginDao.getLoginInfo(loginId);
		return retLoginBo;
	}

	@Override
	public boolean isAuthenticatedUser(final LoginInfoBO loginBo) {
		final boolean authUserFlag = loginDao.isAuthenticatedUser(loginBo);
		return authUserFlag;
	}

	@Override
	public void updateSessionId(final String loginId, final String sessionId) {
		loginDao.updateSessionId(loginId, sessionId);
	}

}
