package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
private TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        tcpConnection.setConnection(new Connected(tcpConnection));
        System.out.println("connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Error");
    }

    @Override
    public void write(String buffer) {
        System.out.println("Error");
    }
}
// END
