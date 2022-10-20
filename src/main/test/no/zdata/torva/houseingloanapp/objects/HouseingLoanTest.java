package no.zdata.torva.houseingloanapp.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseingLoanTest {

    HouseingLoan loan_1 = new HouseingLoan(1_000_000, 10);
    HouseingLoan loan_2 = new HouseingLoan(0, 10);
    HouseingLoan loan_3 = new HouseingLoan(1_000_000, 0);
    HouseingLoan loan_4 = new HouseingLoan(10, 1);
    HouseingLoan loan_5 = new HouseingLoan(1_500_000, 15);


    @Test
    void calculation_1() {
        assertEquals(8625, loan_1.calculateMothlyBackpay());
    }
    @Test

    void calculation_2() {
        assertEquals(0, loan_2.calculateMothlyBackpay());
    }
    @Test
    void calculation_3() {
        Exception exception = assertThrows(RuntimeException.class, () -> loan_3.calculateMothlyBackpay());

        String expectedMessage = "Duration cannot be 0 or less";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test

    void calculation_4 () {
        assertEquals(0.8625, loan_4.calculateMothlyBackpay());
    }
    @Test

    void calculation_5 () {
        assertEquals(8625, loan_5.calculateMothlyBackpay());

    }
}
