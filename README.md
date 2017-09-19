# PostfixCalc
Postfix calculator with memory.   
  
Usage: java PostfixCalc  
    
  Accepted commands-  
  *  `quit` - quits the program  
  *  `clear` - removes all variables  
  *  `delete <varName>` - deletes specified variable  
  *  `var` - prints all variables names and values in the memory  
      
   Note: This calculator only accepts postfix expressions. An example run of the program is as follows:  
   ```
   java PostfixCalc
   > a = 3 5 + 1 -  
    7.0
   > bee = a 3 *  
    21.0
   > a bee +  
    28.0
   ```
   Accepted operators are +, -, *, /, ^
