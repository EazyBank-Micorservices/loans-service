package org.eazybank.loansservice.constants;

public final class LoanConstants {
    private LoanConstants() {

    }

    public static final String HOME_LOAN = "Home Loan";
    public static final int NEW_LOAN_LIMIT = 1_00_000;
    public static final String STATUS_201 = "201";
    public static final String MESSAGE_201 = "Loan created successfully";
    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "Request processed successfully";
    public static final String STATUS_400 = "400";
    public static final String MESSAGE_400_UPDATE = "Update operation failed. Please try again or contact Dev team";
    public static final String MESSAGE_400_DELETE = "Delete operation failed. Please try again or contact Dev team";
}
