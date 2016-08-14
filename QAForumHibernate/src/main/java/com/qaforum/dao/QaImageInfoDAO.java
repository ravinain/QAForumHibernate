package com.qaforum.dao;

import java.util.List;

import com.qaforum.bo.QaImageInfoBO;

/**
 * 
 * @author cdacr
 *
 */
public interface QaImageInfoDAO {

	/**
	 * 
	 * @param infoBO 
	 * @return {@link QaImageInfoBO} object 
	 */
	QaImageInfoBO save(QaImageInfoBO infoBO);

	/**
	 * 
	 * @param imageId 
	 */
	void delete(Long imageId);

	/**
	 * 
	 * @return List of all {@link QaImageInfoBO} 
	 */
	List<QaImageInfoBO> findAll();

	/**
	 * 
	 * @param infoBO 
	 * @return List of filtered {@link QaImageInfoBO}
	 */
	List<QaImageInfoBO> findSelected(QaImageInfoBO infoBO);
}
