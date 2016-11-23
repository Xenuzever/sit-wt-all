package org.sitoolkit.wt.gui.app.project;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.sitoolkit.wt.gui.domain.project.ProjectState;
import org.sitoolkit.wt.gui.infra.maven.MavenUtils;
import org.sitoolkit.wt.gui.test.ThreadUtils;

public class ProjectServiceTest {

    ProjectService service = new ProjectService();

    @Test
    public void testCreate() throws IOException {
        MavenUtils.findAndInstall();

        File projectDir = new File("target/projectservicetest");
        if (projectDir.exists()) {
            FileUtils.deleteDirectory(projectDir);
        }
        projectDir.mkdirs();

        ProjectState projectState = new ProjectState();
        File pomFile = service.createProject(projectDir, projectState);

        ThreadUtils.waitFor("pom.xml is not exist", () -> pomFile.exists());
        ThreadUtils.waitFor("capabilities.properties does not exist",
                () -> new File(projectDir, "src/main/resources/capabilities.properties").exists());
        ThreadUtils.waitFor("sit-wt-default.properties does not exist",
                () -> new File(projectDir, "src/main/resources/sit-wt-default.properties")
                        .exists());
        ThreadUtils.waitFor("project state is not loaded", () -> projectState.isLoaded().get());
    }

}
