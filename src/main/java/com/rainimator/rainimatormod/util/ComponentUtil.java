package com.rainimator.rainimatormod.util;

import com.google.common.collect.Lists;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.text.LiteralText;

import java.util.List;

public class ComponentUtil {
    public static List<LiteralText> splitText(LiteralText arg_chatText, int chatWidth, TextRenderer fontRenderer) {
        int i = 0;
        LiteralText ichatcomponent = new LiteralText("");
        List<LiteralText> list = Lists.newArrayList();
        List<LiteralText> chatComponents = Lists.newArrayList(arg_chatText);

        for (int j = 0; j < chatComponents.size(); ++j) {
            LiteralText currentChatComponent = chatComponents.get(j);
            String unformattedText = currentChatComponent.asString();
            boolean addToList = false;

            if (unformattedText.contains("\n")) {
                int k = unformattedText.indexOf(10);
                String s1 = unformattedText.substring(k + 1);
                unformattedText = unformattedText.substring(0, k + 1);
                LiteralText chatcomponenttext = new LiteralText(getColorCode(unformattedText) + s1);
                chatcomponenttext.setStyle(currentChatComponent.getStyle());
                chatComponents.add(j + 1, chatcomponenttext);
                addToList = true;
            }
            String textRemovedLastNewline = unformattedText.endsWith("\n") ? unformattedText.substring(0, unformattedText.length() - 1) : unformattedText;
            int textWidth = fontRenderer.getWidth(textRemovedLastNewline);
            LiteralText newChatComponent = new LiteralText(textRemovedLastNewline);
            newChatComponent.setStyle(currentChatComponent.getStyle());

            if (i + textWidth > chatWidth) {
                String s2 = fontRenderer.trimToWidth(unformattedText, chatWidth - i, false);
                String s3 = s2.length() < unformattedText.length() ? unformattedText.substring(s2.length()) : null;
                if (s3 != null) {
                    int l = s2.lastIndexOf(" ");
                    if (l >= 0 && fontRenderer.getWidth(unformattedText.substring(0, l)) > 0) {
                        s2 = unformattedText.substring(0, l);
                        s3 = unformattedText.substring(l);
                    } else if (i > 0 && !unformattedText.contains(" ")) {
                        s2 = "";
                        s3 = unformattedText;
                    }
                    LiteralText chatcomponenttext2 = new LiteralText(getColorCode(s2) + s3);
                    chatcomponenttext2.setStyle(currentChatComponent.getStyle());
                    chatComponents.add(j + 1, chatcomponenttext2);
                }
                textWidth = fontRenderer.getWidth(s2);
                newChatComponent = new LiteralText(s2);
                newChatComponent.setStyle(currentChatComponent.getStyle());
                addToList = true;
            }
            if (i + textWidth <= chatWidth) {
                i += textWidth;
                ichatcomponent.append(newChatComponent);
            } else
                addToList = true;
            if (addToList) {
                list.add(ichatcomponent);
                i = 0;
                ichatcomponent = new LiteralText("");
            }
        }
        list.add(ichatcomponent);
        return list;
    }

    public static String getColorCode(String s) {
        String color = "";
        StringBuilder format = new StringBuilder();
        char last = 0;
        for (char c : s.toCharArray()) {
            if (last == '§') {
                if (c == 'r' || ('0' <= c && c <= 'f')) {
                    color = "§" + c;
                    format = new StringBuilder();
                } else if ('k' <= c && c <= 'o') {
                    format.append("§").append(c);
                }
            }
            last = c;
        }
        return color + format;
    }
}

