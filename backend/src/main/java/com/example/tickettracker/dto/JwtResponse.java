package backend.src.main.java.com.example.tickettracker.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class JwtResponse {

    private String token;
    private String type = "Bearer";

    public JwtResponse(String token) {
        this.token = token;
    }

}
