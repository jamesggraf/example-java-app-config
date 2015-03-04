@GrabResolver(name="repo.jenkins-ci.org",root='http://repo.jenkins-ci.org/public/')
@Grapes([
    @Grab(group='org.kohsuke', module='github-api', version='1.62'),
    @Grab(group='org.apache.commons', module='commons-lang3', version='3.3.2')
])

import org.apache.commons.lang3.SystemUtils
import org.kohsuke.github.GitHub

githubApiKey = System.getenv()['GITHUB_API_KEY']

GitHub github = GitHub.connectUsingOAuth(githubApiKey)
organization = github.getOrganization('SPSCommerce')
allRepos = organization.getRepositories().collect{ it.getValue().getName() }
ansibleRepos = allRepos.findAll{ it.startsWith('ansible') }

project.properties['ansible_repos_from_rest_api'] = ansibleRepos.join(',')