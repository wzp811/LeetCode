package QuestionList.Coding_Interviews_2th;

import java.util.PriorityQueue;

public class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
    public MedianFinder() {}
    public void addNum(int num) {
        maxQueue.add(num);
        if(maxQueue.size()>minQueue.size()) minQueue.add(maxQueue.poll());
    }
    public double findMedian() {
        if(minQueue.size()==maxQueue.size()) return (double)(minQueue.peek()+maxQueue.peek())/2;
        else return (double)minQueue.peek();
    }
}
