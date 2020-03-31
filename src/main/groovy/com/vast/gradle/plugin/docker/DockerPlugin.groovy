package com.vast.gradle.plugin.docker

import org.gradle.api.Plugin
import org.gradle.api.Project

class DockerPlugin implements Plugin<Project> {
    void apply(Project project) {
        def ext = new DockerExtension(project)
        project.extensions.add('dockerConfig', ext)
        project.tasks.create('docker', DockerTask).ext = ext
    }
}
