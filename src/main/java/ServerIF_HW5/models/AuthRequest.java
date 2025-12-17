package ServerIF_HW5.models;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
