package com.alexzit.project03.service;

/**
 * @author Alex
 * @create 2021-09-03 21:24
 */
public class TeamException extends Exception
{
     static final long serialVersionUID = -3387516993124229948L;

     public TeamException()
     {
     }

     public TeamException(String message)
     {
          super(message);
     }
}
