package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping("/cars")
	public String cars(@RequestParam(value = "count", defaultValue = "5") int allCars, Model model) {
		List<Car> list = new ArrayList<>();
		list.add(new Car("Ford", "RED", 500));
		list.add(new Car("Ferrari", "YELLOW", 300));
		list.add(new Car("Lada", "BLACK", 1000));
		list.add(new Car("FIAT", "GREEN", 190));
		list.add(new Car("BMW", "BLUE", 200));
		list = CarService.carsCount(list, allCars);
		model.addAttribute("cars_list", list);
		return "cars";
	}
	
}