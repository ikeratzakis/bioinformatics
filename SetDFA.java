/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5153;

/**
 *
 * @author Keratz
 */
public class SetDFA {
    String target;
    int pointer;
    public SetDFA(String s)
    {
        target = s; 
        pointer =0;
    }
    void state0() throws TerminateException{
        if (pointer >=target.length())
            throw new TerminateException("Reject -- not found");
        else{
            System.out.println("State 0"); 
            char myChar = target.charAt(0);
            boolean yesLetter = true;
           for (int i=1;i<target.length();i++)
           {
              if(target.charAt(i) != myChar)
              {
                 yesLetter =false;
              }             
           }
           if(yesLetter == true)
           {
               state1();
           }
           else
           {
               throw new TerminateException("Rejected!");
           }
           throw new TerminateException("Bad character in target");
        }
    }
    
    void state1() throws TerminateException{
         System.out.println("State 1");
        throw new TerminateException("Accept");
    }
    
    public static void main(String[] args) {
        if (args.length != 1)
            System.out.println("Usage:java StopDetector string");
        else
        {
            SetDFA sd = new SetDFA(args[0]);
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
class TerminateException extends Exception{
        public TerminateException(String message) {
            System.out.println(message);
        }
    }
