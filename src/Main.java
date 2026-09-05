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

        // ---------------- BST TEST ----------------

        // Insert patients into BST
        patientBST.insert(p1);
        patientBST.insert(p2);
        patientBST.insert(p3);

        System.out.println("Patients inserted successfully.");

        // Search patient by Patient ID
        Patient foundPatient = patientBST.search(1002);

        if (foundPatient != null) {
            System.out.println("\nPatient found:");
            System.out.println(foundPatient);
        } else {
            System.out.println("\nPatient not found.");
        }

        // Display patients in ascending Patient ID order
        patientBST.displayInOrder();


        // ---------------- EMERGENCY QUEUE TEST ----------------

        EmergencyQueue emergencyQueue = new EmergencyQueue();

        System.out.println("\nEmergency Queue Test:");

        // Enqueue patients
        emergencyQueue.enqueue(p1);
        emergencyQueue.enqueue(p2);
        emergencyQueue.enqueue(p3);

        // Dequeue first patient
        System.out.println("\nCalling next patient for treatment:");
        emergencyQueue.dequeue();

        // Display remaining patients
        emergencyQueue.displayQueue();


        // ---------------- EMPTY QUEUE TEST ----------------

        System.out.println("\nEmpty Queue Test:");

        // Remove remaining patients
        emergencyQueue.dequeue();
        emergencyQueue.dequeue();

        // Try to remove from an empty queue
        emergencyQueue.dequeue();
    }
}