package de.cadoculus.ocx3.impl;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.util.List;

public class DoubleListAdapter extends XmlAdapter<String, List<Double>> {
    @Override
    public List<Double> unmarshal(String s) throws Exception {
        return List.of();
    }

    @Override
    public String marshal(List<Double> doubles) throws Exception {
        return "";
    }
}
