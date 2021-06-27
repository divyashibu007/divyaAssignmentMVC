package com.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.mvc.service.CartRepository;
import com.mvc.model.Carts;
import com.mvc.model.User;
import com.mvc.model.Product;
import com.mvc.service.CartService;

@Controller

public class CartsController {
	@Autowired
	private CartService cartService;

	private JpaRepository<Carts, Integer> cartrepo;





	@GetMapping("/cart_list")
	public String listCarts(Model model) {
		List<Carts> listCarts = cartService.listAll();
		model.addAttribute("listCarts", listCarts);

		return "cart_list";
	}

	@RequestMapping("/new_cart")
	public ModelAndView showNewCartsPage(Model model) {
		ModelAndView view = new ModelAndView("new_cart");
		Carts carts = new Carts();
		List<Product> product= cartService.getAllProduct();
		List<User> user= cartService.getAllUser();

		view.addObject("carts", carts);
		view.addObject("userList", user);

		view.addObject("productList",product);
		return view;
	}

	@RequestMapping(value = "/save_cart", method = RequestMethod.POST)
	public String saveCart(@ModelAttribute("carts") Carts carts)
	{
		cartService.save(carts);



		return "redirect:/cart_list";
	}

	@RequestMapping("/load_edit_cart/{id}")
	public ModelAndView showEditCartPage(@PathVariable(name = "id") int id) {
		ModelAndView viewstatus = new ModelAndView("edit_cart");
		Carts carts = cartService.get(id);
		List<Product> product= cartService.getAllProduct();
		List<User> user= cartService.getAllUser();
		viewstatus.addObject("carts", carts);
		viewstatus.addObject("productList",product);
		viewstatus.addObject("userList",user);
		return viewstatus;
	}

	@PostMapping("/process_edit_cart")
	public String editcartsPage(@ModelAttribute("carts") Carts carts) {

		Carts carts1 = cartrepo.getOne(Math.toIntExact(Long.valueOf(carts.getId())));

		carts1.setStatus(carts.getStatus());
		carts1.setProductList(carts.getProductList());
		carts1.setUserList(carts.getUserList());
		cartrepo.save(carts1);

		return "edit_cart_success";
	}



}
