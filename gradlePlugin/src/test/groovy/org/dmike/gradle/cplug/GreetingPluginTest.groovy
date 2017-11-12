package org.dmike.gradle.cplug

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test


class GreetingPluginTest {
    @Test
    void greeterPluginTaskHello(){
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'org.dmike.gradle.cplug.greeting'

        assert project.tasks.hello instanceof Task
    }
}
