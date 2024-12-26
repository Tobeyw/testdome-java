// TrainComposition是通过从左侧和右侧连接和拆卸车厢来构建的， 并且可以 节省时间。例如，如果我们先从左侧连接车厢 7，然后再从左侧连接车厢13，
//那么我们就会得到两辆车厢的组合(从左到右依次为 13 和 7)。现在，第一个可以从右侧拆卸的车厢是 7，第一个可以从左侧拆卸的车厢是 13。


public class TrainComposition {
    private Node leftMost;
    private Node rightMost;

    private static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }
    public TrainComposition() {
        this.leftMost = null;
        this.rightMost = null;
    }

    public void attachWagonFromLeft(int wagonId) {
       // throw new UnsupportedOperationException("Waiting to be implemented.");
       Node newNode = new Node(wagonId);
        if (leftMost == null) {
            leftMost = rightMost = newNode;
        } else {
            newNode.next = leftMost;
            leftMost.prev = newNode;
            leftMost = newNode;
        }
    }

    public void attachWagonFromRight(int wagonId) {
        Node newNode = new Node(wagonId);
        if (rightMost == null) {
            leftMost = rightMost = newNode;
        } else {
            newNode.prev = rightMost;
            rightMost.next = newNode;
            rightMost = newNode;
        }
    }

    public int detachWagonFromLeft() {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        if (leftMost == null) {
            throw new IllegalStateException("No wagons to detach from the left.");
        }
        int value = leftMost.value;
        leftMost = leftMost.next;
        if (leftMost == null) {
            rightMost = null;
        } else {
            leftMost.prev = null;
        }
        return value;
    }

    public int detachWagonFromRight() {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        if (rightMost == null) {
            throw new IllegalStateException("No wagons to detach from the right.");
        }
        int value = rightMost.value;
        rightMost = rightMost.prev;
        if (rightMost == null) {
            leftMost = null;
        } else {
            rightMost.next = null;
        }
        return value;
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7 
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}