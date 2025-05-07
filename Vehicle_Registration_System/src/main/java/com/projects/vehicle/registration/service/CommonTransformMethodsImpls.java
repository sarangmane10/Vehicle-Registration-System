package com.projects.vehicle.registration.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.persistence.Tuple;
import jakarta.persistence.TupleElement;

@Service
public class CommonTransformMethodsImpls implements CommonTranformMethods {

	@Override
	public @NonNull List<Map<String, Object>> transformResultToMap(@NonNull List<Tuple> tuples) {

		if (tuples == null)
			throw new IllegalArgumentException("Tuples cannot be null");

		List<Map<String, Object>> result = new ArrayList<>(tuples.size());
		for (Tuple tuple : tuples) {

			Map<String, Object> map = new HashMap<>(tuple.getElements().size());
			// Iterate over the elements in the tuple and populate the map
			tuple.getElements().forEach(element -> map.put(element.getAlias(), tuple.get(element.getAlias())));
			result.add(map);

		}

		return result;

	}

	@Override
	public Map<String, Object> transformResultToMap(Tuple tuple) {
		if (tuple == null)
			return null;

		return tuple.getElements().stream().collect(Collectors.toMap(TupleElement::getAlias, tuple::get));

	}
}
