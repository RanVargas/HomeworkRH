public class SilverPlan extends HealthInsurancePlan{
    SilverPlan(){
        setCoverage(0.7);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smokes) {
        double premium = salary * 0.06 + getOfferedBy().computeMonthlyPremium(this, age, smokes);
        return premium;
    }
}
