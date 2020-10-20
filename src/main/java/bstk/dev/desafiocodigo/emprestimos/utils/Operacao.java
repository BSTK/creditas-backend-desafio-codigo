package bstk.dev.desafiocodigo.emprestimos.utils;

import java.math.BigDecimal;

public class Operacao {

    public static boolean menorQue(final Integer valorA,final Integer valorB) {
        return valorA < valorB;
    }

    public static boolean maiorQue(final BigDecimal valorA,final BigDecimal valorB) {
        return valorA.doubleValue() > valorB.doubleValue();
    }

    public static boolean maiorIgual(final BigDecimal valorA,final BigDecimal valorB) {
        return valorA.doubleValue() >= valorB.doubleValue();
    }

    public static boolean menorIgual(final BigDecimal valorA,final BigDecimal valorB) {
        return valorA.doubleValue() <= valorB.doubleValue();
    }
}
