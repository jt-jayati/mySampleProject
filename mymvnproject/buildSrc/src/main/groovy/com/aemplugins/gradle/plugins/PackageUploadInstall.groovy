package com.aemplugins.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

/**
 * Created by jayati on 11/30/2016.
 */
class PackageUploadInstall implements Plugin<Project> {

    @Override
    void apply(Project project) {

        final path = AemPluginConstants.getPACKAGE_MANAGER_PATH()
        Task uploadPackageTask = project.task([group: "CQ Plugins"],'uploadPackageTask')<<{
            AemPluginUtil.sendCurlRequest(path,"blah", "blah")
        }

    }
}
