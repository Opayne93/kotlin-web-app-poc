package com.lifeway

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository, articleRepository: ArticleRepository) =
        ApplicationRunner {
            val opayne = userRepository.save(User("opayne", "Oliver", "Payne"))
            articleRepository.save(Article(
                title = "An interesting title",
                headline = "Extra extra",
                content = "Unpopular opinion: the Star Wars Prequels are better than the Original Trilogy",
                author = opayne
            ))
            articleRepository.save(Article(
                title = "Subtle indicators of when a POC was written",
                headline = "Just use a lot of current memes",
                content = "<Insert Bernie Sanders wearing mittens meme here>",
                author = opayne
            ))
        }
}