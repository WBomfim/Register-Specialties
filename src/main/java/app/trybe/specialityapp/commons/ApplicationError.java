package app.trybe.specialityapp.commons;

/**
 * Class ApplicationError.
 *
 */
public class ApplicationError {
  private int status;
  private String message;

  public ApplicationError(int status, String message) {
    this.status = status;
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
