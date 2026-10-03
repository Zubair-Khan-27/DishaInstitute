package Institute.DishaInstitute.controller;

import Institute.DishaInstitute.dto.FeeDto;
import Institute.DishaInstitute.entity.Fee;
import Institute.DishaInstitute.service.FeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
@CrossOrigin
public class FeeController {

    private final FeeService feeService;

    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    @PostMapping
    public ResponseEntity<Fee> payFee(
            @RequestBody FeeDto dto) {

        return ResponseEntity.ok(
                feeService.payFee(dto)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fee> updateFee(
            @PathVariable Long id,
            @RequestBody FeeDto dto) {

        return ResponseEntity.ok(
                feeService.updateFee(id, dto)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fee> getFeeById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                feeService.getFeeById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<Fee>> getAllFees() {

        return ResponseEntity.ok(
                feeService.getAllFees()
        );
    }
}