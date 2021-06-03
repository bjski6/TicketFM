package myapp.converter;

import myapp.model.Status;
import myapp.repository.RepositoryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StatusConverter implements Converter<String, Status> {

    @Autowired
    private RepositoryStatus repositoryStatus;

    @Override
    public Status convert(String source) {
        return repositoryStatus.findById(Long.parseLong(source)).get();
    }
}
