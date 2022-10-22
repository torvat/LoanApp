package no.zdata.torva.houseingloanapp.objects;

import no.zdata.torva.houseingloanapp.objects.abstracts.Loan;

public class HouseingLoan extends Loan {

    private final double INTREST = 0.035;

    public HouseingLoan(int amount, int duration) {
        super(amount, duration);
    }

    @Override
    public int getAmount(){
        return super.getAmount();
    }

    @Override
    public void setAmount(int amount){
        super.setAmount(amount);
    }

    @Override
    public int getDuration(){
        return super.getDuration();
    }
    @Override
    public void setDuration(int duration){
        super.setDuration(duration);
    }

    @Override
    public double calculateMothlyBackpay(){ //Renters rente er ikke tatt høyde for
        double periods = getDuration() * super.getMONTHS();
        double interest = INTREST/super.getMONTHS();

        return getAmount()*((interest*(Math.pow(1 + interest, periods)))/(Math.pow(1 + interest, periods)-1));
    }

    public String printEstimate(){
        return "" + calculateMothlyBackpay();
    }
}
