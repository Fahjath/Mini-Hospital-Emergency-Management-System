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
}