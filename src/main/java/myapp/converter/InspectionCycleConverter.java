package myapp.converter;

import myapp.model.InspectionCycle;
import myapp.repository.RepositoryInspectionCycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class InspectionCycleConverter implements Converter<String, InspectionCycle> {

    @Autowired
    private RepositoryInspectionCycle repositoryInspectionCycle;

    @Override
    public InspectionCycle convert(String source) {
        return repositoryInspectionCycle.findById(Long.parseLong(source)).get();
    }
}
