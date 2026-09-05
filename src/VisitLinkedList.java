public class VisitLinkedList {

    private VisitNode head;

    public VisitLinkedList() {
        head = null;
    }

    // Add a new visit to the patient's history
    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
        } else {

            VisitNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println(
                "Visit " + visit.getVisitId()
                + " added to visit history."
        );
    }

    // Search for a visit using Visit ID
    public Visit searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // Remove a visit using Visit ID
    public boolean removeVisit(int visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return false;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;

            System.out.println(
                    "Visit " + visitId
                    + " removed from visit history."
            );

            return true;
        }

        VisitNode current = head;

        while (current.next != null) {

            if (current.next.visit.getVisitId() == visitId) {

                current.next = current.next.next;

                System.out.println(
                        "Visit " + visitId
                        + " removed from visit history."
                );

                return true;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
        return false;
    }
}