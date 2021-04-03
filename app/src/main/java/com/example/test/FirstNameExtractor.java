package com.example.test;

import android.widget.Switch;

public class FirstNameExtractor
{
    public static String extractFirstName(String fullName)
   {
      if (fullName.equals(""))
      {
          return "";
      }
      else if (fullName.equals(fullName))
      {
          return fullName;
      }

      return fullName;
   }

   public static int extractAge (int age)
   {
       return 0;
   }

   public static int extraxtNumber (int Number1, int Number2)
   {
       int Result = 0;
       if (Number1 > Number2)
       {
         return Result =  Number1 - Number2;
       }
       else if (Number2 > Number1)
       {
          return Result = Number2 - Number1;
       }

       else if (Number1 == Number2)
       {
           return Number1 + Number2;
       }
       return Result;
   }

}
