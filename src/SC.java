package src;
public class SC extends PageReplacementAlgorithm{

    // this class implements the second chance algorithm
    // input: pages to get from storage
    // output: the hit / miss status
    //         the 2-dimensional hit/miss matrix for each page requested
    //         the 2-dimensional page frame matrix showing the page contents
    //         other outputs inherited from the PageReplacementAlgorithm class 
    boolean[][] hitMatrix;
    int[][] framesMatrix;
    // circular linked list needed to easily perform SC
    int head; // moving head to mimic a circular queue
    int[] refBits; // reference bits for second chance

    public SC(int[] pages, int numOfPages, int frameSize){
        super(frameSize);
        framesMatrix = new int[numOfPages][frameSize];
        hitMatrix = new boolean[numOfPages][frameSize];
        // execute the algorithm
    }

    public boolean[][] getHitMatrix() {
        return hitMatrix;
    }

    public int[][] getFramesMatrix() {
        return framesMatrix;
    }

    // moves the circular queue head per iteration
    public void moveHead(){
        return (head + 1) % frameSize;
    }

}