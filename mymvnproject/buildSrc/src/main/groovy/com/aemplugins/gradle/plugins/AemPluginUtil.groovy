package com.aemplugins.gradle.plugins;

/**
 * Created by jayati on 11/30/2016.
 */
public class AemPluginUtil {

    static void sendCurlRequest(String path,String bundleSymbolicName, String action){
        def server = "localhost"
        def port = "4502"
        def username = "admin"
        def password = "admin"
        final curlRequestStr = "curl -u " + username+":"+password + " -F action=${action} http://" + server+":"+port+"${path} ${bundleSymbolicName}"
        curlRequestStr.execute()
    }

}
