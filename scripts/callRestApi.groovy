@Grapes([
    @Grab(group='org.apache.commons', module='commons-lang3', version='3.3.2')
])

import org.apache.commons.lang3.SystemUtils

log.debug("Using Java " + SystemUtils.JAVA_VERSION)

project.properties['custom_jvm_version'] = SystemUtils.JAVA_VERSION

// the first reference is not filtered by Maven, the second reference is
assert "$project.name" == "${project.name}"