package abel.springframework.services.hibernate;

import abel.springframework.domain.UnitOfMeasure;
import abel.springframework.repositories.UnitOfMeasureRepository;
import abel.springframework.services.UnitOfMeasureService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UnitOfMeasureHibernateService implements UnitOfMeasureService {
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureHibernateService(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Set<UnitOfMeasure> findAll() {
        Set<UnitOfMeasure> unitOfMeasureSet = new HashSet<>();
        unitOfMeasureRepository.findAll().iterator().forEachRemaining(unitOfMeasureSet::add);
        return unitOfMeasureSet;
    }

    @Override
    public Optional<UnitOfMeasure> findById(Long aLong) {
        return unitOfMeasureRepository.findById(aLong);
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure object) {
        return unitOfMeasureRepository.save(object);
    }

    @Override
    public void delete(UnitOfMeasure object) {
        unitOfMeasureRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        unitOfMeasureRepository.delete(findById(aLong).get());
    }
}
