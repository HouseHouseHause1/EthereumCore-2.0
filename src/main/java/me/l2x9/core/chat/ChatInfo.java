package me.l2x9.core.chat;

import lombok.Data;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.HashSet;
import java.util.UUID;

@Data
public class ChatInfo {
    private final Player player;
    private final HashSet<UUID> ignoring;
    private final ChatManager manager;
    private Player replyTarget;
    private boolean toggledChat;
    private boolean joinMessages;
    private boolean chatLock;
    private boolean autoTranslate = true;

    public ChatInfo(Player player, ChatManager manager, HashSet<UUID> ignoring, boolean toggledChat, boolean joinMessages, boolean autoTranslate) {
        this.player = player;
        this.manager = manager;
        this.ignoring = ignoring;
        this.toggledChat = toggledChat;
        this.joinMessages = joinMessages;
        this.autoTranslate = autoTranslate;
    }

    public ChatInfo(Player player, ChatManager manager) {
        this.player = player;
        this.manager = manager;
        this.ignoring = new HashSet<>();
    }

    public HashSet<UUID> getIgnoring() {
        return this.ignoring;
    }

    public Player getReplyTarget() {
        return this.replyTarget;
    }

    public void setReplyTarget(final Player replyTarget) {
        this.replyTarget = replyTarget;
    }

    public boolean isChatLock() {
        return this.chatLock;
    }
    public boolean setChatLock(final boolean chatLock) {
        this.chatLock = chatLock;
        return chatLock;
    }
    public boolean isToggledChat() {
        return this.toggledChat;
    }
    public void setToggledChat(final boolean toggledChat) {
        this.toggledChat = toggledChat;
    }
    public boolean isJoinMessages() {
        return this.joinMessages;
    }
    public boolean isAutoTranslate() {
        return this.autoTranslate;
    }

    public void setAutoTranslate(final boolean autoTranslate) {
        this.autoTranslate = autoTranslate;
    }
    public boolean isIgnoring(UUID player) {
        return ignoring.contains(player);
    }

    public void ignorePlayer(UUID player) {
        ignoring.add(player);
    }

    public void unignorePlayer(UUID player) {
        ignoring.remove(player);
    }
    public boolean shouldNotSave() {
        return ignoring.isEmpty() && !toggledChat && !joinMessages && autoTranslate;
    }

    public void saveChatInfo() {
        manager.getChatInfoStore().save(this, player);
    }
}
