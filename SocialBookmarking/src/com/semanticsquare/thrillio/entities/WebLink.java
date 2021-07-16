package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.partner.Shareable;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

public class WebLink extends Bookmark implements Shareable {
    private String url;
    private String host;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString(){
        return MessageFormat.format("Weblink [id={0}, title={1}, profileUrl={2}, url={3}, host={4}]", getId(),
                getTitle(), getProfileUrl(), url, host);
    }

    @Override
    public boolean isKidFriendlyElegible() {
        if (url.contains("porn") || getTitle().contains("porn") || host.contains("adult")){
            return false;
        }
        return true;
    }

    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>?");
        builder.append("<type>WebLink</type>");
        builder.append("<title>").append(getTitle()).append("</title>");
        builder.append("<url>").append(url).append("</url>");
        builder.append("<host>").append(host).append("</host>");
        builder.append("</item>");

        return builder.toString();
    }
}
