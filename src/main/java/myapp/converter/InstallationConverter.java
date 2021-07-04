package myapp.converter;


import myapp.model.Installation;


import myapp.repository.RepositoryInstallation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class InstallationConverter implements Converter<String, Installation> {

    @Autowired
    private RepositoryInstallation repositoryInstallation;

    @Override
    public Installation convert(String source) {
        return repositoryInstallation.findById(Long.parseLong(source)).get();
    }
}
