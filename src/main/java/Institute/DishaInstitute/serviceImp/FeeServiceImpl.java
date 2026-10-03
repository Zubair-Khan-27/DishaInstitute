package Institute.DishaInstitute.serviceImp;

import Institute.DishaInstitute.dto.FeeDto;
import Institute.DishaInstitute.entity.Fee;
import Institute.DishaInstitute.entity.Student;
import Institute.DishaInstitute.repository.FeeRepository;
import Institute.DishaInstitute.repository.StudentRepository;
import Institute.DishaInstitute.service.FeeService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeServiceImpl implements FeeService {

    private final FeeRepository feeRepository;
    private final StudentRepository studentRepository;

    public FeeServiceImpl( FeeRepository feeRepository,StudentRepository studentRepository) {

        this.feeRepository = feeRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Fee payFee(FeeDto dto) {

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + dto.getStudentId() ) );

        Fee fee = new Fee();

        fee.setStudent(student);
        fee.setTotalFees(dto.getTotalFees());
        fee.setPaidFees(dto.getPaidFees());
        fee.setRemainingFees(dto.getRemainingFees());
        fee.setStatus(dto.getStatus());
        fee.setPaymentDate(dto.getPaymentDate());

        return feeRepository.save(fee);
    }

    @Override
    public Fee updateFee(Long id, FeeDto dto) {

        Fee fee = feeRepository.findById(id)
                .orElseThrow(() ->  new RuntimeException(  "Fee not found with id: " + id)  );

        fee.setPaidFees(dto.getPaidFees());
        fee.setRemainingFees(dto.getRemainingFees());
        fee.setStatus(dto.getStatus());

        return feeRepository.save(fee);
    }

    @Override
    public Fee getFeeById(Long id) {

        return feeRepository.findById(id)
                .orElseThrow(() ->new RuntimeException( "Fee not found with id: " + id) );
    }

    @Override
    public List<Fee> getAllFees() {

        return feeRepository.findAll();
    }
}