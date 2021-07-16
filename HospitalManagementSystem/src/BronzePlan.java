public class BronzePlan extends HealthInsurancePlan{
    BronzePlan(){
        setCoverage(0.6);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smokes) {
        double premium = salary * 0.05 + getOfferedBy().computeMonthlyPremium(this, age, smokes);
        return premium;
    }
}
