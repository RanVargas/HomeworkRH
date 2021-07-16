public class PlatinumPlan extends HealthInsurancePlan{
    PlatinumPlan(){
        setCoverage(0.9);

    }



    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smokes) {
        setOfferedBy(new BlueCrossBlueShield());
        double premium =  0.08 * salary + getOfferedBy().computeMonthlyPremium(this, age, smokes);
        return premium;
    }
}
