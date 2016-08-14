/**
 * 
 */
package com.qaforum.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.qaforum.bo.QaInfoBO;
import com.qaforum.bo.QaInfoSearchBO;
import com.qaforum.exception.InvalidDataException;
import com.qaforum.service.QaInfoService;
import com.qaforum.service.impl.QaInfoServiceImpl;
import com.qaforum.util.Operator;
import com.qaforum.util.SearchOption;

/**
 * @author cdacr
 *
 */
public class QaInfoServiceTest {

	private final QaInfoService qaInfoService = new QaInfoServiceImpl();

	@Test
	public void testFindSelected() {
		final QaInfoSearchBO searchBo = new QaInfoSearchBO();

		searchBo.setOperator(Operator.EQUALS.getString());
		searchBo.setSearchOption(SearchOption.QUESTION.getString());
		searchBo.setSearchValue("How to add column in existing table?");

		final List<QaInfoBO> qaInfoBos = qaInfoService.findSelected(searchBo);

		System.out.println(qaInfoBos);
		Assert.assertNotNull(qaInfoBos);
		Assert.assertTrue(qaInfoBos.size() > 0);
		Assert.assertEquals("SQL, MySQL", qaInfoBos.get(0).getType());
	}

	@Test
	public void testSave() throws InvalidDataException {
		final QaInfoBO qaBo = new QaInfoBO();
		qaBo.setQuestion("Test question?");
		qaBo.setAnswer("Test Answer");
		qaBo.setType("Test Type");

		final QaInfoBO retQaBo = qaInfoService.save(qaBo);
		Assert.assertNotNull(retQaBo);
		Assert.assertTrue(retQaBo.getQaId() != 0);
	}

	@Test
	public void testDelete() throws InvalidDataException {
		final QaInfoBO qaBo = new QaInfoBO();
		qaBo.setQuestion("Test question?");
		qaBo.setAnswer("Test Answer");
		qaBo.setType("Test Type");

		final QaInfoBO retQaBo = qaInfoService.save(qaBo);

		qaInfoService.delete(retQaBo.getQaId());

		final QaInfoSearchBO searchBo = new QaInfoSearchBO();
		searchBo.setOperator(Operator.EQUALS.getString());
		searchBo.setSearchOption(SearchOption.QUESTION_ID.getString());
		searchBo.setSearchValue(String.valueOf(retQaBo.getQaId()));

		Assert.assertTrue(qaInfoService.findSelected(searchBo).size() == 0);
	}
}
