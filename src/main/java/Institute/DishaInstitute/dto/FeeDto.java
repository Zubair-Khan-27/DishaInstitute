package Institute.DishaInstitute.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FeeDto {

    private double totalFees;
    private double paidFees;
    private double remainingFees;
    private String status;
    private LocalDate paymentDate;
    private Long studentId;

}