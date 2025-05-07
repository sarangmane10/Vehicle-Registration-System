package com.projects.vehicle.registration.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.lang.NonNull;

import jakarta.persistence.Tuple;

public interface CommonTranformMethods {
    public @NonNull List<Map<String, Object>> transformResultToMap(@NonNull List<Tuple> tuples);
    public @NonNull Map<String, Object> transformResultToMap(@NonNull Tuple tuple);
}
