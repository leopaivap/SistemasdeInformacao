package br.edu.ifsuldeminas.mch.si.springbase;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoasVindas {

	@RequestMapping("/ola")
	public String boasVindas(Model model) {

		Date date = new Date();

		model.addAttribute("mensagem", "Seja bem vindo! " + date.toString());

		return "bem-vindo.html";
	}
}
