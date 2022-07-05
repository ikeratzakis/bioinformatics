/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinf517.pkg2;

/**
 *
 * @author Keratz
 */
public class StopDetector2 {

    String target;//target sequence
    int pointer;   //points at specific location of sequence
    //constructor
    public StopDetector2(String s) {
        target = s;
        pointer =0;
    }
    
    //State 0
    void state0() throws TerminateException{
        if (pointer >=target.length())
            throw new TerminateException("Reject -- not found");
        else{           
            System.out.println("State 0");
            char myChar = target.charAt(pointer++); 
            if (myChar == 'a') state1();//First a
            if (myChar == 'c') state0();
            if (myChar == 'g') state0();
            if (myChar == 't') state0();
           throw new TerminateException("Bad character in target");
        }
    }
    //State 1
    void state1() throws TerminateException{
        if (pointer >=target.length())
            throw new TerminateException("Reject -- not found");
        else{             
            System.out.println("State 1");
            char myChar = target.charAt(pointer++); 
            if (myChar == 'a') state2();//Second a
            if (myChar == 'c') state0();
            if (myChar == 'g') state0();
            if (myChar == 't') state0();
            throw new TerminateException("Bad character in target");
            
        }
    }
    //State 2
    void state2() throws TerminateException{
        if (pointer >=target.length())
            throw new TerminateException("Reject -- not found");
        else{ 
        System.out.println("State 2");
            char myChar = target.charAt(pointer++); 
            if (myChar == 'a' && pointer >= target.length())
                state3(); //Third and final a.
            else if(myChar =='a' && pointer <target.length())
                state0();          
            if (myChar == 'c')  state0(); 
            if (myChar == 'g')  state0();
            if (myChar == 't')  state0();
            throw new TerminateException("Bad character in target");
            }
    }
    //State 3(Final)
    void state3() throws TerminateException{
        System.out.println("State 3");
        throw new TerminateException("Accept");
        
    }
    //Required Exception class
    class TerminateException extends Exception{
        public TerminateException(String message) {
            System.out.println(message);
        }
    }
    public static void main(String[] args)
    {
        if (args.length != 1)
            System.out.println("Usage:java StopDetector string");
        else
        {
            StopDetector2 sd = new StopDetector2(args[0]);
            try
            {
                sd.state0();
            }
            catch(TerminateException e)
            {
                //end the execution
            }
        }
    }
    
}
