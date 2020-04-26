//package com.krootix.microservices.securitypolicy.util;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Converter
//public class StringListConverter implements AttributeConverter<List<String>, String> {
//    @Override
//    public String convertToDatabaseColumn(List<String> strings) {
//        return String.join(",", strings);
//    }
//
//    @Override
//    public List<String> convertToEntityAttribute(String joined) {
//        return new ArrayList<>(Arrays.asList(joined.split(",")));
//    }
//}
