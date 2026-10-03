package Institute.DishaInstitute.controller;

import Institute.DishaInstitute.entity.Batch;
import Institute.DishaInstitute.service.BatchService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
@CrossOrigin
public class BatchController {

    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @PostMapping
    public Batch addBatch(@RequestBody Batch batch) {
        return batchService.addBatch(batch);
    }

    @PutMapping("/{id}")
    public Batch updateBatch(@PathVariable Long id,@RequestBody Batch batch) {

        return batchService.updateBatch(id, batch);
    }

    @DeleteMapping("/{id}")
    public void deleteBatch(@PathVariable Long id) {
        batchService.deleteBatch(id);
    }

    @GetMapping("/{id}")
    public Batch getBatchById(@PathVariable Long id) {
        return batchService.getBatchById(id);
    }

    @GetMapping
    public List<Batch> getAllBatches() {
        return batchService.getAllBatches();
    }

    // Teacher ke according batches
    @GetMapping("/teacher/{teacherId}")
    public List<Batch> getBatchesByTeacher( @PathVariable Long teacherId) {

        return batchService.getBatchesByTeacherId(teacherId);
    }
}