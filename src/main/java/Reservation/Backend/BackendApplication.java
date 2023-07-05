package Reservation.Backend;

import Reservation.Backend.model.busmodel;
import Reservation.Backend.repos.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
//@RestController
public class BackendApplication {
//	@Autowired
//	repo r;
//
//	@Autowired
//	test tt;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

//	@GetMapping("/mango")
//	public List<spring> test(){
//		return r.findAll();
//	}
//
//	@PostMapping("/add")
//	public spring addpost(@RequestBody spring s)
//	{
//		return r.save(s);
//	}
//
//	@PostMapping("/create")
//	public busmodel testing(@RequestBody busmodel one){
//		return tt.save(one);
//	}
//
//	@GetMapping("/getbuses")
//	public List<busmodel> getbuses()
//	{
//		return tt.findAll();
//	}
}
