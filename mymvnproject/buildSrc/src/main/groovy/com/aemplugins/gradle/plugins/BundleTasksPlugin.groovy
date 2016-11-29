package com.aemplugins.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

/**
 * Created by jayati on 11/29/2016.
 */
class BundleTasksPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {

        def server = "localhost"
        def port = "4502"
        def username = "admin"
        def password = "admin"
        final path = "/system/console/bundles/"
        final curlRequestStr = "curl -u " + username+":"+password + " -F action=stop http://" + server+":"+port+path + project.jar.manifest.symbolicName
        Task uploadBundleTask = project.task([group: "CQ Plugins", dependsOn: "uninstallBundleTask"],'uploadBundleTask')<<{}
        Task startBundleTask = project.task([group: "CQ Plugins", dependsOn: "installBundleTask"],'startBundleTask')<<{}
        Task stopBundleTask = project.task([group: "CQ Plugins"],'stopBundleTask')<<{}
        Task refreshBundlesTask = project.task([group: "CQ Plugins", dependsOn: "startBundleTask"],'refreshBundlesTask')<<{}
        Task installBundleTask = project.task([group: "CQ Plugins", dependsOn: "uploadBundleTask"],'installBundleTask')<<{}
        Task uninstallBundleTask = project.task([group: "CQ Plugins", dependsOn: "stopBundleTask"],'uninstallBundleTask')<<{}
        Task dummytask = project.task([group: "CQ Plugins"],"dummyTask")<<{
            println curlRequestStr
            println curlRequestStr.execute()
        }
    }
}
