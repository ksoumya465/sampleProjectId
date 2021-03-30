package com.Demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoTest {

	
	static int n1=0,n2=1,n3=0; 
	
	public static void main(String[] args) {
		
		DemoTest demo=new DemoTest();
		
		//String input="empeeloyeemlp";
		//demo.removeDuplicate(input);
		  
		//System.out.print(n1+" "+n2);
		//int count=5;
		//fibnocii(count-2);
		//demo.removeDuplicates(input.toCharArray(),input.toCharArray().length);
		//demo.reverseString() ;
		//demo.isPalindrome();
		//demo.splitValidation();
        demo.printEvenOdd();

	}
	
	/**
	 * "You have a list of numbers from 1 to 10. 
Write code to print out all even and odd numbers. 
But if the num is 7 do not print anything just move to next. 
Example: 1 is odd, 2 is even"
	 */
	public void printEvenOdd() {
		for(int i=1;i<=10;i++) {
			   if(i%2==0) 
			        System.out.println(i+" is even ");
			   else  if(i!=7)
				   System.out.println(i+" is odd");
		}
	}
	
	public void splitValidation()
	{
		String[] mail="soumya@gmail.com".split("@");
		String username="soumya";
		System.out.println(mail[0]+"  ---  "+mail[1]);
		if(mail[0].equals(username))
			System.out.println("It is same");
	}
	
	//How to identify whether a word is palindrome or not
	public void isPalindrome() {
		String word="MNOOMN";
		int length=word.length();
		int count=0;
		
		for(int i=0,j=length-1;i<=((length)/2)-1;i++,j--) {
			if(word.charAt(i)==word.charAt(j)) {
				count++;
				System.out.println("i : "+i+" , j : "+j+" is "+word.charAt(i)+" , count : "+count);
				
			}
		}
		if(count==length/2)
			System.out.println(word+ " is palindrome");
		else
			System.out.println(word+ " is NOT a palindrome");
	}
	
	//Write Fibnocii series
	public static void fibnocii(int count) {
		
		if(count>0) {
			n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(" "+n3);
			fibnocii(count-1);
			
		}
		
	}
	// Remove duplicates from a String using Set
	public void removeDuplicate(String input) {
		Set<Character> charSet=new HashSet<>();
		for(char c: input.toCharArray()) {
			charSet.add(c);
		}
		charSet.forEach(System.out::println);
		
	}
    //Creating removeDuplicates() method to remove duplicates from array  
    public void removeDuplicates(char str[], int length)   
    {   
        //Creating index variable to use it as index in the modified string   
        int index = 0;   
    
        // Traversing character array  
        for (int i = 0; i < length; i++)   
        {   
            // Check whether str[i] is present before or not   
            int j;   
            for (j = 0; j < i; j++)    
            {   
                if (str[i] == str[j])   
                {   
                    break;   
                }   
            }   
            // If the character is not present before, add it to resulting string   
            if (j == i)    
            {   
                str[index++] = str[i];   
            }   
        }   
        System.out.println(str);
        System.out.println(String.valueOf(Arrays.copyOf(str, index)));   
    }   
	
	public void reverseString() {
		
		 StringBuilder input1 = new StringBuilder("Soumya");
		 
		 System.out.println("Reverse a stringBuilder :"+input1);
		 input1.reverse();
		 
		 StringBuffer input2 = new StringBuffer("Aditya");
		 System.out.println(input2+" - Reverse StringBuffer :"+ input2.reverse());
		// print reversed String
	        System.out.println("Reversed String :"+input1);
		 	
		 String name="Soumya";
	        System.out.println("Reverse a String :"+name);
	        
	        char[] nameChars=name.toCharArray();
	        System.out.println(nameChars);
	        for(int i=nameChars.length-1;i>=0;i--) {
	        	 System.out.println(nameChars[i]);
	        }
	        System.out.println(name.indexOf('u'));		
	}
	
	

}
