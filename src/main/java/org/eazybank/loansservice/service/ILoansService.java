package org.eazybank.loansservice.service;

import org.eazybank.loansservice.dto.LoanDto;

public interface ILoansService {
    /**
     * @param mobileNumber
     */
    void createLoan(String mobileNumber);

    /**
     * @param mobileNumber
     * @return
     */
    LoanDto fetchLoan(String mobileNumber);

    /**
     * @param loanDto
     * @return
     */
    boolean updateLoan(LoanDto loanDto);

    /**
     * @param mobileNumber
     * @return
     */
    boolean deleteLoan(String mobileNumber);
}
