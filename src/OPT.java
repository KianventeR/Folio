package src;
public class OPT extends PageReplacementAlgorithm{

    // this class implements the optimal replacement algorithm
    // input: pages to get from storage
    // output: the hit / miss status
    //         the 2-dimensional hit/miss matrix for each page requested
    //         the 2-dimensional page frame matrix showing the page contents
    //         other outputs inherited from the PageReplacementAlgorithm class 
    boolean[][] hitMatrix;
    int[][] framesMatrix;
    // doubly linked list needed to easily perform OPT

    public OPT(int[] pages, int numOfPages, int frameSize){
        super(frameSize);
        framesMatrix = new int[numOfPages][frameSize];
        hitMatrix = new boolean[numOfPages][frameSize];
        // execute the algorithm
        // if page exists, just use it
        // if page does not exist, replace the one by priority
        // 1. which will never be used in the future
        // 2. which will be used the farthest in the future
    }

    public boolean[][] getHitMatrix() {
        return hitMatrix;
    }

    public int[][] getFramesMatrix() {
        return framesMatrix;
    }

}