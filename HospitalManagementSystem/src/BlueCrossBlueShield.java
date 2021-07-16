public class BlueCrossBlueShield implements InsuranceBrand{
    private long id;
    private String name;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smokes) {
        double premiumToPay = 0;

        if (insurancePlan instanceof PlatinumPlan){
            if (age > 55){
                premiumToPay += 200;
            }
            if (smokes){
                premiumToPay += 100;
            }
        }
        else if (insurancePlan instanceof GoldPlan){
            if (age > 55){
                premiumToPay += 150;
            }
            if (smokes){
                premiumToPay += 90;
            }
        }
        else if(insurancePlan instanceof SilverPlan){
            if (age > 55){
                premiumToPay += 100;
            }
            if (smokes){
                premiumToPay += 80;
            }
        }
        else if (insurancePlan instanceof BronzePlan){
            if (age > 55){
                premiumToPay += 50;
            }
            if (smokes){
                premiumToPay += 70;
            }
        }


        return premiumToPay;
    }
}
