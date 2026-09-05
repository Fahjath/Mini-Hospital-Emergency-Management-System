public class EmergencyQueue {

    private QueueNode front;
    private QueueNode rear;

    public EmergencyQueue() {
        front = null;
        rear = null;
    }

    // Add patient to the emergency queue
    public void enqueue(Patient patient) {

        QueueNode newNode = new QueueNode(patient);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(
                patient.getPatientName()
                + " added to the emergency queue."
        );
    }

    // Remove the next patient from the emergency queue
    public Patient dequeue() {

        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patientToTreat = front.patient;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        System.out.println(
                patientToTreat.getPatientName()
                + " removed from the emergency queue for treatment."
        );

        return patientToTreat;
    }
}