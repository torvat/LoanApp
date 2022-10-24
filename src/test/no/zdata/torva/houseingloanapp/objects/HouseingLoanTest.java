package no.zdata.torva.houseingloanapp.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseingLoanTest {

        HouseingLoan loan_1 = new HouseingLoan(1_000_000, 10);
        HouseingLoan loan_2 = new HouseingLoan(0, 10);
        HouseingLoan loan_3 = new HouseingLoan(1_000_000, 30);
        HouseingLoan loan_4 = new HouseingLoan(1_500_000, 15);


        @Test
        void calculation_1() {
            assertEquals(9889, Math.round(loan_1.calculateMonthlyPayment()));
        }
        @Test
        void calculation_2() {
            assertEquals(0, loan_2.calculateMonthlyPayment());
        }
        @Test
        void calculation_3() {
            assertEquals(4490, Math.round(loan_3.calculateMonthlyPayment()));
        }
        @Test
        void calculation_4 () {
            assertEquals(10723, Math.round(loan_4.calculateMonthlyPayment()));
        }
    }
