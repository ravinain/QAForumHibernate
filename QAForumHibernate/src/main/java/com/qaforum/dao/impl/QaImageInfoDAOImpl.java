/**
 * 
 */
package com.qaforum.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.qaforum.bo.QaImageInfoBO;
import com.qaforum.dao.QaImageInfoDAO;
import com.qaforum.util.HibernateUtil;

/**
 * @author cdacr
 *
 */
public class QaImageInfoDAOImpl implements QaImageInfoDAO {

	private final Logger logger = Logger.getLogger(getClass().getName());

	/* (non-Javadoc)
	 * @see com.qaforum.dao.QaImageInfoDAO#save(com.qaforum.bo.QaImageInfoBO)
	 */
	@Override
	public QaImageInfoBO save(final QaImageInfoBO infoBO) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(infoBO);
			tx.commit();
		} catch (final Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
			tx.rollback();
		} finally {
			session.close();
		}
		return infoBO;
	}

	/* (non-Javadoc)
	 * @see com.qaforum.dao.QaImageInfoDAO#delete(java.lang.Long)
	 */
	@Override
	public void delete(final Long imageId) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			final QaImageInfoBO infoBo = (QaImageInfoBO) session.get(
					QaImageInfoBO.class, imageId);
			session.delete(infoBo);
			tx.commit();
		} catch (final Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
			tx.rollback();
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.qaforum.dao.QaImageInfoDAO#findAll()
	 */
	@Override
	public List<QaImageInfoBO> findAll() {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<QaImageInfoBO> infoBos = null;
		try {
			tx = session.beginTransaction();
			infoBos = session.createCriteria(QaImageInfoBO.class).list();
			tx.commit();
		} catch (final Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
			tx.rollback();
		} finally {
			session.close();
		}
		return infoBos;
	}

	/* (non-Javadoc)
	 * @see com.qaforum.dao.QaImageInfoDAO#findSelected(com.qaforum.bo.QaImageInfoBO)
	 */
	@Override
	public List<QaImageInfoBO> findSelected(final QaImageInfoBO infoBO) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<QaImageInfoBO> infoBos = null;
		try {
			tx = session.beginTransaction();
			final Criteria criteria = session
					.createCriteria(QaImageInfoBO.class);
			if (infoBO.getImageId() != null) {
				criteria.add(Restrictions.eq("imageId", infoBO.getImageId()));
			}
			if (infoBO.getQaId() != null) {
				criteria.add(Restrictions.eq("qaId", infoBO.getQaId()));
			}
			infoBos = criteria.list();
			tx.commit();
		} catch (final Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
			tx.rollback();
		} finally {
			session.close();
		}
		return infoBos;
	}
}
