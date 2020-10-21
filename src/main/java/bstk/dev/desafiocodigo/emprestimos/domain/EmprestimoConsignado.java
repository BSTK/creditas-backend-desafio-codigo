package bstk.dev.desafiocodigo.emprestimos.domain;

import bstk.dev.desafiocodigo.emprestimos.api.EmprestimoDto;
import bstk.dev.desafiocodigo.emprestimos.api.PropostaDeEmprestimoRequest;

import java.math.BigDecimal;

import static bstk.dev.desafiocodigo.emprestimos.util.Operacao.*;

public class EmprestimoConsignado implements PropostaEmprestimo {

    private static final String TIPO = "consignado";
    private static final Integer TAXA_DE_JUROS = 2;
    private static final BigDecimal SALARIO_5000 = BigDecimal.valueOf(5_000L);

    @Override
    public EmprestimoDto concederEmprestimo(PropostaDeEmprestimoRequest request) {
        if (permiteEmprestimo(request.getSalario())) {
            return new EmprestimoDto(TIPO, TAXA_DE_JUROS);
        }

        return null;
    }

    private boolean permiteEmprestimo(final BigDecimal salario) {
        if (menorQue(salario, SALARIO_5000)) {
            return false;
        }

        return maiorIgual(salario, SALARIO_5000);
    }

}
