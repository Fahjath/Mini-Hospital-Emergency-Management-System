import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();

        int choice;

        do {

            System.out.println("\n==========================================");
            System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
            System.out.println("==========================================");

            System.out.println("1. Register New Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients");

            System.out.println("5. Add Patient to Emergency Queue");
            System.out.println("6. Treat Next Emergency Patient");
            System.out.println("7. Display Waiting Patients");

            System.out.println("8. Add Completed Treatment");
            System.out.println("9. Remove Latest Treatment");
            System.out.println("10. Display Treatment History");

            System.out.println("11. Add Patient Visit");
            System.out.println("12. Search Patient Visit");
            System.out.println("13. Remove Patient Visit");
            System.out.println("14. Display Patient Visit History");

            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1: {

                    System.out.println("\n--- Register New Patient ---");

                    System.out.print("Enter Patient ID: ");
                    int patientId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();

                    System.out.print("Enter Medical Condition: ");
                    String medicalCondition = scanner.nextLine();

                    Patient newPatient = new Patient(
                            patientId,
                            patientName,
                            age,
                            contactNumber,
                            medicalCondition
                    );

                    patientBST.insert(newPatient);

                    System.out.println("Patient registered successfully.");

                    break;
                }

                case 2: {

                    System.out.println("\n--- Search Patient ---");

                    System.out.print("Enter Patient ID: ");
                    int searchId = Integer.parseInt(scanner.nextLine());

                    Patient foundPatient = patientBST.search(searchId);

                    if (foundPatient != null) {
                        System.out.println("\nPatient found:");
                        System.out.println(foundPatient);
                    } else {
                        System.out.println("Patient not found.");
                    }

                    break;
                }

                case 3: {

                    System.out.println("\n--- Delete Patient ---");

                    System.out.print("Enter Patient ID: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());

                    Patient patientToDelete = patientBST.search(deleteId);

                    if (patientToDelete != null) {

                        patientBST.delete(deleteId);

                        System.out.println(
                                "Patient deleted successfully."
                        );

                    } else {

                        System.out.println("Patient not found.");
                    }

                    break;
                }

                case 4: {

                    System.out.println(
                            "\n--- Display All Patients ---"
                    );

                    patientBST.displayInOrder();

                    break;
                }

                case 5: {

                    System.out.println(
                            "\n--- Add Patient to Emergency Queue ---"
                    );

                    System.out.print("Enter Patient ID: ");
                    int emergencyPatientId =
                            Integer.parseInt(scanner.nextLine());

                    Patient emergencyPatient =
                            patientBST.search(emergencyPatientId);

                    if (emergencyPatient != null) {

                        emergencyQueue.enqueue(emergencyPatient);

                    } else {

                        System.out.println(
                                "Patient not found. Please register the patient first."
                        );
                    }

                    break;
                }

                case 6: {

                    System.out.println(
                            "\n--- Treat Next Emergency Patient ---"
                    );

                    Patient nextPatient =
                            emergencyQueue.dequeue();

                    if (nextPatient != null) {

                        System.out.println(
                                "\nPatient ready for treatment:"
                        );

                        System.out.println(nextPatient);
                    }

                    break;
                }

                case 7: {

                    System.out.println(
                            "\n--- Display Waiting Patients ---"
                    );

                    emergencyQueue.displayQueue();

                    break;
                }

                case 8: {

                    System.out.println(
                            "\n--- Add Completed Treatment ---"
                    );

                    System.out.print("Enter Patient ID: ");
                    int treatmentPatientId =
                            Integer.parseInt(scanner.nextLine());

                    Patient treatmentPatient =
                            patientBST.search(treatmentPatientId);

                    if (treatmentPatient == null) {

                        System.out.println(
                                "Patient not found. Please register the patient first."
                        );

                        break;
                    }

                    System.out.print("Enter Treatment ID: ");
                    int treatmentId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();

                    System.out.print("Enter Treatment Details: ");
                    String treatmentDetails = scanner.nextLine();

                    TreatmentRecord treatmentRecord =
                            new TreatmentRecord(
                                    treatmentId,
                                    treatmentPatient.getPatientId(),
                                    treatmentPatient.getPatientName(),
                                    doctorName,
                                    treatmentDetails
                            );

                    treatmentStack.push(treatmentRecord);

                    System.out.println(
                            "Completed treatment recorded successfully."
                    );

                    break;
                }

                case 9: {

                    System.out.println(
                            "\n--- Remove Latest Treatment ---"
                    );

                    TreatmentRecord removedTreatment =
                            treatmentStack.pop();

                    if (removedTreatment != null) {

                        System.out.println(
                                "\nLatest treatment removed:"
                        );

                        System.out.println(removedTreatment);
                    }

                    break;
                }

                case 0: {

                    System.out.println(
                            "Exiting Hospital Management System..."
                    );

                    break;
                }

                default: {

                    System.out.println(
                            "Option will be implemented next."
                    );
                }
            }

        } while (choice != 0);

        scanner.close();
    }
}