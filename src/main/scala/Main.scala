import scala.io.StdIn

object LogParser extends App {
  
   val viewmode: Int = 4
   val zoom: Int     = 6
   val tailleTuile    = 9
   
   
   def estTuile(list:List[String]):Boolean = list match {
     case _::"map"::"1.0"::"slab"::_  => true
     case _ => false
   }
 
     
   var line:String  = ""
   var cpt:Int      =0;
   var currentViewmode:String="";
   var zoomSet:Set[String]=Set.empty
     
   while ({line = StdIn.readLine(); line != null}) {
        var array:Array[String]=line.split("/")     

        if ( array.size == tailleTuile && estTuile(array.toList)){         
          
          if( currentViewmode=="") currentViewmode=array(viewmode)
          
          if( currentViewmode != array(viewmode) ){
            
            printf("%s\t%d\t%s\n",currentViewmode,cpt,zoomSet.mkString(","))
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
     printf("%s\t%d\t%s\n",currentViewmode,cpt,zoomSet.mkString(","))
   }
       
  
}