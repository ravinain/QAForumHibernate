/**
 * 
 */
package com.qaforum.dao.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.qaforum.bo.LoginInfoBO;
import com.qaforum.dao.LoginInfoDAO;
import com.qaforum.util.HibernateUtil;

/**
 * @author cdacr
 *
 */
public class LoginInfoDAOImpl implements LoginInfoDAO {
	private final Logger logger = Logger.getLogger(LoginInfoDAOImpl.class
			.getName());

	/* (non-Javadoc)
	 * @see com.qaforum.dao.LoginInfoDAO#save(com.qaforum.bo.LoginInfoBO)
	 */
	@Override
	public LoginInfoBO save(final LoginInfoBO loginBo) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.save(loginBo);
			trans.commit();
		} catch (final Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
		return loginBo;
	}

	/* (non-Javadoc)
	 * @see com.qaforum.dao.LoginInfoDAO#delete(java.lang.String)
	 */
	@Override
	public void delete(final String loginId) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		final Transaction trans = session.beginTransaction();
		try {
			final LoginInfoBO loginBo = (LoginInfoBO) session.get(
					LoginInfoBO.class, loginId);
			session.delete(loginBo);
			trans.commit();
		} catch (final Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
			trans.rollback();
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.qaforum.dao.LoginInfoDAO#getLoginInfo(java.lang.String)
	 */
	@Override
	public LoginInfoBO getLoginInfo(final String loginId) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		final Transaction trans = session.beginTransaction();
		LoginInfoBO loginBo = null;
		try {
			loginBo = (LoginInfoBO) session.get(LoginInfoBO.class, loginId);
			trans.commit();
		} catch (final Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
			trans.rollback();
		} finally {
			session.close();
		}
		return loginBo;
	}

	/* (non-Javadoc)
	 * @see com.qaforum.dao.LoginInfoDAO#isAuthenticatedUser(com.qaforum.bo.LoginInfoBO)
	 */
	@Override
	public boolean isAuthenticatedUser(final LoginInfoBO loginBo) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		boolean authUserFlag = false;
		try {
			trans = session.beginTransaction();
			final Criteria criteria = session.createCriteria(LoginInfoBO.class)
					.add(Restrictions.eq("loginId", loginBo.getLoginId()))
					.add(Restrictions.eq("password", loginBo.getPassword()));
			authUserFlag = criteria.list().size() > 0;
			trans.commit();
		} catch (final Exception ex) {
			trans.rollback();
		} finally {
			session.close();
		}
		return authUserFlag;
	}

	/* (non-Javadoc)
	 * @see com.qaforum.dao.LoginInfoDAO#updateSessionId(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateSessionId(final String loginId, final String sessionId) {
		final LoginInfoBO loginBo = this.getLoginInfo(loginId);
		loginBo.setSessionId(sessionId);
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.saveOrUpdate(loginBo);
			trans.commit();
		} catch (final Exception ex) {
			trans.rollback();
		} finally {
			session.close();
		}
	}

}
