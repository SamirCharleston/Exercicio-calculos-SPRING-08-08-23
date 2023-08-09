package com.example.exercicio.exercicio.controller;
import com.example.exercicio.exercicio.service.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping(value = "api")
public class OperacaoController {
    @Autowired
    private OperacaoService operacaoService;
    @PostMapping("/adicionar")
    public ResponseEntity<?> dadosRecebidos(@RequestParam("valor") final BigDecimal valor){
        try{
            return ResponseEntity.ok(operacaoService.armazenarValor(valor));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getCause().getMessage());
        }
    }
    @GetMapping("/efetuar")
    public ResponseEntity<?> efetuarOperacao(){
        try{
            return ResponseEntity.ok(operacaoService.efetuarOperacoes());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getCause().getMessage());
        }
    }
}
