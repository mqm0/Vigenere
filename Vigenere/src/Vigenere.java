/*The MIT License (MIT)

Copyright (c) 2015 Muhammad Alhadi B.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.*/

public class Vigenere {
	
    static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static String strin;
    static String key;
    
	public static void main(String[] args) {

		strin= "test de vigenere"; 
		key= "cle";
		String strout= "";

		matchinKey();
		System.out.println(strin);
		System.out.println(key);
		
		for(int loop=0; loop< strin.length(); loop++)
			strout+= vCrypt(strin.charAt(loop), key.charAt(loop));
			System.out.println(strout);
			
			String str= "vpwvoixtkgyitp"; 
			strout= "";

			System.out.println(str);
			System.out.println(key);	
			
		for(int loop=0; loop< str.length(); loop++)
			strout+= vDecrypt(str.charAt(loop), key.charAt(loop));
			System.out.print(strout);	
		
	}
	
	//For adapting the key with the phrase which we want to encrypt
	//Ignoring white spaces, and repeating the key throughout the phrase
	public static void matchinKey(){
		
		strin= strin.replace(" ", "");
		
		int rep= strin.length()/ key.length(), 
			rem= strin.length()% key.length();
		String tmp= "";
			
		for(int i= 0;i< rep; i++)
			tmp+= key;
		
		for(int i= 0;i< rem; i++)
			tmp+= key.charAt(i);
		
		key= tmp;
	}
	
	//Taking a character from the phrase and its correspondent one from the key 
	//Then looking for the crossing one from Vigenere table  
	public static char vCrypt(char tocrypt, char ckey){
		int post= 0, posk= 0, posr= 0;
		
		while(alphabet[post]!= tocrypt)
			post++;
		
		while(alphabet[posk]!= ckey)
			posk++;
		
		posr= post+ posk;
		
		char c= alphabet[posr];

		
		return c;
	}
	
	//It work like vCrypt in reverse direction 
	public static char vDecrypt(char todecrypt, char dkey){
		int posc= 0, posk= 0, posr= 0;
		
		while(alphabet[posc]!= todecrypt)
			posc++;
		
		while(alphabet[posk]!= dkey)
			posk++;
		
		posr= posc- posk;
		
		char c= alphabet[posr];
		
		return c;
	}

}
