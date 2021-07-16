public class GoldPlan extends HealthInsurancePlan{
    GoldPlan(){
        setCoverage(0.8);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smokes) {
        double premium = salary * 0.07 + getOfferedBy().computeMonthlyPremium(this, age, smokes);
        return premium;
    }
}
