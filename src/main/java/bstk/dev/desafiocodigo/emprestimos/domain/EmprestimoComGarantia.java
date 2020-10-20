package bstk.dev.desafiocodigo.emprestimos.domain;

import bstk.dev.desafiocodigo.emprestimos.api.EmprestimoDto;
import bstk.dev.desafiocodigo.emprestimos.api.PropostaDeEmprestimoRequest;

import java.math.BigDecimal;

import static bstk.dev.desafiocodigo.emprestimos.util.Operacao.*;

public class EmprestimoComGarantia implements PropostaEmprestimo {

    private static final String LOCALIZACAO_SP = "SP";
    private static final String TIPO = "com_garantia";
    private static final Integer TAXA_DE_JUROS = 3;
    private static final Integer IDADE_PARA_EMPRESTIMO = 30;
    private static final BigDecimal SALARIO_3000 = BigDecimal.valueOf(3_000L);
    private static final BigDecimal SALARIO_5000 = BigDecimal.valueOf(5_000L);

    @Override
    public EmprestimoDto concederEmprestimo(PropostaDeEmprestimoRequest request) {
        boolean permiteRegraSalarioEIdade = permiteRegraSalarioEIdade(request);
        boolean permiteRegraSalarioELocalizacao = permiteRegraSalarioELocalizacao(request);
        boolean permiteRegraSalarioIdadeELocalizacao = permiteRegraSalarioIdadeELocalizacao(request);

        if (permiteRegraSalarioEIdade
         || permiteRegraSalarioELocalizacao
         || permiteRegraSalarioIdadeELocalizacao) {
            return new EmprestimoDto(TIPO, TAXA_DE_JUROS);
        }

        return null;
    }

    private boolean permiteRegraSalarioEIdade(PropostaDeEmprestimoRequest request) {
        return maiorQue(request.getSalario(), SALARIO_5000)
            && menorQue(request.getIdade(), IDADE_PARA_EMPRESTIMO);
    }

    private boolean permiteRegraSalarioELocalizacao(PropostaDeEmprestimoRequest request) {
        return menorIgual(request.getSalario(), SALARIO_5000)
            && LOCALIZACAO_SP.equalsIgnoreCase(request.getLocalizacao());
    }

    private boolean permiteRegraSalarioIdadeELocalizacao(PropostaDeEmprestimoRequest request) {
        return menorIgual(request.getSalario(), SALARIO_3000)
            && menorQue(request.getIdade(), IDADE_PARA_EMPRESTIMO)
            && LOCALIZACAO_SP.equalsIgnoreCase(request.getLocalizacao());
    }

}
