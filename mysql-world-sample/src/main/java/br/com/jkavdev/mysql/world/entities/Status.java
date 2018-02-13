package br.com.jkavdev.mysql.world.entities;

import static java.util.stream.Collectors.toMap;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public enum Status {

	OFFICIAL("T", "Official"), UNOFFICIAL("F", "Unofficial");

	private static final Map<String, Status> valueMap;
	private String value;
	private String description;

	static {
		//oia, foi, mas acho que tem como melhorar
		valueMap = Collections.unmodifiableMap(
				Stream.of(Status.values())
				.collect(toMap(Status::getValue, Function.identity())));
	}

	private Status(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public static Status of(String value) {
		if (isNoneBlank(value))
			return valueMap.get(value);
		throw new IllegalArgumentException("Unknown value: " + value);
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

}
