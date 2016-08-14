/**
 * 
 */
package com.qaforum.service.impl;

import java.util.List;

import com.qaforum.bo.QaImageInfoBO;
import com.qaforum.dao.QaImageInfoDAO;
import com.qaforum.dao.impl.QaImageInfoDAOImpl;
import com.qaforum.service.QaImageInfoService;

/**
 * @author cdacr
 *
 */
public final class QaImageInfoServiceImpl implements QaImageInfoService {

	private final QaImageInfoDAO imageDao = new QaImageInfoDAOImpl();

	@Override
	public QaImageInfoBO save(final QaImageInfoBO infoBO) {
		return imageDao.save(infoBO);
	}

	@Override
	public void delete(final Long imageId) {
		imageDao.delete(imageId);
	}

	@Override
	public List<QaImageInfoBO> findAll() {
		return imageDao.findAll();
	}

	@Override
	public List<QaImageInfoBO> findSelected(final QaImageInfoBO infoBO) {
		return imageDao.findSelected(infoBO);
	}

}