package com.urise.webapp.model;

/**
 * Created by vp on 23.05.17.
 */
public enum ContactType {
    PHONE("Тел."),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний тел."),
    SKYPE("Skype"),
    MAIL("Почта"),
    LINKEDIN("Профиль LinkedIn"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    HOME_PAGE("Сайт");

    private final String title;

    ContactType(String title) { this.title = title;}

    public String getTitle() { return title;}
}
