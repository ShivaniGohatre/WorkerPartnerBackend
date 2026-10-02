package com.workerpartner.sequenceGeneration.constants;

public enum SequenceTypes {
	EMPLOYEE("EMP"), CUSTOMER("CUST");

	private final String prefix;

	SequenceTypes(String prefix) {
		this.prefix = prefix;
	}

	public String getPrefix() {
		return prefix;
	}

}
