
import java.util.LinkedList;
public class LRU extends PageReplacementAlgorithm{

    // this class implements the least recently used algorithm
    // input: pages to get from storage
    // output: the hit / miss status
    //         the 2-dimensional hit/miss matrix for each page requested
    //         the 2-dimensional page frame matrix showing the page contents
    //         other outputs inherited from the PageReplacementAlgorithm class 
    boolean[] hitMatrix;
    int[][] framesMatrix;
    LinkedList<Integer> framesList = new LinkedList<>();// doubly linked list needed to easily perform LRU

    public LRU(int[] pages, int numOfPages, int frameSize){
        super(frameSize);
        framesMatrix = new int[numOfPages][frameSize];
        hitMatrix = new boolean[numOfPages];
        // execute the algorithm
        for(int iter = 0; iter < numOfPages; iter++){
            // check if array is full 
            // if array is full, remove least recently used page first
            if(pageCount == frameCount - 1){
                framesList.remove();
            }
            // if page is found in the linked list don't insert
            Integer pageNum = Integer.valueOf(pages[iter]);
            if(framesList.indexOf(pageNum) != -1){
                hitMatrix[iter] = true;
            }else{
                // else insert it to end of linked list
                framesList.addLast(pageNum);
                if(pageCount < (frameSize - 1)){
                    pageCount++;
                }
                hitMatrix[iter] = false;
            }
            // then save it to the matrix for the iteration
            for(int i = 0; i < frameSize; i++){
                framesMatrix[iter] = framesList.stream().mapToInt(Integer::intValue).toArray();
                pageFrames = framesList.stream().mapToInt(Integer::intValue).toArray();
            }
        }
    }

    public boolean[] getHitMatrix() {
        return hitMatrix;
    }

    public int[][] getFramesMatrix() {
        return framesMatrix;
    }

}