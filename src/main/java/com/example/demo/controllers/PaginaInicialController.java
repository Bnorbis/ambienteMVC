package com.example.demo.controllers;

import com.example.demo.models.ModeloSimples;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaginaInicialController {
    private long calcularFatorial(int numero) {
        long fatorial = 1;
        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }
        return fatorial;
    }

    @GetMapping("/")
    public String exibirPaginaInicial(@RequestParam(name = "valor", required = false, defaultValue = "0") int valor, Model model) {
        long resultadoFatorial = calcularFatorial(valor);

        model.addAttribute("valor", valor);
        model.addAttribute("fatorial", resultadoFatorial);
        return "pagina_inicial";
    }
}
