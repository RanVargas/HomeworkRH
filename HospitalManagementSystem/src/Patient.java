public class Patient extends User{
    private long patientId;

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        if (patientId == 0){
            return;
        }
        this.patientId = patientId;
    }

}
