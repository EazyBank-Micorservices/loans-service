CREATE TABLE IF NOT EXISTS loans
(
    loan_id            BIGINT       NOT NULL,
    created_at         datetime     NULL,
    created_by         VARCHAR(255) NULL,
    updated_at         datetime     NULL,
    updated_by         VARCHAR(255) NULL,
    mobile_number      VARCHAR(255) NULL,
    loan_number        VARCHAR(255) NULL,
    loan_type          VARCHAR(255) NULL,
    total_loan         INT          NOT NULL,
    amount_paid        INT          NOT NULL,
    outstanding_amount INT          NOT NULL,
    CONSTRAINT pk_loans PRIMARY KEY (loan_id)
);