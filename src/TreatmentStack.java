public class TreatmentStack {

    private StackNode top;

    public TreatmentStack() {
        top = null;
    }

    // Add completed treatment record to the stack
    public void push(TreatmentRecord treatmentRecord) {

        StackNode newNode = new StackNode(treatmentRecord);

        newNode.next = top;
        top = newNode;

        System.out.println(
                "Treatment " + treatmentRecord.getTreatmentId()
                + " added to treatment history."
        );
    }

    // Remove the most recently completed treatment record
    public TreatmentRecord pop() {

        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        TreatmentRecord removedRecord = top.treatmentRecord;

        top = top.next;

        System.out.println(
                "Treatment " + removedRecord.getTreatmentId()
                + " removed from treatment history."
        );

        return removedRecord;
    }

    // Display all treatment records
    public void displayStack() {

        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return;
        }

        System.out.println("\nCompleted Treatment Records:");

        StackNode current = top;
        int number = 1;

        while (current != null) {

            System.out.println(
                    number + ". " + current.treatmentRecord
            );

            current = current.next;
            number++;
        }
    }
}