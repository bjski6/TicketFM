package myapp.converter;

import myapp.model.TicketStatus;
import myapp.model.TicketType;
import myapp.repository.RepositoryTicketStatus;
import myapp.repository.RepositoryTicketType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class TicketStatusConverter implements Converter<String, TicketStatus> {

    @Autowired
    private RepositoryTicketStatus repositoryTicketStatus;

    @Override
    public TicketStatus convert(String source) {
        return repositoryTicketStatus.findById(Long.parseLong(source)).get();
    }
}
