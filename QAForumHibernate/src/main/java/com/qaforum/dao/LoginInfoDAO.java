/**
 * 
 */
package com.qaforum.dao;

import com.qaforum.bo.LoginInfoBO;

/**
 * @author cdacr
 *
 */
public interface LoginInfoDAO {

	/**
	 * 
	 * @param loginBo 
	 * @return {@link LoginInfoBO}
	 */
	LoginInfoBO save(LoginInfoBO loginBo);

	/**
	 * 
	 * @param loginId 
	 */
	void delete(String loginId);

	/**
	 * 
	 * @param loginId 
	 * @return {@link LoginInfoBO}
	 */
	LoginInfoBO getLoginInfo(String loginId);

	/**
	 * 
	 * @param loginBo 
	 * @return TRUE|FALSE
	 */
	boolean isAuthenticatedUser(LoginInfoBO loginBo);

	/**
	 * Update session id again the login id in db.
	 * @param loginId 
	 * @param sessionId 
	 */
	void updateSessionId(String loginId, String sessionId);
}
