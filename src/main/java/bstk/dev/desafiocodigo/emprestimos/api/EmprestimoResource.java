package bstk.dev.desafiocodigo.emprestimos.api;

import bstk.dev.desafiocodigo.emprestimos.domain.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/emprestimos")
public class EmprestimoResource {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/ofertar-proposta")
    public ResponseEntity<PropostaDeEmprestimoResponse> ofertarProposta(
        final @RequestBody PropostaDeEmprestimoRequest request) {

        final Set<EmprestimoDto> emprestimos = emprestimoService.obterPropostas(request);
        final PropostaDeEmprestimoResponse response = new PropostaDeEmprestimoResponse(emprestimos, request.getNome());

        return ResponseEntity.ok(response);
    }

}
