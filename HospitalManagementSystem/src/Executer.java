public class Executer {
    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);
        var premium = insurancePlan.computeMonthlyPremium(1000, 57, true);

        //double[] payments = Billing.computePaymentAmount(patient, 950);
        //System.out.println("The amount to pay for the insurance " + payments[0]
          //      + " The amount to pay for the client "+ payments[1]);
        System.out.println(premium);
    }
}
