package com.urise.webapp.model;

/**
 * Created by vp on 23.05.17.
 */

    public enum SectionType {
        PERSONAL("Тел."),
        OBJECTIVE("Цель"),
        ACHIEVEMENTS("Достижения"),
        QUALIFICATION("Квалификация"),
        EXPERIENCE("Опыт"),
        EDUCATION("Образование");


        private final String title;

        SectionType(String title) { this.title = title;}

        public String getTitle() { return title;}
    }

