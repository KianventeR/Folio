package src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        for(int iter = 0; iter < numOfPages; iter++){
            // if page is found in the pageFrames array don't insert
            // if page exists, just use it
            if(foundPage(pages[iter])){
                hits[iter] = true;
            }else{
                if(pageCount == frameSize - 1){
                    // if page does not exist, replace the one by priority
                    int frameToClear = -1;
                    // 2. which will be used the farthest in the future
                    int frameFarthest = -1;

                    // 1. which will never be used in the future
                    Set<Integer> intSet = new HashSet<>();

                    for(int i = iter + 1; i < numOfPages; i++){
                        intSet.add(pages[i]);
                    }
                    // check if never used
                    for(int i = 0; i < pageCount; i++){
                        if(!intSet.contains(pageFrames[i])){
                            frameToClear = i;
                            break;
                        }
                    }
                    pageFrames[frameToClear] = pages[iter];
                }else{
                    pageFrames[pageCount] = pages[iter];
                    pageCount++;
                }
                hits[iter] = false;
            }
            // then save it to the matrix for the iteration
            for(int i = 0; i < frameSize; i++){
                framesMatrix[iter][i] = pageFrames[i];
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