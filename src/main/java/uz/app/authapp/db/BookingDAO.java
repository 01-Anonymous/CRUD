package uz.app.authapp.db;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import uz.app.authapp.entity.Booking;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BookingDAO {
    final NamedParameterJdbcTemplate jdbcTemplate;

    public void addEventBooking(Booking booking) {
        jdbcTemplate.update("insert into event_booking(event_id,day, time) values(:eventId, :day, :time)",
                Map.of(
                        "eventId", booking.getEventId(),
                        "day", booking.getDay(),
                        "time", booking.getTime()
                ));
    }

    public List<Booking> getAllEventBookings() {
        return jdbcTemplate.query("select * from event_booking",
                (rs, rowNum) -> new Booking(
                        rs.getInt("id"),
                        rs.getInt("event_id"),
                        rs.getString("day"),
                        rs.getString("time")
                ));
    }

    public Integer countBokingByEventDayTime(Integer eventId, String day, String time) {

        Integer query = jdbcTemplate.query("select count(*) as c from event_booking where event_id =:eventId and day=:day and time =:time",
                Map.of(
                        "eventId", eventId,
                        "day", day,
                        "time", time
                ), rs -> {
                    rs.next();
                    return rs.getInt("c");
                });
        return query;
    }

    public void cancelBooking(Integer id){
        jdbcTemplate.update("delete from event_booking where id =:id", Map.of(
                "id", id
        ));
    }

}
