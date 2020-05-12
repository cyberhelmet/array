
import java.util.Scanner;
public class readingDatas{
    //Getter method for instance variable annotation.
    
    String annotation;
    int readingId;
    double value;
  
    public readingDatas(String annotation,int readingId,double vaue){
    
        this.annotation = annotation;
        this.readingId = readingId;
        this.value = value;
       
    }
  
    public String getAnnotation()
    {
        return annotation;
    }
    
    //Getter method  for instance variable readingId.
    public int getReadingId()
    {
        return readingId;
    }
    
    //Setter method  for instance variable readingId initializing it with value id.
    public void setReading(int id){
        readingId = id;   
    }
    
    //Getter method  for instance variable getValue.
    public double getValue(){
        return value;   
    }
    
    //Setter method for instance variable value.
    public void setValue(double value){
        this.value = value;   
    }
    
    //toString method for the Reading class objects for generating the string representaion of them.
    public String toString()
    {
        String message = null;// initaializing a string with null value used for returning a string representation. 
        if(value == 0){
            return message = "# "+readingId+": "+value+"("+annotation+")" +" check sensor";
        }
        else {if(value > 100){
            return message =  "# "+readingId+": "+value+"("+annotation+")" +" check reading";
        }
        else{
        return message =  "# "+readingId+": "+value+"("+annotation+")";
        }
        
        }
    }
}
