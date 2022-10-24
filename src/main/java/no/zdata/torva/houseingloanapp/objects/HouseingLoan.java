package no.zdata.torva.houseingloanapp.objects;

import no.zdata.torva.houseingloanapp.objects.abstracts.Loan;

public class HouseingLoan extends Loan {

    private final double INTREST = 0.035;

    public HouseingLoan(int amount, int duration) {
        super(amount, duration);
    }
    @Override
    public double calculateMonthlyPayment(){ //Renters rente er ikke tatt høyde for
        double interest = INTREST/getMONTHS();
        return super.calculate(((amount, periods) ->
                amount * ((interest * Math.pow(1 + interest, periods)) / (Math.pow(1 + interest, periods) -1 ))));
    }

    public String printEstimate(){
        return "" + Math.round(calculateMonthlyPayment());
    }
}
