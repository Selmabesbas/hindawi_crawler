package org.example;

public class Article {
    private String title;
    private String authors;
    private String Abstract;
    private String publish_date;
    private String citations;
    private String reference;
    private String link_access;
    private String journal;
    private String journal_id;

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthors() {
        return authors;
    }

    public Article setAuthors(String authors) {
        this.authors = authors;
        return this;
    }

    public String getAbstract() {
        return Abstract;
    }

    public Article setAbstract(String anAbstract) {
        Abstract = anAbstract;
        return this;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public Article setPublish_date(String publish_date) {
        this.publish_date = publish_date;
        return this;
    }

    public String getCitations() {
        return citations;
    }

    public Article setCitations(String citations) {
        this.citations = citations;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public Article setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getLink_access() {
        return link_access;
    }

    public Article setLink_access(String link_access) {
        this.link_access = link_access;
        return this;
    }

    public String getJournal() {
        return journal;
    }

    public Article setJournal(String journal) {
        this.journal = journal;
        return this;
    }

    public Article(){

    }

    public Article(String title, String authors, String anAbstract, String publish_date, String citations, String reference, String link_access, String journal,String journal_id) {
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.journal_id = journal_id;

        Abstract = anAbstract;
        this.publish_date = publish_date;
        this.citations = citations;
        this.reference = reference;
        this.link_access = link_access;

    }
}
