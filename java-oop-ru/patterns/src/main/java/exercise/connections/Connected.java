package exercise.connections;

import exercise.TcpConnection;

import java.sql.SQLOutput;

// BEGIN
public  class Connected implements Connection {
private TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error");
    }

    @Override
    public void disconnect() {
        tcpConnection.setConnection(new Disconnected(tcpConnection));
        System.out.println("disconnected");
    }

    @Override
    public void write(String buffer) {
        System.out.println(buffer);
    }
}
// END
