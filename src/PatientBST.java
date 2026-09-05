public class PatientBST {

    private PatientNode root;

    public PatientBST() {
        root = null;
    }

    // Insert a new patient
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

    // Search patient using Patient ID
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

    // Delete patient using Patient ID
    public void delete(int patientId) {
        root = deleteRecursive(root, patientId);
    }

    private PatientNode deleteRecursive(PatientNode current, int patientId) {

        if (current == null) {
            System.out.println("Patient not found.");
            return null;
        }

        if (patientId < current.patient.getPatientId()) {

            current.left = deleteRecursive(current.left, patientId);

        } else if (patientId > current.patient.getPatientId()) {

            current.right = deleteRecursive(current.right, patientId);

        } else {

            // Case 1: Node has no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: Node has only right child
            if (current.left == null) {
                return current.right;
            }

            // Case 3: Node has only left child
            if (current.right == null) {
                return current.left;
            }

            // Case 4: Node has two children
            PatientNode smallestNode = findSmallestNode(current.right);

            current.patient = smallestNode.patient;

            current.right = deleteRecursive(
                    current.right,
                    smallestNode.patient.getPatientId()
            );
        }

        return current;
    }

    // Find smallest node in a subtree
    private PatientNode findSmallestNode(PatientNode node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
    
 // Display all patients in ascending order of Patient ID
    public void displayInOrder() {

        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }

        System.out.println("\nPatients in ascending order of Patient ID:");
        inOrderRecursive(root);
    }

    private void inOrderRecursive(PatientNode current) {

        if (current != null) {

            inOrderRecursive(current.left);

            System.out.println(current.patient);

            inOrderRecursive(current.right);
        }
    }
}