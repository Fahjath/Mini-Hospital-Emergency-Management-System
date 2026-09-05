public class Main {

    public static void main(String[] args) {

        PatientBST patientBST = new PatientBST();

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

        // Insert patients
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

        patientBST.displayInOrder();

        
    }
}