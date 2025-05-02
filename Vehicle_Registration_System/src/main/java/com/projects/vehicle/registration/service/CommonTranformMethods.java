package com.projects.vehicle.registration.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Tuple;

public interface CommonTranformMethods {
    public List<Map<String, Object>> transformToListOfMap(List<Tuple> tuples);
}
