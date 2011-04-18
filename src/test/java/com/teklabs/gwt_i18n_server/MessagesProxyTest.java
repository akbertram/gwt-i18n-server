package com.teklabs.gwt_i18n_server;

import com.teklabs.gwt_i18n_server.client.LocaleFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/**
 * @author Vladimir Kulev
 */
public class MessagesProxyTest {
    private TestMessages getMessages() {
        return LocaleFactory.getMessages(TestMessages.class);
    }

    @Test
    public void simple() {
        MessagesProxy.setLocale(new Locale("fi", "FI"));
        Assert.assertEquals("Simple text", getMessages().simple());
    }

    @Test
    public void plural() {
        MessagesProxy.setLocale(new Locale("en"));
        Assert.assertEquals("No apples", getMessages().apples(0));
        Assert.assertEquals("An 1 apple", getMessages().apples(1));
        Assert.assertEquals("2 apples", getMessages().apples(2));
    }

    @Test
    public void select() {
        MessagesProxy.setLocale(new Locale("en"));
        Assert.assertEquals("One selected", getMessages().select(1, "select one"));
        Assert.assertEquals("Two selected", getMessages().select(2, "select two"));
        Assert.assertEquals("Three selected", getMessages().select(3, "select three"));
        Assert.assertEquals("Four selected", getMessages().select(4, "select four"));
        Assert.assertEquals("Five selected", getMessages().select(5, "select five"));
    }
}
