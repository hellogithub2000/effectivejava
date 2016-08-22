package com.oneapm.chap18;

import java.io.*;

/**
 * used to
 * Created by tianjin on 8/2/16.
 */
public class OSExecute {
    public static void command(String command){
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader result = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while((s = result.readLine()) != null){
                System.out.println(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while((s = errors.readLine()) != null){
                System.err.println(s);
                err = true;
            }
        } catch (IOException e) {
            if(!command.startsWith("CMD /C")){
                command("CMD /C" + command);
            }else{
                throw new RuntimeException(e);
            }
        }
        if(err){
            throw new OSExecuteException("Errors executing " + command);
        }
    }
}