package com.amasp.lansha.network;

/**
 *
 * @author knovengel
 */

///
/// This will be a Always running thread.
/// Sends a heartbeat every fixed interval to check for online devices.
///
public class HeartBeatSender {
    private int bpm = 4;    //  heartbeat sent every 15 secs.
    
    private void startBeats(){
        while(true){
            //  send a heartbeat
            try{
                wait((60/bpm)*1000);    //  wait for some time
            }catch(InterruptedException e){
                System.out.println("Interrupted Exception caused in HeartBeatSender...");
                e.printStackTrace();
            }
            
        }
    }

    public HeartBeatSender() {
        startBeats();
    }
}
