package com.simulador.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simulador.app.model.entity.Grupo;
import com.simulador.app.model.entity.Linea;
import com.simulador.app.model.entity.Round;
import com.simulador.app.service.IGrupoService;
import com.simulador.app.service.ILineaService;
import com.simulador.app.service.IRoundService;

@Controller
@SessionAttributes("juego")
@RequestMapping("/juego")
public class JuegoController {

	@Autowired
	private ILineaService lineaService;

	@Autowired
	private IGrupoService grupoService;

	@Autowired
	private IRoundService roundService;

	List<Grupo> grupos;

	List<Round> rounds;

	List<Grupo> gtemporal;
	
	List<Grupo> copia;
	
	Grupo gr = new Grupo();

	List<Round> rtemporal;

	int capital = 0;

	int Cantgrup = 0;

	int Cantround = 0;

	int maxcompra = 0;
	int maxventa = 0;

	Linea linea;

	public void ordenarGrupos() {
		// iteramos sobre los elementos del arreglo
		for (int i = 0; i < gtemporal.size() - 1; i++) {
			int min = i;

			// buscamos el menor número
			for (int j = i + 1; j < gtemporal.size(); j++) {
				if (gtemporal.get(j).getId_grupo() < gtemporal.get(min).getId_grupo()) {
					min = j; // encontramos el menor número
				}
			}

			if (i != min) {
				// permutamos los valores
				Grupo aux = gtemporal.get(i);
				gtemporal.set(i, gtemporal.get(min));
				gtemporal.set(min, aux);
			}
		}
	}

	public void ordenarRounds() {
		// iteramos sobre los elementos del arreglo
		for (int i = 0; i < rtemporal.size() - 1; i++) {
			int min = i;

			// buscamos el menor número
			for (int j = i + 1; j < rtemporal.size(); j++) {
				if (rtemporal.get(j).getId_round() < rtemporal.get(min).getId_round()) {
					min = j; // encontramos el menor número
				}
			}

			if (i != min) {
				// permutamos los valores
				Round aux = rtemporal.get(i);
				rtemporal.set(i, rtemporal.get(min));
				rtemporal.set(min, aux);
			}
		}
	}

	@GetMapping("/nuevo")
	public String nuevoJuego(Model model) {

		return "/juego/inicio";
	}

	@GetMapping(value = "/inicio")
	public String inicio(Model model, @RequestParam(name = "round", required = false) int round,
			@RequestParam(name = "grupo", required = false) int grupo,
			@RequestParam(name = "materia", required = false) int materia) {

		capital = materia;

		grupos = new ArrayList<>();

		rounds = new ArrayList<>();

		Random aleatorio = new Random(System.currentTimeMillis());

		for (int i = 0; i < grupo; i++) {

			Grupo grupin = new Grupo();
			grupin.setInventario(materia * 4);
			grupin.setSaldo(0);
			grupos.add(grupin);
			grupoService.save(grupin);
			grupin = null;

		}

		for (int i = 0; i < round; i++) {

			int aleMateria = aleatorio.nextInt(9) + 1;
			int aleProducto = aleatorio.nextInt(15) + 1;

			Round roun = new Round();
			roun.setMateriaPrima(aleMateria);
			roun.setProducto(aleProducto);
			rounds.add(roun);
			roundService.save(roun);
			roun = null;
		}

		Cantround = round;

		Cantgrup = grupo;

		gtemporal = grupoService.encontrarGrupos(new Long(Cantgrup));
		ordenarGrupos();
		
		copia = gtemporal;
		
		return "redirect:/juego/round";
	}

	int roundActual = 1;

	@GetMapping("/round")
	public String round(Model model) {

		linea = new Linea();

		gtemporal = grupoService.encontrarGrupos(new Long(Cantgrup));
		rtemporal = roundService.encontrarRounds(new Long(Cantround));

		ordenarGrupos();
		ordenarRounds();
	
		if (rtemporal.size() >= roundActual) {
			switch (roundActual) {
			case 1:
				model.addAttribute("round", rtemporal.get(0));
				model.addAttribute("titulo", "ROUND 1");
				
				break;

			case 2:
				model.addAttribute("round", rtemporal.get(1));
				model.addAttribute("titulo", "ROUND 2");
				break;

			case 3:
				model.addAttribute("round", rtemporal.get(2));
				model.addAttribute("titulo", "ROUND 3");
				break;

			case 4:
				model.addAttribute("round", rtemporal.get(3));
				model.addAttribute("titulo", "ROUND 4");
				break;

			case 5:
				model.addAttribute("round", rtemporal.get(4));
				model.addAttribute("titulo", "ROUND 5");
				break;

			case 6:
				model.addAttribute("round", rtemporal.get(5));
				model.addAttribute("titulo", "ROUND 6");
				break;

			case 7:
				model.addAttribute("round", rtemporal.get(6));
				model.addAttribute("titulo", "ROUND 7");
				break;

			case 8:
				model.addAttribute("round", rtemporal.get(7));
				model.addAttribute("titulo", "ROUND 8");
				break;

			default:

				roundActual = 1;
				break;
			}
		}

		else {
			return "redirect:/juego/reporte";
		}

		model.addAttribute("grupos", gtemporal);
		
		model.addAttribute("copia", copia);
		
		model.addAttribute("gr", gr);		
		
		
		model.addAttribute("capital", capital);
		model.addAttribute("linea", linea);
		model.addAttribute("cantidadP", capital * 4);
		model.addAttribute("maxcompra", 10);
		model.addAttribute("maxventa", 10);

		roundActual = roundActual + 1;

		return "juego/round";

	}

	@PostMapping(value = "/guardar")
	public String guardar(@Valid Grupo gr,BindingResult result, Model model, RedirectAttributes flash) {

		if (result.hasErrors()) {
			
			return "customer/nuevo";
		}
		Grupo grupo = new Grupo();
		Round round = new Round();

		round = rtemporal.get(roundActual - 2);

		if (gr.getId_grupo()> 0) {
			
			try {
				grupo = grupoService.findById(gr.getId_grupo());
				
			} catch (Exception e) {
				// TODO: handle exception
				flash.addFlashAttribute("error", "El grupo no existe en el juego");
				roundActual = roundActual - 1;
				return "redirect:/juego/round";
			}
			

			if (grupo == null) {
				flash.addFlashAttribute("error", "El grupo no existe en el juego");
				roundActual = roundActual - 1;
				return "redirect:/juego/round";
			}
		} else {
			flash.addFlashAttribute("error", "El grupo no puede ser 0!");
			roundActual = roundActual - 1;
			return "redirect:/juego/round";
		}

		if (grupo.getSaldo() >= gr.getCompra() * round.getMateriaPrima() && gr.getVenta() < grupo.getInventario()) {
			linea.setGrupo(grupo);
			linea.setRound(round);
			linea.setCompra(gr.getCompra());
			linea.setVenta(gr.getVenta());

			grupo.setInventario(grupo.getInventario() + gr.getCompra() * 4);
			grupo.setSaldo(grupo.getSaldo() + round.getProducto() * gr.getVenta());
			grupo.setSaldo(grupo.getSaldo() - round.getMateriaPrima() * gr.getCompra());
			grupo.setInventario(grupo.getInventario() - gr.getVenta());

			lineaService.save(linea);
			
			//Long remover = gr.getId_grupo();
			int remover = 0;
			
			for (Grupo grupo2 : copia) {
				
				if(gr.getId_grupo()==grupo2.getId_grupo())
				{
					break;
				}
				remover++;
			}
			
			
			copia.remove(remover);
			linea = null;
			grupo = null;
			gr=null;
			roundActual = roundActual - 1;

			return "redirect:/juego/round";
		} else {

			flash.addFlashAttribute("error", "Datos de compra y/o venta invalidos");
			roundActual = roundActual - 1;
			return "redirect:/juego/round";
		}

	}
	
	@GetMapping("/reporte")
	public String reporte(Model model) {
		
		
		for (Grupo group : gtemporal) {
			
			group.setVenta(group.getInventario()* rtemporal.get(rtemporal.size()-1).getProducto());
		}
		
		model.addAttribute("capital", capital);
		model.addAttribute("cantidadP", capital * 4);
		model.addAttribute("grupos", gtemporal);
		model.addAttribute("rounds", rtemporal);

		return "juego/reporte";
	}
	
	@GetMapping("/fin")
	public String fin()
	{
		roundActual = 1;
		return "redirect:/juego/nuevo";
	}
	
	@GetMapping("/pasar")
	public String pasar()
	{
		copia = gtemporal;
		return "redirect:/juego/round";
	}
}
