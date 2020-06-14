package com.util;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * LocalDate�� ISO 8601 �� ��ȯ�� �ϴ� JAXB �����
 * String�� '2012-12-03' ���� ��¥�� ��Ÿ����.
 */

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.toString();
	}

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v);
	}

}