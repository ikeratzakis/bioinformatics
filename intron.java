/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinf516;

/**
 *
 * @author Keratz
 */


  public class intron{
    
    String target;//target sequence
    int pointer;   //points at specific location of string
    //constructor
    public intron(String s) {
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
            if (myChar == 'A') state0();
            if (myChar == 'C') state0();
            if (myChar == 'G') state1();
            if (myChar == 'T') state0();
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
            if (myChar == 'A') state0();
            if (myChar == 'C') state0();
            if (myChar == 'G') state0(); 
            if (myChar == 'T') state2();
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
            if (myChar == 'A') state3();
            if (myChar == 'C') state0();
            if (myChar == 'G') state0(); 
            if (myChar == 'T') state0(); 
            throw new TerminateException("Bad character in target");
            }
    }
    void state3() throws TerminateException{
        if(pointer >=target.length())
            throw new TerminateException("Reject -- not found");
        else
        {
            System.out.println("State 3");
            char myChar = target.charAt(pointer++);
            if (myChar == 'A') state4();
            if (myChar == 'C') state0();
            if (myChar == 'G') state8(); 
            if (myChar == 'T') state0(); 
            throw new TerminateException("Bad character in target");
        }
    }
    void state4() throws TerminateException{
        if(pointer >=target.length())
            throw new TerminateException("Reject -- not found");
        else
        {
            System.out.println("State 4");
            char myChar = target.charAt(pointer++);
            if (myChar == 'A') state4();
            if (myChar == 'C') state5();
            if (myChar == 'G') state0(); 
            if (myChar == 'T') state0(); 
            throw new TerminateException("Bad character in target");
        }
    }
    void state5() throws TerminateException{
        if(pointer >=target.length())
            throw new TerminateException("Reject -- not found");
        else
        {
            System.out.println("State 5");
            char myChar = target.charAt(pointer++);
            if (myChar == 'A') state0();
            if (myChar == 'C') state5();
            if (myChar == 'G') state6(); 
            if (myChar == 'T') state0(); 
            throw new TerminateException("Bad character in target");
        }
    }
    void state6() throws TerminateException{
        if(pointer >=target.length())
            throw new TerminateException("Reject -- not found");
        else
        {
            System.out.println("State 6");
            char myChar = target.charAt(pointer++);
            if (myChar == 'A') state0();
            if (myChar == 'C') state0();
            if (myChar == 'G') state6(); 
            if (myChar == 'T') state7(); 
            throw new TerminateException("Bad character in target");
        }
    }
    void state7() throws TerminateException{
        if(pointer >=target.length())
            throw new TerminateException("Reject -- not found");
        else
        {
            System.out.println("State 7");
            char myChar = target.charAt(pointer++);
            if (myChar == 'A') state3();
            if (myChar == 'C') state0();
            if (myChar == 'G') state0(); 
            if (myChar == 'T') state0(); 
            throw new TerminateException("Bad character in target");
        }
    }
    //State 8(Final)
    void state8() throws TerminateException{
        System.out.println("State 8");
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
            intron sd = new intron(args[0]);
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
    

