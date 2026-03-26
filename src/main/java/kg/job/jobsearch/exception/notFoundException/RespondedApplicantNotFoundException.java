package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class RespondedApplicantNotFoundException extends NotFoundEntryException {
  public RespondedApplicantNotFoundException() {
    super("Respond not found");
    }
}
