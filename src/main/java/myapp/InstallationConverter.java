package myapp;

import myapp.controller.InstallationDao;
import myapp.model.Installation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class InstallationConverter implements Converter<String, Installation> {

    @Autowired
    private InstallationDao installationDao;

    @Override
    public Installation convert(String source){
        return installationDao.findById(Long.parseLong(source));
    }
}
