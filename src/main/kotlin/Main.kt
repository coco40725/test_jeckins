package org.example

//1. gitlab 的 git commit 還有留下的訊息
//
//2. slack 的訊息
//
//3. gitlabe issue 可能會掛成 assign
//
//4. google 行事曆的開會
//
//5. 有一些 自己在做的事 但是好像沒辦法追蹤到 比方說 我正在開發 a 專案 但是 沒有 commit 上去 因為在開發中 程式沒寫完 這一種你有甚麼建議
//
//6. 一些雜事 比方說 可能我在教新人 或是說 幫忙查證依些東西 這一種也不知道怎麼追蹤到
fun main() {
    GetGithubCommit().fetchTodayCommits()
}
