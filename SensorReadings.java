import java.util.Scanner;
/**
 * Sensor Readings (7.1PP Array of Objects)
 * 
 * @author Abhishek Tamang
 */


public class SensorReadings{
    
    public static readingDatas[] addBulk(int CAPACITY,int numReadings,Scanner sc,int count){
        
        
        readingDatas[] data = new readingDatas[CAPACITY];//dec3laring array of Readingdata objects.
        //iterating through num readings to add new ReadingData objects to array of its objects
        for(int i=0;i<numReadings;i++){
        
            addReadingData(sc,count,data);            
        }
        return data;
    }
    
    //This method prints all the content of the objects of the array.
    public static void printAll(readingDatas[] data,int count){
        for(int i=0;i<count;i++){
            System.out.println(data[ i]);
            
            
        }
    }
    
    //This method adds a custom type of object as of the user's choice to the array
    public static int addReadingData(Scanner sc,int count,readingDatas[] data){
        String annotation;//String variable name for sensors
        int readingId;//reading identification number of the sensors
        double value;//reading value of the sensor
        if(count<data.length)
        {
            do{    
                System.out.println("Enter the the sensor's name whose value you want to find:"); 
                annotation = sc.next();//Taking user's choice of String input for the annotation variable
                
            }while(annotation.length() <= 15);
            
            System.out.println("Enter the reading id of the sensor?");
            readingId = sc.nextInt();//Taking user's choice of integer input for the readingId variable
            System.out.println("Enter the Value of the sensor?");
            value = sc.nextDouble();//Taking user's choice of  input for the value variable
            
            data[count]= new readingDatas(annotation,readingId,value);
            count = count + 1;
            return count;
        }else{
            System.out.println("No more space available to add a new object.");
        }
        return count;
    }
    
    //This method returns the average value of the sensor readings of different objects input.
    public static double averageReading(readingDatas[] data,int numReadings){
        double averageValue = 0.0;//variable to store average value of user input sensor data
        for(int i = 0;i<numReadings;i++){
            averageValue =  averageValue + data[i].value;
        }
        averageValue = (double)averageValue/numReadings;
        return averageValue;
    }
    
    
    //This method returns the largest value among the sensor readings of different objects input.
    public static double largestReading(readingDatas[] data,int numReadings){
        double largestValue = data[0].value;//variable to store largest value of user input sensor data
        for(int i = 1;i< numReadings;i++){
            
            if (largestValue> data[i].value){
                largestValue =  largestValue;
            }else{
                largestValue = data[i].value;
            }
        }
        return largestValue;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        final int CAPACITY = 50;//maximum no. of objects the array can hold.
        int count = 0;//To keep the count of how many objects are already in the array.
        String choice = null;// To know whether the user wants to continue or quit the program.
        int numReadings = 0;//To let choose the user how many values the user wants to enter in bulk initially.
        int menuNum = 0;//option to choose menu items.
        
        
        System.out.println("Sensor Readings:");
        readingDatas[] data;// declaring a new arraof readingDatas class called data
        System.out.println("How many Sensor reading values do you want to enter in bulk initially?\n");
        numReadings = sc.nextInt();
        numReadings = Math.min(numReadings,CAPACITY);
        data = addBulk(CAPACITY,numReadings,sc,count);
        System.out.println("Do you want to start the menu bar: yes or quit \n");
        choice = sc.next();
        
        do{
            System.out.println("1: Add a new object for new sensor");
            System.out.println("2: Display all the readings of sensor");
            System.out.println("3: Displays the average value among different sensor's readings");
            System.out.println("4: Displays the Largest value among different sensor's readings");
            System.out.println("5: Quit");
            System.out.println("Choose a number(1-5) to select your desired menu item:");
            menuNum = sc.nextInt();
            switch(menuNum){
                
                case 1:  //add a new custom object to the array
                    System.out.println("Adding another ReadingData object: ");
                    count = addReadingData(sc,count,data);
                    break;
                    
                case 2: //Display all readings.
                    printAll(data,count);
                    break;
                    
                case 3: //Display average reading.
                    System.out.println("The average value of sensor reading's is: "+averageReading(data,numReadings));
                    break;
                    
                case 4://Display Largest reading.
                    System.out.println("The Largest value of sensor reading's is: "+largestReading(data,numReadings)); 
                    break;
                    
                case 5: 
                    choice = "quit";
                    //quit..Terminate the program.         
            };
        }while(!choice.equals("quit"));
        
    }
}

