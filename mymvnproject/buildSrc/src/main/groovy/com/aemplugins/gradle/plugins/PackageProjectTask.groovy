package com.aemplugins.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.bundling.Zip

/**
 * Created by jayati on 11/30/2016.
 */
class PackageProjectTask implements Plugin<Project> {

    @Override
    void apply(Project project) {

        String defaultInstallPath = "jcr_root/apps/"+project.archivesBaseName-"-content"+"/install"
        //Collection<Project> osgiProjects = project.parent.childProjects.findAll {it.plugins.findPlugin('osgi')}

        // To do  add bundles to filter.xml
        Task addBundlesToFilterXml = project.task([group: "CQ Plugins"],"addBundlesToFilterXml"){

        }

        // To do copy task for jcr_root content
        Task createPackage =project.task([group: "CQ Plugins", type: Zip, dependsOn: "addBundlesToFilterXml"],"createPackage"){
                from 'src/main/content'
            // To docopy task for bundles into install folder
                from(project.tasks.jar,{
                        into project.ext.has("installPath")? project.ext.installPath : defaultInstallPath
        })
            }

        project.tasks.build.dependsOn += createPackage
    }
}
