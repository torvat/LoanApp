package no.zdata.torva.houseingloanapp.objects;

import no.zdata.torva.houseingloanapp.objects.abstracts.Loan;

public class HouseingLoan extends Loan {

    private final double INTREST = 0.035;

    public HouseingLoan(){
    }

    public HouseingLoan(int amount, int duration) {
        super(amount, duration);
    }

    public double getINTREST() {
        return INTREST;
    }

    @Override
    public double calculateMothlyBackpay(){ //Renters rente er ikke tatt høyde for
        double periods = super.getDuration() * 12;
        double installments = super.getAmount() / periods;
        double interest = installments * INTREST;

        return installments + interest;
    }

    @Override
    public String toString() {
        return "" + calculateMothlyBackpay();
    }
}
