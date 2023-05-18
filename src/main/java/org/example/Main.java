package org.example;

public class Main {
    public static void main(String[] args) {
        HindawiCrawlerAgent hindawiCrawlerAgent = new HindawiCrawlerAgent("adel","Atom",1,3);
        hindawiCrawlerAgent.fetchWebsiteDocument();


        for(Article article: hindawiCrawlerAgent.getArticles()){
            System.out.println(article.getJournal_id());
        }
    }
}