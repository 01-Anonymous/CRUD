package uz.app.authapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.app.authapp.entity.Event;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventBookingDTO {
    private Integer id;
    private Event event;
    private String time;
    private String day;
}
