package uz.app.authapp.payload;

import lombok.Data;

@Data
public class BookingDTO {
    private Integer eventId;
    private String time;
    private String date;
}
