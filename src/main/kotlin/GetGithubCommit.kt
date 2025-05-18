package org.example

import org.kohsuke.github.GitHubBuilder
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

class GetGithubCommit {

    private val token = System.getenv("GITHUB_TOKEN")
    private val gitHub = GitHubBuilder().withOAuthToken(token).build()
    private val me = gitHub.getMyself()

    fun fetchTodayCommits() {
        val zone = ZoneId.systemDefault()
        val startOfDay = LocalDate.now(zone).atStartOfDay(zone).toInstant()
        val sinceDate = Date.from(startOfDay)

        println("Fetching commits since $sinceDate for user ${me.login}")

        val repos = me.listRepositories()
        repos.forEach { repo ->
            val commits = repo.queryCommits()
                .since(sinceDate)
                .list()
                .toList()

            if (commits.isNotEmpty()) {
                println("Repository: ${repo.fullName}")
                commits.forEach { commit ->
                    val info = commit.commitShortInfo
                    println("  Author: ${info.author?.name} <${info.author?.email}>")
                    println("  Message: ${info.message}")
                }
                println()
            }
        }
    }
}
