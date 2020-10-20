package bstk.dev.desafiocodigo.emprestimos.domain;

import bstk.dev.desafiocodigo.emprestimos.api.EmprestimoDto;
import bstk.dev.desafiocodigo.emprestimos.api.PropostaDeEmprestimoRequest;

import java.math.BigDecimal;

import static bstk.dev.desafiocodigo.emprestimos.utils.Operacao.*;

public class EmprestimoPessoal implements PropostaEmprestimo {

    private static final String TIPO = "pessoal";
    private static final Integer TAXA_DE_JUROS = 4;
    private static final BigDecimal SALARIO_3000 = BigDecimal.valueOf(3_000L);
    private static final BigDecimal SALARIO_5000 = BigDecimal.valueOf(5_000L);

    @Override
    public EmprestimoDto concederEmprestimo(PropostaDeEmprestimoRequest request) {
        if (permiteEmprestimo(request.getSalario())) {
            return new EmprestimoDto(TIPO, TAXA_DE_JUROS);
        }

        return null;
    }

    private boolean permiteEmprestimo(final BigDecimal salario) {
        return menorIgual(salario, SALARIO_3000)
            || maiorIgual(salario, SALARIO_5000)
            || (maiorQue(salario, SALARIO_3000)
            && menorIgual(salario, SALARIO_5000));
    }
}
