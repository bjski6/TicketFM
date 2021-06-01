package myapp.converter;

import myapp.model.Person;
import myapp.model.TicketType;
import myapp.repository.RepositoryPerson;
import myapp.repository.RepositoryTicketType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class PersonConverter implements Converter<String, Person> {

    @Autowired
    private RepositoryPerson repositoryPerson;

    @Override
    public Person convert(String source) {
        return repositoryPerson.findById(Long.parseLong(source)).get();
    }
}
