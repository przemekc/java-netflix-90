package pl.yellowduck.netflix90.exceptions;

public class MojBladException extends Exception {

  public MojBladException(String message) {
    super(message);
  }

  public MojBladException(String message, Throwable cause) {
    super(message, cause);
  }

  public MojBladException(Throwable cause) {
    super(cause);
  }

  public MojBladException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
