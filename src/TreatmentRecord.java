public class TreatmentRecord {

    private int treatmentId;
    private int patientId;
    private String patientName;
    private String doctorName;
    private String treatmentDetails;

    public TreatmentRecord(int treatmentId, int patientId,
                           String patientName, String doctorName,
                           String treatmentDetails) {

        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.treatmentDetails = treatmentDetails;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    @Override
    public String toString() {
        return "Treatment ID: " + treatmentId +
               ", Patient ID: " + patientId +
               ", Patient Name: " + patientName +
               ", Doctor: " + doctorName +
               ", Treatment: " + treatmentDetails;
    }
}