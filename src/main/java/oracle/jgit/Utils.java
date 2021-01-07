/*!
 * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
 */

package oracle.jgit;

import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by alivano on 1/6/2021.
 *
 */

public final class Utils {

    static private final String proxyHost = "www-proxy-ash7.us.oracle.com";
    static private final int proxyPort = 80;

    private Utils() {

    }

    /**
     * This is a replacement for Apache Commons FileUtils.deleteDirectory(). Commons implementation does not
     * delete files where read-only attribute is set (Windows only). This is a problem because git on Windows
     * marks some objects as read-only.
     * @param path
     * @throws IOException
     */
    static public void deleteRecursively(Path path) throws IOException {
        try (Stream<Path> walk = Files.walk(path)) {
            //sort in reverse order so that files and contained directories come before the container directories
            walk.sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    //.peek(System.out::println)
                    .forEach((f) -> {
                        //System.out.println(f);
                        f.delete();
            });
        }
    }

    /**
     * This method sets jgit proxy for accessing github programmatically
     */
    static public void setProxy() {
        ProxySelector.setDefault(new ProxySelector() {
            final ProxySelector delegate = ProxySelector.getDefault();

            @Override
            public List<Proxy> select(URI uri) {
                // Filter the URIs to be proxied
                if (uri.toString().contains("github")
                        && uri.toString().contains("https")) {
                    return Arrays.asList(new Proxy(Proxy.Type.HTTP, InetSocketAddress
                            .createUnresolved(proxyHost, proxyPort)));
                }
                if (uri.toString().contains("github")
                        && uri.toString().contains("http")) {
                    return Arrays.asList(new Proxy(Proxy.Type.HTTP, InetSocketAddress
                            .createUnresolved(proxyHost, proxyPort)));
                }
                // revert to the default behaviour
                return delegate == null ? Arrays.asList(Proxy.NO_PROXY)
                        : delegate.select(uri);
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                if (uri == null || sa == null || ioe == null) {
                    throw new IllegalArgumentException(
                            "Arguments can't be null.");
                }
            }
        });
    }

}
