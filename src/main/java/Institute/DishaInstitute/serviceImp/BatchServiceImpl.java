package Institute.DishaInstitute.serviceImp;

import Institute.DishaInstitute.entity.Batch;
import Institute.DishaInstitute.repository.BatchRepository;
import Institute.DishaInstitute.service.BatchService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;

    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public Batch addBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    @Override
    public Batch updateBatch(Long id, Batch batch) {

        Batch b = batchRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Batch not found with id: " + id
                        )
                );

        b.setName(batch.getName());
        b.setTiming(batch.getTiming());
        b.setTeacher(batch.getTeacher());
        b.setCourse(batch.getCourse());

        return batchRepository.save(b);
    }

    @Override
    public void deleteBatch(Long id) {
        batchRepository.deleteById(id);
    }

    @Override
    public Batch getBatchById(Long id) {

        return batchRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Batch not found with id: " + id
                        )
                );
    }

    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    @Override
    public List<Batch> getBatchesByTeacherId(Long teacherId) {

        return batchRepository.findByTeacherId(teacherId);
    }
}