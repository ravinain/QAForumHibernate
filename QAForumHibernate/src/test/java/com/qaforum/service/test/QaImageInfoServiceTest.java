/**
 * 
 */
package com.qaforum.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.qaforum.bo.QaImageInfoBO;
import com.qaforum.service.QaImageInfoService;
import com.qaforum.service.impl.QaImageInfoServiceImpl;

/**
 * @author cdacr
 *
 */
public class QaImageInfoServiceTest {

	QaImageInfoService infoService = new QaImageInfoServiceImpl();

	@Test
	@Ignore
	public void testSave() {
		QaImageInfoBO infoBo = new QaImageInfoBO();
		infoBo.setQaId(new Long(1));
		infoBo.setImageType("jpg");

		infoBo = infoService.save(infoBo);
		Assert.assertTrue(infoBo.getImageId() != 0);
	}

	@Test
	public void testFindAll() {
		final List<QaImageInfoBO> infoBos = infoService.findAll();

		Assert.assertNotNull(infoBos);
		Assert.assertTrue(infoBos.size() > 0);
	}

	@Test
	public void testFindSelected() {
		final QaImageInfoBO infoBo = new QaImageInfoBO();
		infoBo.setQaId(new Long(1));

		final List<QaImageInfoBO> infoBos = infoService.findSelected(infoBo);
		Assert.assertNotNull(infoBos);
		System.out.println(infoBos);
		Assert.assertTrue(infoBos.size() > 0);
		Assert.assertEquals(new Long(56), infoBos.get(0).getImageId());
	}

	@Test
	public void testDelete() {
		QaImageInfoBO infoBo = new QaImageInfoBO();
		infoBo.setQaId(new Long(1));
		infoBo.setImageType("jpg");

		infoBo = infoService.save(infoBo);
		Assert.assertTrue(infoBo.getImageId() != 0);

		infoService.delete(infoBo.getImageId());

		final List<QaImageInfoBO> infoBo1 = infoService.findSelected(infoBo);

		Assert.assertTrue(infoBo1 == null || infoBo1.size() == 0);
	}
}
