package uz.app.authapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private Integer id;
    private Integer eventId;
    private String day;
    private String time;
}
