package com.loija.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.loija.core.model.FactoryOrder;
import com.loija.core.service.FactoryOrderService;

@Controller
@RequestMapping("/fOrders")
public class FactoryOrderController {

	@Autowired
	private FactoryOrderService service;

	@GetMapping({"/showAll", "", "/list"})
	public ModelAndView showAll() {
		ModelAndView mv = new ModelAndView("list-orders");
		List<FactoryOrder> factoryOrders = service.listOrders();
		mv.addObject("factoryOrders", factoryOrders);
		return mv;
	}
	
	@GetMapping("/addNew")
	public ModelAndView addNew() {
		ModelAndView mv = new ModelAndView("form-order");
		FactoryOrder order = new FactoryOrder();
		mv.addObject("order", order);
		return mv;
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute FactoryOrder order) {
		service.addOrder(order);
		return "redirect:/fOrders";
	}
	
	@GetMapping("/update")
	public ModelAndView update(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("form-order");
		FactoryOrder order = service.getOrderById(id);
		mv.addObject("order", order);
		return mv;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		service.deleteOrder(id);
		return "redirect:/fOrders";
	}
}
