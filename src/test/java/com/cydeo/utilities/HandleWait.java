package com.cydeo.utilities;

public class HandleWait {

    public static void wait(int second){

        try{
           Thread.sleep(second *1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
