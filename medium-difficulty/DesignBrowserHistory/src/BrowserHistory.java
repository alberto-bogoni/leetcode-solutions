class BrowserHistory {

    class Node {
        Node prev;
        Node next;
        String val;

        public Node(String val) {
            this.val = val;
        }
    }

    Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        curr.next = null;

        Node nextPage = new Node(url);
        nextPage.prev = curr;

        curr.next = nextPage;
        curr = nextPage;
    }

    public String back(int steps) {
        int count = 0;

        while (curr.prev != null && count != steps) {
            curr = curr.prev;
            count++;
        }

        return curr.val;
    }

    public String forward(int steps) {
        int count = 0;

        while (curr.next != null && count != steps) {
            curr = curr.next;
            count++;
        }

        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */