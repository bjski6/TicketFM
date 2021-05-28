package myapp;


import myapp.controller.InstallationDao;
import myapp.controller.StatusEqDao;
import myapp.model.Installation;
import myapp.model.StatusEq;
import myapp.repository.RepositoryStatusEq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StatusConverter implements Converter<String, StatusEq> {

    @Autowired
    private StatusEqDao statusEqDao;

    @Override
    public StatusEq convert(String source){
        return statusEqDao.findById(Long.parseLong(source));
    }
}
