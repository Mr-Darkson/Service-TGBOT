package me.absolute.tgbot.configuration;

import me.absolute.tgbot.bot.BusinessBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BusinessBotConfiguration {
    @Bean
    public TelegramBotsApi telegramBotsApi(BusinessBot businessBot) throws TelegramApiException {
        var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(businessBot);
        return telegramBotsApi;
    }
}
