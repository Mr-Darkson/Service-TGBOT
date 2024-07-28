package me.absolute.tgbot.bot;

import me.absolute.tgbot.model.Notification;
import me.absolute.tgbot.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

@Component
public class BusinessBot extends TelegramLongPollingBot {
    private final Logger LOG = LoggerFactory.getLogger(BusinessBot.class);
    private final AdminService adminService;

    @Autowired
    public BusinessBot(@Value("${bot.token}") String botToken, AdminService adminService) {
        super(botToken);
        this.adminService = adminService;
    }

    private final String START = "/start";
    private final String LAST = "/last";



    @Override
    public String getBotUsername() {
        return "notif_buissness_bot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(!update.hasMessage() || !update.getMessage().hasText()) return;

        var message = update.getMessage().getText();
        var chatId = update.getMessage().getChatId();
        var userId = update.getMessage().getFrom().getId();

        if(!adminService.isAuthorized()) {
            Boolean loginStatus = adminService.authorize(message);
            if(loginStatus) {

            }
        }

        switch (message) {
            case START -> {
                String username = update.getMessage().getFrom().getUserName();
                startCommand(chatId, username);
            }
        }
    }



    private void startCommand(Long chatId, String userName) {
        var text = """
                Добро пожаловать, %s!
                Вы подписаны на уведомления.
                
                Дополнительные команды:
                /help - получение справки.
                """;
        var formattedText = String.format(text, userName);
        sendMessage(chatId, formattedText);
    }

    private void sendMessage(Long chatId, String message) {
        var chatIdStr = String.valueOf(chatId);
        var sendMessage = new SendMessage(chatIdStr, message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            LOG.error("Ошибка отправки сообщения", e);
        }
    }

    public void sendNotification(Notification notification) {
        final String message = notification.getMessage();
        listOfLastUpdates.forEach( (chatId, update) -> {
            var chatIdStr = String.valueOf(chatId);
            var sendMessage = new SendMessage(chatIdStr, message);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                LOG.error("Ошибка отправки сообщения", e);
            }
        });
    }
}
