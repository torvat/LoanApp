package no.zdata.torva.houseingloanapp.objects.abstracts;

@FunctionalInterface
public interface Calculate {
    double monthlyPayment(int amount, int periods);
}
