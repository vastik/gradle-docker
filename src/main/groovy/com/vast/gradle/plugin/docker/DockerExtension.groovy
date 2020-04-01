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
        def ext = new DockerExtension().with { docker ->
            docker.image = this.image
            docker.version = this.version
            docker.dockerfile = this.dockerfile
            docker.registry = this.registry
            docker.credentials = this.credentials
            configurator.execute(docker)
            return docker
        }

        project.tasks.create("docker${environment.capitalize()}", DockerTask).ext = ext
    }
}