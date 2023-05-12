public class FIFO extends PageReplacementAlgorithm{

    // this class implements the first in first out algorithm
    // input: pages to get from storage
    // output: the hit / miss status
    //         the 2-dimensional hit/miss matrix for each page requested
    //         the 2-dimensional page frame matrix showing the page contents 
    int[][] hitMatrix;
    int[][] framesMatrix;

    public FIFO(int[] pages, int pageCount){
        super(pageCount);
        // execute the algorithm
        int count = 0;    // count for the array
        for(int iter = 0; iter < pageCount; iter++){
            // check if array is full 
            
        }
    }

    public int[][] getHitMatrix() {
        return hitMatrix;
    }

    public int[][] getFramesMatrix() {
        return framesMatrix;
    }
    // for first in first out functionality
    public void removeTop(int[] frames){

    }

}