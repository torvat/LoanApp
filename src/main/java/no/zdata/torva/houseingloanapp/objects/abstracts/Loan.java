package no.zdata.torva.houseingloanapp.objects.abstracts;

public abstract class Loan {

    private int amount;
    private int duration;
    private final int MONTHS = 12;
    public Loan() {
    }
    public Loan(int amount, int duration) {
        this.amount = amount;
        if(duration <= 0) {
            throw new RuntimeException("Duration cannot be 0 or less");
        }else{
            this.duration = duration;
        }
    }
    public int getMONTHS(){
        return this.MONTHS;
    }

    public double calculateMonthlyPayment(){
        return 0;
    }
    protected double calculate(Calculate calculate){
        int periods = this.duration * this.MONTHS;
        return calculate.monthlyPayment(this.amount, periods);
    }
    @Override
    public String toString() {
        return "Loan: " + "\nAmount: " + this.amount + "\nDuration: " + this.duration;
    }
}
