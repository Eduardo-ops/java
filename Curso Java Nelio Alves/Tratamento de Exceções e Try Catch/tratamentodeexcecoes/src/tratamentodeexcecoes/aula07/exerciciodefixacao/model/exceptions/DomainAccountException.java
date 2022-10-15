package tratamentodeexcecoes.aula07.exerciciodefixacao.model.exceptions;

/*
 * Poderia ser também extender uma RuntimeException, nesse caso, a RuntimeException
 * não tem a obrigação de ser tratada, nesse caso, não precisa ser "propagada" nos métodos
 * que ficam na classe domain, somente retorna a exceção no método com sua mensagem
 * padrão.
 *
 * public class DomainReservationException extends RuntimeException{}
 * */

public class DomainAccountException extends Exception {
    private static final long serialVersionUID = 1L;

    /*
     * Custom exception
     * */
    public DomainAccountException(String msg) {
        super(msg);
    }

}
