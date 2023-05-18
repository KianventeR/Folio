
public class FIFO extends PageReplacementAlgorithm{

    // this class implements the first in first out algorithm
    // input: pages to get from storage
    // output: the hit / miss status
    //         the 2-dimensional hit/miss matrix for each page requested
    //         the 2-dimensional page frame matrix showing the page contents
    //         other outputs inherited from the PageReplacementAlgorithm class 
    boolean[] hitMatrix;
    int[][] framesMatrix;

    public FIFO(int[] pages, int numOfPages, int frameSize){
        super(frameSize);
        framesMatrix = new int[numOfPages][frameSize];
        hitMatrix = new boolean[numOfPages];
        // execute the algorithm
        for(int iter = 0; iter < numOfPages; iter++){
            // check if array is full 
            // if array is full, removeTop first
            if(pageCount == frameCount - 1){
                removeTop(pageFrames);
            }
            // if page is found in the pageFrames array don't insert
            if(foundPage(pages[iter])){
                hits[iter] = true;
            }else{
                // else insert it to topmost frame
                pageFrames[pageCount] = pages[iter];
                pageCount++;
                hits[iter] = false;
            }
            // then save it to the matrix for the iteration
            for(int i = 0; i < frameSize; i++){
                framesMatrix[iter][i] = pageFrames[i];
                hitMatrix[iter] = hits[i];
            }
        }
    }

    public boolean[] getHitMatrix() {
        return hitMatrix;
    }

    public int[][] getFramesMatrix() {
        return framesMatrix;
    }
    // for first in first out functionality
    public void removeTop(int[] frames){
        int[] tempArray = frames.clone();
        for(int i = 0; i < frames.length - 1; i++){
            if(i == frames.length - 1){
                // set negative one as the temporary empty value
                frames[i] = -1;
            }else{
                frames[i] = tempArray[i+1];
            }
        }
    }

}