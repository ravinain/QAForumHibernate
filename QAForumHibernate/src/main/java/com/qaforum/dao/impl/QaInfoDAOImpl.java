package com.qaforum.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.qaforum.bo.QaInfoBO;
import com.qaforum.bo.QaInfoSearchBO;
import com.qaforum.dao.QaInfoDAO;
import com.qaforum.util.HibernateUtil;
import com.qaforum.util.Operator;
import com.qaforum.util.SearchOption;

public class QaInfoDAOImpl implements QaInfoDAO {

	private final Logger logger = Logger.getLogger(QaInfoDAOImpl.class
			.getName());

	@Override
	public QaInfoBO save(final QaInfoBO qaInfo) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.saveOrUpdate(qaInfo);
			trans.commit();
		} catch (final Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
		return qaInfo;
	}

	@Override
	public void delete(final Long qaId) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		final Transaction trans = session.beginTransaction();
		try {
			final QaInfoBO qaInfoBO = (QaInfoBO) session.get(QaInfoBO.class,
					qaId);
			session.delete(qaInfoBO);
			trans.commit();
		} catch (final Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
			trans.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public List<QaInfoBO> findAll() {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		final Transaction trans = session.beginTransaction();
		List<QaInfoBO> qaInfoBos = null;
		try {
			qaInfoBos = session.createCriteria(QaInfoBO.class).list();
			trans.commit();
		} catch (final Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
			trans.rollback();
		} finally {
			session.close();
		}
		return qaInfoBos;
	}

	@Override
	public List<QaInfoBO> findSelected(final QaInfoSearchBO searchBO) {
		List<QaInfoBO> qaInfos = null;
		try {
			if (searchBO.getSearchOption().equals(
					SearchOption.QUESTION_ID.toString())) {
				qaInfos = findByQuestionId(searchBO);
			} else if (searchBO.getSearchOption().equals(
					SearchOption.QUESTION.toString())) {
				qaInfos = findByQuestion(searchBO);
			} else if (searchBO.getSearchOption().equals(
					SearchOption.ANSWER.toString())) {
				qaInfos = findByAnswer(searchBO);
			} else if (searchBO.getSearchOption().equals(
					SearchOption.TYPE.toString())) {
				qaInfos = findByType(searchBO);
			}
		} catch (final Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return qaInfos;
	}

	/**
	 * Method filter the data in question id column based on input filter value.
	 * @param searchBO 
	 * @return List of QaInfoBO
	 */
	private List<QaInfoBO> findByQuestionId(final QaInfoSearchBO searchBO) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		List<QaInfoBO> qaInfoBOs = null;
		try {
			trans = session.beginTransaction();
			final Criteria criteria = session.createCriteria(QaInfoBO.class);
			final Long qaId = Long.valueOf(searchBO.getSearchValue());
			if (searchBO.getOperator().equals(Operator.EQUALS.getString())) {
				criteria.add(Restrictions.eq("qaId", qaId));
			} else if (searchBO.getOperator().equals(
					Operator.GREATER_THAN.getString())) {
				criteria.add(Restrictions.gt("qaId", qaId));
			} else if (searchBO.getOperator().equals(
					Operator.LESS_THAN.getString())) {
				criteria.add(Restrictions.lt("qaId", qaId));
			}
			qaInfoBOs = criteria.list();
			trans.commit();
		} catch (final Exception ex) {
			trans.rollback();
		} finally {
			session.close();
		}

		return qaInfoBOs;
	}

	/**
	 * Method filter the data in question column based on input filter value.
	 * @param searchBO 
	 * @return List of QaInfoBO
	 */
	private List<QaInfoBO> findByQuestion(final QaInfoSearchBO searchBO) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		List<QaInfoBO> qaInfoBOs = null;
		try {
			trans = session.beginTransaction();
			final Criteria criteria = session.createCriteria(QaInfoBO.class);
			final String operator = searchBO.getOperator();
			if (operator.equals(Operator.EQUALS.getString())) {
				criteria.add(Restrictions.eq("question",
						searchBO.getSearchValue()));
			} else if (operator.equals(Operator.STARTS_WITH.getString())) {
				criteria.add(Restrictions.like("question",
						"%" + searchBO.getSearchValue()));
			} else if (operator.equals(Operator.ENDS_WITH.getString())) {
				criteria.add(Restrictions.like("question",
						searchBO.getSearchValue() + "%"));
			} else if (operator.equals(Operator.CONTAINS.getString())) {
				criteria.add(Restrictions.like("question",
						"%" + searchBO.getSearchValue() + "%"));
			}
			qaInfoBOs = criteria.list();
			trans.commit();
		} catch (final Exception ex) {
			trans.rollback();
		} finally {
			session.close();
		}

		return qaInfoBOs;
	}

	/**
	 * Method filter the data in answer column based on input filter value.
	 * @param searchBO 
	 * @return List of QaInfoBO
	 */
	private List<QaInfoBO> findByAnswer(final QaInfoSearchBO searchBO) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		List<QaInfoBO> qaInfoBOs = null;
		try {
			trans = session.beginTransaction();
			final Criteria criteria = session.createCriteria(QaInfoBO.class);
			final String operator = searchBO.getOperator();
			if (operator.equals(Operator.EQUALS.getString())) {
				criteria.add(Restrictions.eq("answer",
						searchBO.getSearchValue()));
			} else if (operator.equals(Operator.STARTS_WITH.getString())) {
				criteria.add(Restrictions.like("answer",
						"%" + searchBO.getSearchValue()));
			} else if (operator.equals(Operator.ENDS_WITH.getString())) {
				criteria.add(Restrictions.like("answer",
						searchBO.getSearchValue() + "%"));
			} else if (operator.equals(Operator.CONTAINS.getString())) {
				criteria.add(Restrictions.like("answer",
						"%" + searchBO.getSearchValue() + "%"));
			}
			qaInfoBOs = criteria.list();
			trans.commit();
		} catch (final Exception ex) {
			trans.rollback();
		} finally {
			session.close();
		}

		return qaInfoBOs;
	}

	/**
	 * Method filter the data in type column based on input filter value.
	 * @param searchBO 
	 * @return List of QaInfoBO
	 */
	private List<QaInfoBO> findByType(final QaInfoSearchBO searchBO) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		List<QaInfoBO> qaInfoBOs = null;
		try {
			trans = session.beginTransaction();
			final Criteria criteria = session.createCriteria(QaInfoBO.class);
			final String operator = searchBO.getOperator();
			if (operator.equals(Operator.EQUALS.getString())) {
				criteria.add(Restrictions.eq("type", searchBO.getSearchValue()));
			} else if (operator.equals(Operator.STARTS_WITH.getString())) {
				criteria.add(Restrictions.like("type",
						"%" + searchBO.getSearchValue()));
			} else if (operator.equals(Operator.ENDS_WITH.getString())) {
				criteria.add(Restrictions.like("type",
						searchBO.getSearchValue() + "%"));
			} else if (operator.equals(Operator.CONTAINS.getString())) {
				criteria.add(Restrictions.like("type",
						"%" + searchBO.getSearchValue() + "%"));
			}
			qaInfoBOs = criteria.list();
			trans.commit();
		} catch (final Exception ex) {
			trans.rollback();
		} finally {
			session.close();
		}

		return qaInfoBOs;
	}

	@Override
	public List<QaInfoBO> saveBatch(final List<QaInfoBO> qaInfos) {
		// TODO Auto-generated method stub
		return null;
	}

}
