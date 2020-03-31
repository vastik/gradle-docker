package com.vast.gradle.plugin.docker

class DockerExtension {
    String image
    String version
    String dockerfile
    String registry
    String[] credentials
}