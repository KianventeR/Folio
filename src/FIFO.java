
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
            // if page is found in the pageFrames array don't insert
            
            if(foundPage(pages[iter],iter)){
                hits[0] = true;
                hitCount++;
            }else{
                // else insert it to topmost frame
                if(pageCount < (frameSize - 1)){
                    pageCount++;
                }
                removeBottom(pageFrames);
                pageFrames[0] = pages[iter];
                hits[0] = false;
                missCount++;
            }
            // then save it to the matrix for the iteration
            for(int i = 0; i < frameSize; i++){
                framesMatrix[iter][i] = pageFrames[i];
                hitMatrix[iter] = hits[0];
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
    public void removeBottom(int[] frames){
        int[] tempArray = frames.clone();
        for(int i = frames.length -1; i > 0; i--){
            // push up contents to proper places
            frames[i] = tempArray[i-1];
        }
        frames[0] = -1; // remove bottom
    }

}