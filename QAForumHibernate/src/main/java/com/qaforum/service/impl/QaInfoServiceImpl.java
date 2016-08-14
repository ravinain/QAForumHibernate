package com.qaforum.service.impl;

import java.util.List;

import com.qaforum.bo.QaInfoBO;
import com.qaforum.bo.QaInfoSearchBO;
import com.qaforum.dao.QaInfoDAO;
import com.qaforum.dao.impl.QaInfoDAOImpl;
import com.qaforum.exception.InvalidDataException;
import com.qaforum.service.QaInfoService;

/**
 * 
 * @author cdacr
 *
 */
public class QaInfoServiceImpl implements QaInfoService {

	private final QaInfoDAO infoDao = new QaInfoDAOImpl();

	@Override
	public QaInfoBO save(final QaInfoBO qaInfo) throws InvalidDataException {
		return infoDao.save(qaInfo);
	}

	@Override
	public void delete(final Long qaId) {
		infoDao.delete(qaId);
	}

	@Override
	public List<QaInfoBO> findAll() {
		return infoDao.findAll();
	}

	@Override
	public List<QaInfoBO> findSelected(final QaInfoSearchBO searchBO) {
		return infoDao.findSelected(searchBO);
	}

	@Override
	public List<QaInfoBO> saveBatch(final List<QaInfoBO> qaInfos) {
		return infoDao.saveBatch(qaInfos);
	}

}
