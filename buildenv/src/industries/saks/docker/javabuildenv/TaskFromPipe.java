package industries.saks.docker.javabuildenv;

import org.apache.tools.ant.Task;
import java.io.*;

public class TaskFromPipe extends Task{

    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println(args);

        try {
            // Wrap the System.in inside BufferedReader
            // But do not close it in a finally block, as we 
            // did no open System.in; enforcing the rule that
            // he who opens it, closes it; leave the closing to the OS.
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        
        
        } catch (IOException e) {
        }
    }

}

