package it.aulab.springprogetto.util.mapper;

import java.time.LocalDate;

import org.modelmapper.AbstractConverter;

public class ConvertStringToDate extends AbstractConverter<String, LocalDate>{

    @Override
    protected LocalDate convert(String source) {
        return LocalDate.parse(source);
    }
    
}
