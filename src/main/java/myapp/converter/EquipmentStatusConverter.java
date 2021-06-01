package myapp.converter;


import myapp.dao.StatusEqDao;
import myapp.model.EquipmentStatus;
import myapp.repository.RepositoryEquipmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class EquipmentStatusConverter implements Converter<String, EquipmentStatus> {

    @Autowired
    private RepositoryEquipmentStatus repositoryEquipmentStatus;

    @Override
    public EquipmentStatus convert(String source){
        return repositoryEquipmentStatus.findById(Long.parseLong(source)).get();
    }
}
