import com.github.pires.obd.commands.protocol.EchoOffCommand;
import com.github.pires.obd.commands.temperature.AmbientAirTemperatureCommand;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException{
        Socket socket;
        try {
            socket = new Socket("192.168.0.10", 1010);
            new AmbientAirTemperatureCommand().run(socket.getInputStream(), socket.getOutputStream());
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }


    }
}
