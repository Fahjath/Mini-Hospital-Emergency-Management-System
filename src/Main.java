import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();

        int choice;

        do {

            System.out.println("\n==================================================");
            System.out.println("      MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
            System.out.println("==================================================");

            System.out.println("\n[ PATIENT MANAGEMENT ]");
            System.out.println("1. Register New Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients");

            System.out.println("\n[ EMERGENCY QUEUE ]");
            System.out.println("5. Add Patient to Emergency Queue");
            System.out.println("6. Treat Next Emergency Patient");
            System.out.println("7. Display Waiting Patients");

            System.out.println("\n[ TREATMENT HISTORY ]");
            System.out.println("8. Add Completed Treatment");
            System.out.println("9. Remove Latest Treatment");
            System.out.println("10. Display Treatment History");

            System.out.println("\n[ PATIENT VISIT HISTORY ]");
            System.out.println("11. Add Patient Visit");
            System.out.println("12. Search Patient Visit");
            System.out.println("13. Remove Patient Visit");
            System.out.println("14. Display Patient Visit History");

            System.out.println("\n0. Exit");

            System.out.println("--------------------------------------------------");
            System.out.print("Enter your choice: ");

            try {

                choice = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println(
                        "\n[ERROR] Invalid input. Please enter a number from 0 to 14."
                );

                choice = -1;
                continue;
            }

            switch (choice) {

                case 1: {

                    System.out.println("\n==================================");
                    System.out.println("       REGISTER NEW PATIENT");
                    System.out.println("==================================");

                    System.out.print("Enter Patient ID: ");
                    int patientId =
                            Integer.parseInt(scanner.nextLine());

                    if (patientBST.search(patientId) != null) {

                        System.out.println(
                                "\n[WARNING] Patient ID already exists."
                        );
                        System.out.println(
                                "Please use a different Patient ID."
                        );

                        break;
                    }

                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age =
                            Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();

                    System.out.print("Enter Medical Condition: ");
                    String medicalCondition = scanner.nextLine();

                    Patient newPatient =
                            new Patient(
                                    patientId,
                                    patientName,
                                    age,
                                    contactNumber,
                                    medicalCondition
                            );

                    patientBST.insert(newPatient);

                    System.out.println(
                            "\n[SUCCESS] Patient registered successfully."
                    );

                    break;
                }


                case 2: {

                    System.out.println("\n==================================");
                    System.out.println("          SEARCH PATIENT");
                    System.out.println("==================================");

                    System.out.print("Enter Patient ID: ");
                    int searchId =
                            Integer.parseInt(scanner.nextLine());

                    Patient foundPatient =
                            patientBST.search(searchId);

                    if (foundPatient != null) {

                        System.out.println("\nPatient found:");
                        System.out.println("----------------------------------");
                        System.out.println(foundPatient);

                    } else {

                        System.out.println(
                                "\n[INFO] Patient not found."
                        );
                    }

                    break;
                }


                case 3: {

                    System.out.println("\n==================================");
                    System.out.println("          DELETE PATIENT");
                    System.out.println("==================================");

                    System.out.print("Enter Patient ID: ");
                    int deleteId =
                            Integer.parseInt(scanner.nextLine());

                    Patient patientToDelete =
                            patientBST.search(deleteId);

                    if (patientToDelete != null) {

                        patientBST.delete(deleteId);

                        System.out.println(
                                "\n[SUCCESS] Patient deleted successfully."
                        );

                    } else {

                        System.out.println(
                                "\n[INFO] Patient not found."
                        );
                    }

                    break;
                }


                case 4: {

                    System.out.println("\n==================================");
                    System.out.println("       ALL PATIENT RECORDS");
                    System.out.println("==================================");

                    patientBST.displayInOrder();

                    break;
                }


                case 5: {

                    System.out.println("\n==================================");
                    System.out.println("      ADD TO EMERGENCY QUEUE");
                    System.out.println("==================================");

                    System.out.print("Enter Patient ID: ");
                    int emergencyPatientId =
                            Integer.parseInt(scanner.nextLine());

                    Patient emergencyPatient =
                            patientBST.search(emergencyPatientId);

                    if (emergencyPatient != null) {

                        emergencyQueue.enqueue(emergencyPatient);

                    } else {

                        System.out.println(
                                "\n[INFO] Patient not found."
                        );

                        System.out.println(
                                "Please register the patient first."
                        );
                    }

                    break;
                }


                case 6: {

                    System.out.println("\n==================================");
                    System.out.println("     TREAT NEXT EMERGENCY PATIENT");
                    System.out.println("==================================");

                    Patient nextPatient =
                            emergencyQueue.dequeue();

                    if (nextPatient != null) {

                        System.out.println(
                                "\nPatient ready for treatment:"
                        );

                        System.out.println("----------------------------------");
                        System.out.println(nextPatient);
                    }

                    break;
                }


                case 7: {

                    System.out.println("\n==================================");
                    System.out.println("        WAITING PATIENTS");
                    System.out.println("==================================");

                    emergencyQueue.displayQueue();

                    break;
                }


                case 8: {

                    System.out.println("\n==================================");
                    System.out.println("      ADD COMPLETED TREATMENT");
                    System.out.println("==================================");

                    System.out.print("Enter Patient ID: ");
                    int treatmentPatientId =
                            Integer.parseInt(scanner.nextLine());

                    Patient treatmentPatient =
                            patientBST.search(treatmentPatientId);

                    if (treatmentPatient == null) {

                        System.out.println(
                                "\n[INFO] Patient not found."
                        );

                        System.out.println(
                                "Please register the patient first."
                        );

                        break;
                    }

                    System.out.print("Enter Treatment ID: ");
                    int treatmentId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Doctor Name: ");
                    String doctorName =
                            scanner.nextLine();

                    System.out.print("Enter Treatment Details: ");
                    String treatmentDetails =
                            scanner.nextLine();

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
                            "\n[SUCCESS] Completed treatment recorded successfully."
                    );

                    break;
                }


                case 9: {

                    System.out.println("\n==================================");
                    System.out.println("       REMOVE LATEST TREATMENT");
                    System.out.println("==================================");

                    TreatmentRecord removedTreatment =
                            treatmentStack.pop();

                    if (removedTreatment != null) {

                        System.out.println(
                                "\nLatest treatment removed:"
                        );

                        System.out.println("----------------------------------");
                        System.out.println(removedTreatment);
                    }

                    break;
                }


                case 10: {

                    System.out.println("\n==================================");
                    System.out.println("        TREATMENT HISTORY");
                    System.out.println("==================================");

                    treatmentStack.displayStack();

                    break;
                }


                case 11: {

                    System.out.println("\n==================================");
                    System.out.println("         ADD PATIENT VISIT");
                    System.out.println("==================================");

                    System.out.print("Enter Patient ID: ");
                    int visitPatientId =
                            Integer.parseInt(scanner.nextLine());

                    Patient visitPatient =
                            patientBST.search(visitPatientId);

                    if (visitPatient == null) {

                        System.out.println(
                                "\n[INFO] Patient not found."
                        );

                        System.out.println(
                                "Please register the patient first."
                        );

                        break;
                    }

                    System.out.print("Enter Visit ID: ");
                    int visitId =
                            Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Visit Date: ");
                    String visitDate =
                            scanner.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String visitDoctorName =
                            scanner.nextLine();

                    System.out.print("Enter Diagnosis: ");
                    String diagnosis =
                            scanner.nextLine();

                    System.out.print("Enter Treatment: ");
                    String visitTreatment =
                            scanner.nextLine();

                    Visit newVisit =
                            new Visit(
                                    visitId,
                                    visitDate,
                                    visitDoctorName,
                                    diagnosis,
                                    visitTreatment
                            );

                    visitPatient
                            .getVisitHistory()
                            .addVisit(newVisit);

                    System.out.println(
                            "\n[SUCCESS] Patient visit recorded successfully."
                    );

                    break;
                }


                case 12: {

                    System.out.println("\n==================================");
                    System.out.println("        SEARCH PATIENT VISIT");
                    System.out.println("==================================");

                    System.out.print("Enter Patient ID: ");
                    int searchVisitPatientId =
                            Integer.parseInt(scanner.nextLine());

                    Patient searchVisitPatient =
                            patientBST.search(searchVisitPatientId);

                    if (searchVisitPatient == null) {

                        System.out.println(
                                "\n[INFO] Patient not found."
                        );

                        break;
                    }

                    System.out.print("Enter Visit ID: ");
                    int searchVisitId =
                            Integer.parseInt(scanner.nextLine());

                    Visit searchedVisit =
                            searchVisitPatient
                                    .getVisitHistory()
                                    .searchVisit(searchVisitId);

                    if (searchedVisit != null) {

                        System.out.println("\nVisit found:");
                        System.out.println("----------------------------------");
                        System.out.println(searchedVisit);

                    } else {

                        System.out.println(
                                "\n[INFO] Visit not found."
                        );
                    }

                    break;
                }


                case 13: {

                    System.out.println("\n==================================");
                    System.out.println("        REMOVE PATIENT VISIT");
                    System.out.println("==================================");

                    System.out.print("Enter Patient ID: ");
                    int removeVisitPatientId =
                            Integer.parseInt(scanner.nextLine());

                    Patient removeVisitPatient =
                            patientBST.search(removeVisitPatientId);

                    if (removeVisitPatient == null) {

                        System.out.println(
                                "\n[INFO] Patient not found."
                        );

                        break;
                    }

                    System.out.print("Enter Visit ID: ");
                    int removeVisitId =
                            Integer.parseInt(scanner.nextLine());

                    boolean removed =
                            removeVisitPatient
                                    .getVisitHistory()
                                    .removeVisit(removeVisitId);

                    if (removed) {

                        System.out.println(
                                "\n[SUCCESS] Patient visit removed successfully."
                        );
                    }

                    break;
                }


                case 14: {

                    System.out.println("\n==================================");
                    System.out.println("       PATIENT VISIT HISTORY");
                    System.out.println("==================================");

                    System.out.print("Enter Patient ID: ");
                    int displayVisitPatientId =
                            Integer.parseInt(scanner.nextLine());

                    Patient displayVisitPatient =
                            patientBST.search(displayVisitPatientId);

                    if (displayVisitPatient == null) {

                        System.out.println(
                                "\n[INFO] Patient not found."
                        );

                        break;
                    }

                    System.out.println(
                            "\nVisit History for "
                                    + displayVisitPatient.getPatientName()
                                    + ":"
                    );

                    displayVisitPatient
                            .getVisitHistory()
                            .displayVisits();

                    break;
                }


                case 0: {

                    System.out.println("\n==================================================");
                    System.out.println("        HOSPITAL MANAGEMENT SYSTEM CLOSED");
                    System.out.println("==================================================");

                    break;
                }


                default: {

                    System.out.println(
                            "\n[ERROR] Invalid option. Please select a number from 0 to 14."
                    );
                }
            }

        } while (choice != 0);

        scanner.close();
    }
}