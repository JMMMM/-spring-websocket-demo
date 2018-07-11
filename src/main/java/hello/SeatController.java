package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimmy on 2018/7/4.
 */
@RestController
public class SeatController {

    @RequestMapping("/findSeats")
    public List<Seat> greeting() {
        List<Seat> seats = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            seats.add(new Seat(i, 0));
        }
        return seats;
    }

    @RequestMapping("/demo3")
    public String demo3(){
        return "Hello demo3!!!";
    }
}
