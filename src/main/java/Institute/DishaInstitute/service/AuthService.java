package Institute.DishaInstitute.service;

import Institute.DishaInstitute.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<String> register(RegisterRequest request);
}