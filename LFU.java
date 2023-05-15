import java.util.PriorityQueue;

public class LFU extends PageReplacementAlgorithm{

    // this class implements the least frequently used algorithm
    // input: pages to get from storage
    // output: the hit / miss status
    //         the 2-dimensional hit/miss matrix for each page requested
    //         the 2-dimensional page frame matrix showing the page contents
    //         other outputs inherited from the PageReplacementAlgorithm class 
    boolean[][] hitMatrix;
    int[][] framesMatrix;
    // priority queue needed to easily perform LFU
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public LFU(int[] pages, int numOfPages, int frameSize){
        super(frameSize);
        framesMatrix = new int[numOfPages][frameSize];
        hitMatrix = new boolean[numOfPages][frameSize];
        // execute the algorithm
        // execute the algorithm
        for(int iter = 0; iter < numOfPages; iter++){
            // check if array is full 
            // if array is full, remove least frequently used page first
            if(pageCount == frameCount - 1){
                int minVal = queue.poll();
                // remove the page with least frequency of use
                for (int i = 0; i < pageCount; i++){
                    if(pageFrames[i] == minVal){
                        pageFrames[i] = 0;
                        break;
                    }
                }
            }
            // if page is found in the linked list don't insert
            Integer pageNum = Integer.valueOf(pages[iter]);
            if(queue.contains(pageNum)){
                hits[iter] = true;
            }else{
                // else insert it to end of linked list
                queue.add(pageNum);
                pageFrames[pageCount] = pageNum;
                pageCount++;
                hits[iter] = false;
            }
            // then save it to the matrix for the iteration
            for(int i = 0; i < frameSize; i++){
                framesMatrix[iter] = pageFrames;
                hitMatrix[iter][i] = hits[i];
            }
        }
    }

    public boolean[][] getHitMatrix() {
        return hitMatrix;
    }

    public int[][] getFramesMatrix() {
        return framesMatrix;
    }

}