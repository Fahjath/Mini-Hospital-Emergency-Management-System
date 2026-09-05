public class Main {

    public static void main(String[] args) {

        // Create Binary Search Tree
        PatientBST patientBST = new PatientBST();

        // Create sample patients
        Patient p1 = new Patient(
                1005,
                "John Silva",
                45,
                "0771234567",
                "Chest Pain"
        );

        Patient p2 = new Patient(
                1002,
                "Mary Perera",
                32,
                "0712345678",
                "Fever"
        );

        Patient p3 = new Patient(
                1008,
                "David Fernando",
                28,
                "0759876543",
                "Injury"
        );

        // Insert patients into BST
        patientBST.insert(p1);
        patientBST.insert(p2);
        patientBST.insert(p3);

        System.out.println("Patients inserted successfully.");

        // Search patient
        Patient foundPatient = patientBST.search(1002);

        if (foundPatient != null) {
            System.out.println("\nPatient found:");
            System.out.println(foundPatient);
        } else {
            System.out.println("\nPatient not found.");
        }

        // Display patients in ascending Patient ID order
        patientBST.displayInOrder();

        // Create Emergency Queue
        EmergencyQueue emergencyQueue = new EmergencyQueue();

        System.out.println("\nEmergency Queue Test:");

        // Add patients to queue
        emergencyQueue.enqueue(p1);
        emergencyQueue.enqueue(p2);
        emergencyQueue.enqueue(p3);

        // Remove next patient for treatment
        System.out.println("\nCalling next patient for treatment:");
        emergencyQueue.dequeue();
    }
}