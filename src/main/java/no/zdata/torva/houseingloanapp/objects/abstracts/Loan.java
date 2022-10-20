package no.zdata.torva.houseingloanapp.objects.abstracts;

public abstract class Loan {

    private int amount;
    private int duration;

    public Loan() {
    }

    public Loan(int amount, int duration) {
        this.amount = amount;
        setDuration(duration);
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration){
        if(duration <= 0) {
            throw new RuntimeException("Duration cannot be 0 or less");
        }else{
            this.duration = duration;
        }
    }

    public double calculateMothlyBackpay(){
        double periods = this.duration * 12;
        double installments = this.amount / periods;
        double intrest = installments * 3.5;

        return installments + (intrest * 3.5);
    }
}
