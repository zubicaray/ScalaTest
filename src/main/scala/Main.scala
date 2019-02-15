import scala.io.StdIn

object LogParser extends App {
  
   val viewmode: Int = 4
   val zoom: Int     = 6
   val tailleTuile    = 9
   
   
   def isTile(list:List[String]):Boolean = list match {
     case _::"map"::"1.0"::"slab"::_  => true
     case _ => false
   }
   def printOut(currentViewmode:String,cpt:Int,zoomSet:Set[String])={
     printf("%s\t%d\t%s\n",currentViewmode,cpt,zoomSet.mkString(","))
   }
     
   var line:String  = ""
   var cpt:Int      =0;
   var currentViewmode:String="";
   var zoomSet:Set[String]=Set.empty
     
   while ({line = StdIn.readLine(); line != null}) {
        var array:Array[String]=line.split("/")     

        if ( array.size == tailleTuile && isTile(array.toList)){         
          
          if( currentViewmode=="") currentViewmode=array(viewmode)
          
          if( currentViewmode != array(viewmode) ){
            
            printOut(currentViewmode,cpt,zoomSet)
            currentViewmode=array(viewmode)
            zoomSet=zoomSet.empty
            zoomSet+=array(zoom)
            cpt=1
            
          }
          else{
            zoomSet+=array(zoom)
            cpt+=1
            
          }
          
        }
   }
   if(cpt>0){
     printOut(currentViewmode,cpt,zoomSet)
   }
       
  
}