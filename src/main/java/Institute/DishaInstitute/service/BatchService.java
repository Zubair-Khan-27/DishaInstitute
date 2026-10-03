package Institute.DishaInstitute.service;

import Institute.DishaInstitute.entity.Batch;

import java.util.List;

public interface BatchService {

    Batch addBatch(Batch batch);

    Batch updateBatch(Long id, Batch batch);

    void deleteBatch(Long id);

    Batch getBatchById(Long id);

    List<Batch> getAllBatches();

    List<Batch> getBatchesByTeacherId(Long teacherId);
}