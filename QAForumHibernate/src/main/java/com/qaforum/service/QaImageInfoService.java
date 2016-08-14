package com.qaforum.service;

import java.util.List;

import com.qaforum.bo.QaImageInfoBO;

/**
 * 
 * @author cdacr
 *
 */
public interface QaImageInfoService {

	/** */
	String QA_IMG_LKP = "java:global/RestTest/QaImageInfoBean";

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
