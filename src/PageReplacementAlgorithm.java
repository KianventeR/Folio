
public class PageReplacementAlgorithm{
   int[] pageFrames;
   int pageCount;
   int frameCount;
   int hitCount;
   int missCount;
   boolean[] hits;
   
   PageReplacementAlgorithm(int frames){
      frameCount = frames;
      pageFrames = new int[frames];
      hits = new boolean[frames];
   }
   
   public int[] getPageFrames(){
       return pageFrames;
   }
   
   public int getFrameCount(){
       return frameCount;
   }    
   
   public int getHitCount(){
       return hitCount;
   }
   
   public int getMissCount(){
       return missCount;
   }
   
   public boolean[] getHits(){
       return hits;
   }

   public boolean foundPage(int page){
        boolean found = false;
        for(int i = 0; i < pageFrames.length; i++){
            if(pageFrames[i] == page){
                found = true;
                break;
            }
        }
        return found;
   }
}