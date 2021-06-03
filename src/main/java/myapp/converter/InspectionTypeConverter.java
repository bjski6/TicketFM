package myapp.converter;

import myapp.model.InspectionCycle;
import myapp.model.InspectionType;
import myapp.repository.RepositoryInspectionCycle;
import myapp.repository.RepositoryInspectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class InspectionTypeConverter implements Converter<String, InspectionType> {

    @Autowired
    private RepositoryInspectionType repositoryInspectionType;

    @Override
    public InspectionType convert(String source) {
        return repositoryInspectionType.findById(Long.parseLong(source)).get();
    }
}
