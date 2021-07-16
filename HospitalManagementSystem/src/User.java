import java.util.Locale;

public class User {

    private long id;
    // add rest of the variables

    private String firstName;

    private String lasName;

    private String gender;

    private String email;

    private boolean insured;

    private HealthInsurancePlan insurancePlan;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()){
            return;
        }
        this.firstName = firstName;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        if (lasName.isEmpty()){
            return;
        }
        this.lasName = lasName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.isEmpty() || !gender.toUpperCase(Locale.ROOT).equals("M") ||
                !gender.toUpperCase(Locale.ROOT).equals("F")){
            return;
        }
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.isEmpty()){
            return;
        }
        this.email = email;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
    }

    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }

    // add rest of the getters & setters

}