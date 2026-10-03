package Institute.DishaInstitute.dto;

import lombok.Data;

@Data
public class StudentDto {

    private String name;
    private String mobile;
    private int age;
    private String address;

    private Long courseId;
    private Long batchId;
}