public class PatientBST {

    private PatientNode root;

    public PatientBST() {
        root = null;
    }

    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    private PatientNode insertRecursive(PatientNode current, Patient patient) {

        if (current == null) {
            return new PatientNode(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRecursive(current.left, patient);

        } else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertRecursive(current.right, patient);

        } else {
            System.out.println("Patient ID already exists.");
        }

        return current;
    }


public Patient search(int patientId) {
    return searchRecursive(root, patientId);
}

private Patient searchRecursive(PatientNode current, int patientId) {

    if (current == null) {
        return null;
    }

    if (patientId == current.patient.getPatientId()) {
        return current.patient;
    }

    if (patientId < current.patient.getPatientId()) {
        return searchRecursive(current.left, patientId);
    }

    return searchRecursive(current.right, patientId);
}
}

