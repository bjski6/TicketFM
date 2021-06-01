package myapp.converter;

import myapp.model.Installation;
import myapp.model.TicketType;
import myapp.repository.RepositoryInstallation;
import myapp.repository.RepositoryTicketType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class TicketTypeConverter implements Converter<String, TicketType> {

    @Autowired
    private RepositoryTicketType repositoryTicketType;

    @Override
    public TicketType convert(String source) {
        return repositoryTicketType.findById(Long.parseLong(source)).get();
    }
}
