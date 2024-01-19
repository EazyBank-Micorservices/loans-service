package org.eazybank.loansservice.service.impl;

import lombok.AllArgsConstructor;
import org.eazybank.loansservice.constants.LoanConstants;
import org.eazybank.loansservice.dto.LoanDto;
import org.eazybank.loansservice.exception.LoanAlreadyExistsException;
import org.eazybank.loansservice.exception.ResourceNotFoundException;
import org.eazybank.loansservice.mapper.LoanMapper;
import org.eazybank.loansservice.model.Loan;
import org.eazybank.loansservice.repository.LoansRepository;
import org.eazybank.loansservice.service.ILoansService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private final LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loan> optionalLoans= loansRepository.findByMobileNumber(mobileNumber);
        if(optionalLoans.isPresent()){
            throw new LoanAlreadyExistsException("Loan already registered with given mobileNumber "+mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    private Loan createNewLoan(String mobileNumber) {
        Loan newLoan = new Loan();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoanConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    @Override
    public LoanDto fetchLoan(String mobileNumber) {
        Loan loan = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoanMapper.mapToLoansDto(loan, new LoanDto());
    }

    @Override
    public boolean updateLoan(LoanDto loanDto) {
        Loan loans = loansRepository.findByLoanNumber(loanDto.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loanDto.getLoanNumber()));
        LoanMapper.mapToLoans(loanDto, loans);
        loansRepository.save(loans);
        return  true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loan loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loansRepository.deleteById(loans.getLoanId());
        return true;
    }
}
