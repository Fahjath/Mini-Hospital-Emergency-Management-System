public class Main {

    public static void main(String[] args) {

        // ---------------- CREATE SAMPLE PATIENTS ----------------

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

        PatientBST patientBST = new PatientBST();

        patientBST.insert(p1);
        patientBST.insert(p2);
        patientBST.insert(p3);

        System.out.println("Patients inserted successfully.");

        Patient foundPatient = patientBST.search(1002);

        if (foundPatient != null) {
            System.out.println("\nPatient found:");
            System.out.println(foundPatient);
        } else {
            System.out.println("\nPatient not found.");
        }

        patientBST.displayInOrder();


        // ---------------- EMERGENCY QUEUE TEST ----------------

        EmergencyQueue emergencyQueue = new EmergencyQueue();

        System.out.println("\nEmergency Queue Test:");

        emergencyQueue.enqueue(p1);
        emergencyQueue.enqueue(p2);
        emergencyQueue.enqueue(p3);

        System.out.println("\nCalling next patient for treatment:");
        emergencyQueue.dequeue();

        emergencyQueue.displayQueue();


        // ---------------- EMPTY QUEUE TEST ----------------

        System.out.println("\nEmpty Queue Test:");

        emergencyQueue.dequeue();
        emergencyQueue.dequeue();

        // Try to remove from empty queue
        emergencyQueue.dequeue();


        // ---------------- TREATMENT STACK TEST ----------------

        TreatmentStack treatmentStack = new TreatmentStack();

        TreatmentRecord t1 = new TreatmentRecord(
                1,
                1005,
                "John Silva",
                "Dr. Perera",
                "ECG Examination"
        );

        TreatmentRecord t2 = new TreatmentRecord(
                2,
                1002,
                "Mary Perera",
                "Dr. Fernando",
                "Fever Medication"
        );

        TreatmentRecord t3 = new TreatmentRecord(
                3,
                1008,
                "David Fernando",
                "Dr. Silva",
                "Wound Dressing"
        );

        System.out.println("\nTreatment Stack Test:");

        // Push completed treatment records
        treatmentStack.push(t1);
        treatmentStack.push(t2);
        treatmentStack.push(t3);

        // Pop most recently completed treatment
        System.out.println("\nRemoving latest treatment:");
        treatmentStack.pop();
    }
}