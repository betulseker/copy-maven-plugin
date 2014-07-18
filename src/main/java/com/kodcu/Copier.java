package com.kodcu;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Mojo(name = "copy")
public class Copier extends AbstractMojo {

    @Parameter
    private String sourcePath;

    @Parameter
    private String targetPath;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        try {
            startExecution();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void startExecution() throws IOException {

        Path source = Paths.get(sourcePath);
        Path target = Paths.get(targetPath).resolve(source.getFileName());

        getLog().info("*** Copying Started ***");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        getLog().info("*** Copying Completed ***");

    }
}
