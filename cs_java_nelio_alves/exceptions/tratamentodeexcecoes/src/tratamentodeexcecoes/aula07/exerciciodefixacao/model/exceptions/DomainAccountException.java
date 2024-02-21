package tratamentodeexcecoes.aula07.exerciciodefixacao.model.exceptions;

public class DomainAccountException extends Exception {
    private static final long serialVersionUID = 1L;

    /*
     * Custom exception
     * */
    public DomainAccountException(String msg) {
        super(msg);
    }

}
