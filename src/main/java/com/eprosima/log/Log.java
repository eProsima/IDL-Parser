package com.eprosima.log;

import com.eprosima.log.ColorMessage;

public class Log
{
    public static final int DEBUG = 0;
    public static final int INFO = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;

    public static void printDebug(String message)
    {
        if(m_level <= DEBUG)
            System.out.println(ColorMessage.debug() + message);
    }

    public static void printDebug(String function, String message)
    {
        if(m_level < DEBUG)
            System.out.println(ColorMessage.debug(function) + message);
    }

    public static int m_level = ERROR;
}
