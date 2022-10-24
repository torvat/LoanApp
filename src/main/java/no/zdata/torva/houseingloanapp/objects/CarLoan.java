package no.zdata.torva.houseingloanapp.objects;

import no.zdata.torva.houseingloanapp.objects.abstracts.Loan;

public class CarLoan extends Loan {
    private final double INTREST = 0.12;

    public CarLoan(int amount, int duration) {
        super(amount, duration);
    }

    @Override
    public double calculateMonthlyPayment() {
        double interest = INTREST/getMONTHS();
        return super.calculate(((amount, periods) ->
                amount * ((interest * Math.pow(1 + interest, periods)) / (Math.pow(1 + interest, periods) - 1))));
    }
}
