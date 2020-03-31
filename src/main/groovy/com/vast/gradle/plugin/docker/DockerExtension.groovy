package com.vast.gradle.plugin.docker


import org.gradle.api.Action
import org.gradle.api.Project

class DockerExtension {
    private final transient Project project
    String image
    String version
    String dockerfile
    String registry
    String[] credentials

    DockerExtension(Project project) {
        this.project = project
    }

    void environment(String environment, Action<DockerExtension> configurator) {
        def ext = new DockerExtension().with {
            image = this.image
            version = this.version
            dockerfile = this.dockerfile
            registry = this.registry
            credentials = this.credentials
            return it
        }
        configurator.execute(ext)
        project.tasks.create("docker${environment.capitalize()}", DockerTask).ext = ext
    }
}