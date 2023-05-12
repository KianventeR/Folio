public class FIFO extends PageReplacementAlgorithm{

    // this class implements the first in first out algorithm
    // input: pages to get from storage
    // output: the hit / miss status
    //         the 2-dimensional hit/miss matrix for each page requested
    //         the 2-dimensional page frame matrix showing the page contents 
    int[][] hitMatrix;
    int[][] framesMatrix;

    public FIFO(int[] pages, int numOfPages, int frameSize){
        super(frameSize);
        hitMatrix = new int[numOfPages][frameSize];
        // execute the algorithm
        for(int iter = 0; iter < numOfPages; iter++){
            // check if array is full 
            // if array is full, removeTop first
            if(pageCount == frameCount - 1){
                removeTop(pageFrames);
            }
            // then insert it to topmost frame
            pageFrames[pageCount] = pages[iter];
            pageCount++;
            // then save it to the matrix for the iteration
            for(int i = 0; i < frameSize; i++){
                framesMatrix[iter][i] = pageFrames[i];
            }
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