public class PageReplacementAlgorithm{
   int[] pageFrames;
   int pageCount;
   int frameCount;
   int hitCount;
   int missCount;
   Boolean[] hits;
   
   PageReplacementAlgorithm(int frames){
      frameCount = frames;
      pageFrames = new int[frames];
      hits = new Boolean[frames];
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
   
   public Boolean[] getHits(){
       return hits;
   }
}