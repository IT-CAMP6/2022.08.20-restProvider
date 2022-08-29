package pl.camp.it.rest.provider.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.rest.provider.model.Response;
import pl.camp.it.rest.provider.model.User;

@RestController
public class FirstRestController {

    @RequestMapping(value = "/cos/{id}", method = RequestMethod.GET)
    public User cos(@PathVariable int id) {
        System.out.println("cos sie dzieje !!");
        return new User("testowyRest", "testoweHasloUsera" + id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void cos2(@RequestBody User user) {
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public Response cos3(@RequestBody User user,
                         @PathVariable int id,
                         @RequestParam String param1,
                         @RequestParam String param2,
                         @RequestHeader String header1,
                         @RequestHeader String header2) {
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        System.out.println(id);
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(header1);
        System.out.println(header2);

        Response response = new Response();
        response.setInfo("Jakaś informacja");
        response.setCode(456);

        return response;
    }

    @RequestMapping(value = "/adres", method = RequestMethod.GET)
    public ResponseEntity<User> customowaOdpowiedz() {
        User user = new User();
        user.setLogin("Karol");
        user.setPassword("karolek1010");

        ResponseEntity<User> response = ResponseEntity.status(404)
                .header("n1", "5")
                .header("n2", "nalowek")
                .body(user);

        return response;
    }

    @RequestMapping(value = "/user2", method = RequestMethod.POST)
    public User changeUser(@RequestBody User user) {
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());

        user.setLogin("zmieniony login");

        return user;
    }
}
