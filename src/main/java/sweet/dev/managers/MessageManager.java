package sweet.dev.managers;

import sweet.format.PrettyFormatter;
import sweet.dev.models.MessageSys;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class MessageManager {
    private List<MessageSys> messages;

    private SupplierManager supplierManager;
    private UserManager userManager;

    private static final Logger logger = Logger.getLogger(MessageManager.class.getName());



    public MessageManager(UserManager userManager, SupplierManager supplierManager) {
        this.userManager=userManager;
        this.supplierManager=supplierManager;
        this.messages = new ArrayList<>();

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new PrettyFormatter());
        logger.setUseParentHandlers(false);  // Disable the default console handler
        logger.addHandler(consoleHandler);
    }


    public boolean sendMessage(String sender, String receiver, String content, LocalDate date) {
        if (isValidReceiver(receiver)) {
            MessageSys message = new MessageSys(sender, receiver, content, date, false);
            messages.add(message);
            logger.info("Message sent successfully");

            return true;
        } else {
            logger.info("Failed to send message: invalid receiver");
            return false;
        }
    }

    private boolean isValidReceiver(String receiver) {
        return supplierManager.getTheSupplier(receiver) != null || userManager.getTheUser(receiver) != null;
    }

    public List<MessageSys> getInbox(String username) {
        List<MessageSys> inbox = new ArrayList<>();
        for (MessageSys message : messages) {
            if (message.getReceiver().equals(username)) {
                inbox.add(message);
            }
        }
        return inbox;
    }

    public boolean viewInbox(String user) {
        List<MessageSys> userMessages = getInbox(user);

        StringBuilder inboxMessages = new StringBuilder();
        inboxMessages.append(String.format(" %-20s %-10s %-15s%n", "Sender", "Content", "Date"));
        inboxMessages.append("---------------------------------------------------------%n");

        for (MessageSys message : userMessages) {
            message.setRead(true);
            inboxMessages.append(String.format(" %-20s %-10s %-15s%n", message.getSender(), message.getContent(), message.getDate()));
        }

        logger.info(() -> {
            if (!userMessages.isEmpty()) {
                return "Inbox Messages for user " + user + ":%n" + inboxMessages.toString();
            }
            return "";
        });

        return true;
    }
}
