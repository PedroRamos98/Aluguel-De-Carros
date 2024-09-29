package org.example.alugueldecarros.controller;

import org.example.alugueldecarros.model.PedidoAluguel;
import org.example.alugueldecarros.model.Cliente;
import org.example.alugueldecarros.repository.ClienteRepository;
import org.example.alugueldecarros.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Listar todos os pedidos de um cliente
    @GetMapping("/cliente/{clienteId}")
    public String listarPedidos(@PathVariable Long clienteId, Model model) {
        List<PedidoAluguel> pedidos = pedidoRepository.findByClienteId(clienteId);
        model.addAttribute("pedidos", pedidos);
        return "pedidos/lista";  // Página HTML para listar pedidos
    }

    // Mostrar formulário para criar um novo pedido
    @GetMapping("/novo/{clienteId}")
    public String mostrarFormularioCriacao(@PathVariable Long clienteId, Model model) {
        PedidoAluguel pedido = new PedidoAluguel();
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new IllegalArgumentException("Cliente inválido: " + clienteId));
        pedido.setCliente(cliente);
        model.addAttribute("pedido", pedido);
        return "pedidos/formulario";  // Página HTML para criar pedido
    }

    // Salvar um novo pedido
    @PostMapping("/salvar")
    public String salvarPedido(@ModelAttribute PedidoAluguel pedido) {
        pedido.setStatus(PedidoAluguel.StatusPedido.PENDENTE);
        pedidoRepository.save(pedido);
        return "redirect:/pedidos/cliente/" + pedido.getCliente().getId();  // Redireciona para a lista de pedidos do cliente
    }
}
