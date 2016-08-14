/**
 * 
 */
package com.qaforum.service;

import com.qaforum.bo.LoginInfoBO;

/**
 * @author cdacr
 *
 */
public interface LoginInfoService {

	/**
	 * 
	 * @param loginBo 
	 * @return {@link LoginInfoBO}
	 */
	LoginInfoBO save(final LoginInfoBO loginBo);

	/**
	 * 
	 * @param loginId 
	 */
	void delete(final String loginId);

	/**
	 * 
	 * @param loginId 
	 * @return {@link LoginInfoBO}
	 */
	LoginInfoBO getLoginInfo(final String loginId);

	/**
	 * 
	 * @param loginBo 
	 * @return TRUE|FALSE
	 */
	boolean isAuthenticatedUser(final LoginInfoBO loginBo);

	/**
	 * Method updates session id again login id in DB.
	 * @param loginId 
	 * @param sessionId 
	 */
	void updateSessionId(final String loginId, final String sessionId);
}
