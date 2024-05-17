 package components.priority;

public class priority {
    
 //This function defined  for arrays that store integers to swap
     private static void swap1(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
            }//swap1 function
     
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
//This function defined  for arrays that store String to swap
    private static void swap2(String[] array, int i, int j){
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
         }//swap2 function
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
     public static void rankp(int[] BurstT, int[] priority,String[]processName){
     int nump = BurstT.length;//This line stores the number of elements in the BurstT array in the nump variable
     for(int i=0;i<nump-1;i++){         //This loop arranges process
     for(int j=0; j<nump-i-1;j++){           //This loop Compare priorities
     if(priority[j]>priority[j+1]){               //Order or priority condition
      swap1(priority,j,j+1);                    //The function defined below is for arrays that store integers
           swap1(BurstT,j,j+1);                     //The function defined below is for arrays that store integers
                swap2(processName,j,j+1);               //The function defined below is for arrays that store String
                      }//condition 
                 }//sec loop
              }//firstloop
          }// rankp function
     //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
   public static void countingT(int[] BurstT,int[] priority,String[]processName,int []witintT,int[]turnAroundT){
   int nump = BurstT.length;//This line stores the number of elements in the BurstT array in the nump variable
   int currenttime=0;
    for (int i = 0; i < nump; i++){
            witintT[i] = currenttime; 
            turnAroundT[i] = witintT[i] + BurstT[i]; //calculating the turnAround time
            currenttime = turnAroundT[i]; //After calculating the turnAround time of the current process, the current time is updated to be the turnAround time of the previous process
         }// calculating loop
     }// counting TIME  function
   //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
   public static void finalprint(int[] BurstT, int[] priority, String[] processName,int[] witintT, int[] turnAroundT){
   System.out.println("\nProcessName\tBurstTime\tPriority\tWaitingTime\tTurnAroundTime");
   int nump = BurstT.length;
        for (int i = 0; i < nump; i++){
            System.out.println(processName[i] + "\t\t" +BurstT[i] + "\t\t" + priority[i] + "\t\t" +witintT[i] + "\t\t" + turnAroundT[i]);       
          }//print loop
     }//finalprint function
   //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static double AverageWaitingTime(int[] witintT){
    double totalWaitingTime = 0;//assign the veriable to count total Waiting Time
    //Use a loop to calculate Waiting Time
    for (int i = 0; i < witintT.length; i++) {
        totalWaitingTime += witintT[i];
           }//Waiting Time loop
    return totalWaitingTime / witintT.length;
       }//AverageWaiting Time function
   //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------  
    public static double AverageTurnaroundTime(int[] turnAroundT) {
    double totalTurnaroundTime = 0;//assign the veriable to count total Waiting Time
    for (int i = 0; i < turnAroundT.length; i++) {
        totalTurnaroundTime += turnAroundT[i];
         }//Turnaround Time loop
    return totalTurnaroundTime / turnAroundT.length;
        }//Average Turnaround Time function   
}//class priority