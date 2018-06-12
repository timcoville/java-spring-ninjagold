package com.timcoville.ninjagold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
@RequestMapping("/")
public class NinjaGoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(NinjaGoldApplication.class, args);
	}
	@RequestMapping("")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {
			Integer gold = 0;
			ArrayList<String> activities = new ArrayList<String>();
			session.setAttribute("gold", gold);
			session.setAttribute("activities", activities);
		}
		model.addAttribute("gold", session.getAttribute("gold"));
		model.addAttribute("activities", session.getAttribute("activities"));
		return "gold.jsp";
	}
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(HttpSession session, @RequestParam(value="building")String building) {
		Integer gold = (Integer) session.getAttribute("gold");
		@SuppressWarnings("unchecked")
		ArrayList<String> array = (ArrayList<String>) session.getAttribute("activities");
		Random rand = new Random();
		Date newDate = new Date();
		if(building.equals("farm")) {
			int val = rand.nextInt(21-10)+10;
			gold += val;
			String activity = "You entered the farm and earned " + val + " gold. " + newDate;
			array.add(0, activity);
			session.setAttribute("gold", gold);
			session.setAttribute("activities", array);
		}
		if(building.equals("cave")) {
			int val = rand.nextInt(11-5)+5;
			gold += val;
			String activity = "You entered a cave and earned " + val + " gold. " + newDate;
			array.add(0, activity);
			session.setAttribute("gold", gold);
			session.setAttribute("activities", array);
		}
		if(building.equals("house")) {
			int val = rand.nextInt(5-2)+2;
			gold += val;
			String activity = "You entered some house and earned " + val + " gold. " + newDate;
			array.add(0, activity);
			session.setAttribute("gold", gold);
			session.setAttribute("activities", array);
			
		}
		if(building.equals("casino")) {
			int winLoss = rand.nextInt(2);
			int val = rand.nextInt(50-0);
			if (winLoss == 0) {
				gold += val;
				String activity = "You won big at the casino and earned " + val + " gold. " + newDate;
				array.add(0, activity);
			}
			if (winLoss == 1) {
				gold -= val;
				String activity = "You lost big at the casino and earned " + val + " gold. " + newDate;
				array.add(0, activity);
			}
			session.setAttribute("gold", gold);
			session.setAttribute("activities", array);
		}
	return "redirect:/";
	}

}
