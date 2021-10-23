import com.github.pires.obd.commands.protocol.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket socket;
        try {
            socket = new Socket("192.168.0.10", 35000);
            InputStream inputStream = socket.getInputStream();

            /*IgnitionMonitorCommand ignitionMonitorCommand = new IgnitionMonitorCommand();
            ignitionMonitorCommand.run(inputStream, socket.getOutputStream());
            System.out.println("Ignition on: " + ignitionMonitorCommand.isIgnitionOn());*/

            /*ModuleVoltageCommand moduleVoltageCommand = new ModuleVoltageCommand();
            moduleVoltageCommand.run(socket.getInputStream(), socket.getOutputStream());
            System.out.println("Voltage: " + moduleVoltageCommand.getVoltage());*/

            /*PendingTroubleCodesCommand ptcCommand = new PendingTroubleCodesCommand();
            ptcCommand.run(socket.getInputStream(), socket.getOutputStream());
            System.out.println(ptcCommand.getResult());*/

            /*PermanentTroubleCodesCommand ptcCommands = new PermanentTroubleCodesCommand();
            ptcCommands.run(socket.getInputStream(), socket.getOutputStream());
            System.out.println(ptcCommands.getResult());*/

            /*VinCommand vinCommand = new VinCommand();
            vinCommand.run(socket.getInputStream(), socket.getOutputStream());
            System.out.println("Vin: " + vinCommand.getResult());*/

            DescribeProtocolCommand describeProtocolCommand = new DescribeProtocolCommand();
            describeProtocolCommand.run(socket.getInputStream(), socket.getOutputStream());
            System.out.println("Protocol: " + describeProtocolCommand.getResult());

            /*AirIntakeTemperatureCommand airTemperatureCommand = new AirIntakeTemperatureCommand();
            airTemperatureCommand.run(socket.getInputStream(), socket.getOutputStream());
            System.out.println("Temp: " + airTemperatureCommand.getTemperature());*/

            AvailablePidsCommand availablePidsCommand = new AvailablePidsCommand_01_20();
            System.out.println(availablePidsCommand.getCommandPID());
            availablePidsCommand.run(socket.getInputStream(), socket.getOutputStream());
            System.out.println("Pids 01-20: " + availablePidsCommand.getResult());

            availablePidsCommand = new AvailablePidsCommand_21_40();
            availablePidsCommand.run(socket.getInputStream(), socket.getOutputStream());
            System.out.println("Pids 21-40: " + availablePidsCommand.getResult());

            availablePidsCommand = new AvailablePidsCommand_41_60();
            availablePidsCommand.run(socket.getInputStream(), socket.getOutputStream());
            System.out.println("Pids 41-60: " + availablePidsCommand.getResult());

            socket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
