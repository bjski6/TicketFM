package myapp.converter;

import myapp.dao.InstallationDao;
import myapp.model.CompanyType;
import myapp.model.Installation;
import myapp.repository.RepositoryCompanyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CompanyTypeConverter implements Converter<String, CompanyType> {

    @Autowired
    private RepositoryCompanyType repositoryCompanyType;

    @Override
    public CompanyType convert(String source){
        return repositoryCompanyType.findById(Long.parseLong(source)).get();
    }
}
