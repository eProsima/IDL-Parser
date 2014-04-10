package com.eprosima.idl.util;

import java.io.File;

public class Util
{
    public static String getIDLFileNameOnly(String idlFilename)
    {
        int index = -1;
        String auxString = idlFilename, returnedValue = null;
        
        index = idlFilename.lastIndexOf(File.separator);
        
        if(index == -1)
            index = idlFilename.lastIndexOf('/');
        
        if(index != -1)
            auxString = idlFilename.substring(index + 1);
        
        // Remove '.idl'
        returnedValue = auxString.substring(0, auxString.length() - 4);
        
        return returnedValue;
    }

    public static String getIDLFileOnly(String idlFileURL)
    {
        int index = -1;
        String returnedValue = null;
        
        index = idlFileURL.lastIndexOf(File.separator);
        
        if(index == -1)
            index = idlFileURL.lastIndexOf('/');
        
        if(index != -1)
            returnedValue = idlFileURL.substring(index + 1);
        else
            returnedValue = idlFileURL;
        
        return returnedValue;
    }

    public static String getIDLFileDirectoryOnly(String idlFileURL)
    {
        int index = -1;
        String returnedValue = null;
        
        index = idlFileURL.lastIndexOf(File.separator);
        
        if(index == -1)
            index = idlFileURL.lastIndexOf('/');
        
        if(index != -1)
            returnedValue = idlFileURL.substring(0, index + 1);
        
        return returnedValue;
    }

    public static String stringTrimAll(String str)
    {
    	String trimstr = str.replaceAll("\\s+", "").toUpperCase();
    	return trimstr;
    }
}
