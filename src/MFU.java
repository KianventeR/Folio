
import java.util.PriorityQueue;
import java.util.Iterator;

public class MFU extends PageReplacementAlgorithm{

    // this class implements the most frequently used algorithm
    // input: pages to get from storage
    // output: the hit / miss status
    //         the 2-dimensional hit/miss matrix for each page requested
    //         the 2-dimensional page frame matrix showing the page contents
    //         other outputs inherited from the PageReplacementAlgorithm class 
    boolean[][] hitMatrix;
    int[][] framesMatrix;
    // priority queue needed to easily perform MFU
    PriorityQueue<IntegerEntry> queue = new PriorityQueue<>(10, (x,y) -> Integer.compare(y.getFreq(),x.getFreq()));

    public MFU(int[] pages, int numOfPages, int frameSize){
        super(frameSize);
        framesMatrix = new int[numOfPages][frameSize];
        hitMatrix = new boolean[numOfPages][frameSize];
        // execute the algorithm
        for(int iter = 0; iter < numOfPages; iter++){
            // check if array is full 
            // if array is full, remove most frequently used page first
            if(pageCount == frameCount - 1){
                int maxVal = queue.poll().getKey();
                // remove the page with most frequent use
                int index = 0;
                for (int i = 0; i < pageCount; i++){
                    if(pageFrames[i] == maxVal){
                        pageFrames[i] = 0;
                        index = i;
                        break;
                    }
                }
                // move the elements to make space for other values
                for (int i = index; i < frameSize - 1; i++){
                    pageFrames[i] = pageFrames[i+1];
                    // remove the last element
                    if(i == frameSize - 1){
                        pageFrames[i+1] = 0;
                    }
                }
            }
            // if page is found in the priority queue don't insert
            int pageNum = pages[iter];
            Boolean isFound = false;
            Iterator values = queue.iterator();
            while(values.hasNext()){
                IntegerEntry value = ((IntegerEntry) values.next());
                if( value.getKey() == pageNum){
                    hits[iter] = true;
                    isFound = true;
                    // remove the element from queue
                    queue.remove(value);
                    // increment the frequency
                    value.setFreq(value.getFreq() + 1);
                    // insert to priority queue
                    queue.add(value);
                    break;
                }
            }
            
            if(!isFound){
                // else insert it to end of priority queue
                // and page frame array
                queue.add(new IntegerEntry(pageNum, 1));
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