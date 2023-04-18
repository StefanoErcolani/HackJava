package it.aulab.springthymeleaf.util.mapper;

import org.modelmapper.AbstractConverter;

public class ConvertStringToInteger extends AbstractConverter<String, Integer>{

    @Override
    protected Integer convert(String source) {
        return source.length();
    }
    
}
