package uk.protonull.minestom;

import net.minestom.server.MinecraftServer;

public final class Server {

    public static void main(final String[] args) {
        final String host;
        final int port;
        try {
            MinecraftServer.init().start(
                    host = getHost(),
                    port = getPort()
            );
        }
        catch (final Throwable thrown) {
            MinecraftServer.LOGGER.error("An error occurred while trying to start the server.", thrown);
            System.exit(1);
            return;
        }
        MinecraftServer.LOGGER.info("Server: " + host + ":" + port);
    }

    private static String getHost() {
        return "0.0.0.0";
        // return System.getenv("SERVER_HOST");
    }

    private static int getPort() {
        String tmpPort = System.getenv("SERVER_PORT");
        return Integer.parseInt(tmpPort);
    }

}