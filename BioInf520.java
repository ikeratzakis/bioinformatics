/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinf520;

/**
 *
 * @author Keratz
 */
public class BioInf520 {  
    public static void main(String[] args) {
        String x = new String(args[0]);
        String y = new String(args[1]);
        //Print header:
        System.out.print("    ");
        for(int j=0; j<x.length(); j++)
        {
            System.out.print(x.charAt(j)+" ");      
        }
        //and seperator
        System.out.println();
        System.out.println();
        //For each character of second string
        for(int i = 0;i<y.length();i++)
        {
            //print it at left edge of table
            System.out.print("  "+y.charAt(i)+" ");
            //and compare it with each member of the first string
            for (int j =0; j<x.length();j++)
            {
                //print a * if they match;otherwise a space!
                 if(x.charAt(j) == y.charAt(i))
                 {
                     System.out.print("* ");
                 }
                 else if(x.toLowerCase().charAt(j) == 'e' || x.toLowerCase().charAt(j) == 'y' || x.toLowerCase().charAt(j) == 'a'
                           || x.toLowerCase().charAt(j) == 'i' || x.toLowerCase().charAt(j) == 'o' || x.toLowerCase().charAt(j) == 'u')
                 {   
                      if(y.toLowerCase().charAt(i) == 'e' || y.toLowerCase().charAt(i) == 'o'||y.toLowerCase().charAt(i) == 'i'
                               || y.toLowerCase().charAt(i) == 'a' || y.toLowerCase().charAt(i) == 'y' || y.toLowerCase().charAt(i) == 'u')
                         {
                           System.out.print("* ");
                         }    
                      else
                      {
                          System.out.print("  ");
                      }
                 }
               else
               {
                   System.out.print("  ");
               }
                
                          
            }
             System.out.println();
        }
    }}
    

