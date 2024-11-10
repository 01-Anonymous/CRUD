package uz.app.authapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.app.authapp.db.BookingDAO;
import uz.app.authapp.db.EventDAO;
import uz.app.authapp.entity.Booking;
import uz.app.authapp.payload.BookingDTO;
import uz.app.authapp.payload.EventBookingDTO;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final EventDAO eventDAO;
    private final BookingDAO bookingDAO;

    @PostMapping
    public String bookEvent(@ModelAttribute BookingDTO bookingDTO){
        Integer count = bookingDAO.countBokingByEventDayTime(bookingDTO.getEventId(), bookingDTO.getDate(), bookingDTO.getTime());
        if (count < eventDAO.getEvent(bookingDTO.getEventId()).orElseThrow().getCapacity()) {
            Booking booking = new Booking();
            booking.setEventId(bookingDTO.getEventId());
            booking.setDay(bookingDTO.getDate());
            booking.setTime(bookingDTO.getTime());
            bookingDAO.addEventBooking(booking);
        }
        else {
            throw new RuntimeException("barcha seanslar tulgan:");
        }
        return "redirect:/booking";
    }

    @GetMapping
    public String booking(Model model) {
        List<Booking> allbookings = bookingDAO.getAllEventBookings();

        List<EventBookingDTO> list = allbookings.stream()
                .map(
                        ticket -> {
                            EventBookingDTO eventBookingDTO = new EventBookingDTO();
                            eventBookingDTO.setId(ticket.getId());
                            eventBookingDTO.setDay(ticket.getDay());
                            eventBookingDTO.setTime(ticket.getTime());
                            eventBookingDTO.setEvent(eventDAO.getEvent(ticket.getEventId()).orElseThrow());
                            return eventBookingDTO;
                        }
                ).toList();


        model.addAttribute("bookings", list);
        return "booking";
    }

    @GetMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable(name = "id") Integer id){
        bookingDAO.cancelBooking(id);
        return "redirect:/booking";
    }


}
