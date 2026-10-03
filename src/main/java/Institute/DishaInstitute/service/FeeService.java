package Institute.DishaInstitute.service;

import Institute.DishaInstitute.dto.FeeDto;
import Institute.DishaInstitute.entity.Fee;

import java.util.List;

public interface FeeService {

    Fee payFee(FeeDto dto);

    Fee updateFee(Long id, FeeDto dto);

    Fee getFeeById(Long id);

    List<Fee> getAllFees();
}