package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
public class TcpConnection {
    private Connection connection;
    private final String ip;
    private final int port;

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.connection = new Disconnected(this);
    }

    public String getCurrentState() {
        return connection.getCurrentState();
    }

    public void connect() {
        connection.connect();
    }

    public void disconnect() {
        connection.disconnect();
    }

    public void write(String buffer) {
        connection.write(buffer);
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
// END
