package br.com.dfmachado.listadefilmes.exceptions;

/**
 *
 * @author diego.felipe
 */
public class GenericCustomException extends RuntimeException {

    private Throwable cause = null;

    public GenericCustomException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public GenericCustomException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        String errorMsg = null;
        String mypack = "br.com.dfmachado";
        for (StackTraceElement e : cause.getStackTrace()) {
            String pack = e.getClassName();
            if (pack.contains(mypack)) {
                errorMsg = "Ocorreu um erro em " + e.getFileName() + ", metodo " + e.getMethodName() + ", linha " + e.getLineNumber()
                        + ": " + cause.getMessage();
                break;
            }
        }
        return errorMsg;
    }
}
