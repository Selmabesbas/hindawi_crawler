package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class HindawiCrawlerAgent {
    private String author;
    private int start_page = 1;
    private int pages;
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    private String Search_Query_Model = "https://www.hindawi.com/search/all/";
    private String Link_Postfix = "/?authors=adel";
    private String Searching_Sentence;

    public HindawiCrawlerAgent(String author,String search_word,int start_page,int pages){
        this.author = author;
        this.Searching_Sentence = search_word;
        this.start_page = start_page;
        this.pages = pages;
    }

    void mapElementsToArticles(Elements elements){
        List<Article> articles = new ArrayList<>();
        for(Element article: elements){
            Article newArticle = new Article();
            try{
                String journal = article.select("ul[class=article-card-header] li").first().text();
                newArticle.setJournal(journal);
            }catch (Exception error){
                System.out.println(error.getMessage());
            }

            try{
                String journal_id = article.select("ul[class=article-card-header] li").get(article.select("ul[class=article-card-header] li").size() - 2).text();
                newArticle.setJournal_id(journal_id);
            }catch (Exception error){
                System.out.println(error.getMessage());
            }


            try{
                String title = article.select("div[class=article-card__title]").text();
                newArticle.setTitle(title);
            }catch (Exception error){
                System.out.println(error.getMessage());
            }

            try{
                String authors = article.select("div[class=ant-card-meta-description]").text();
                newArticle.setAuthors(authors);
            }catch (Exception error){
                System.out.println(error.getMessage());
            }

            articles.add(newArticle);
        }
        this.articles = articles;
    }

    public void fetchWebsiteDocument(){
        try{
            for(int i = start_page;i < pages;i++){
                Elements elements;
                if(i == 1){
                    String url = Search_Query_Model + Searching_Sentence + Link_Postfix;
                    Document document = Jsoup.connect(url).get();
                    elements = document.select("div[class=ant-card ant-card-bordered article-card]");
                }else{
                    String page_indicator = "/page/" + i;
                    String url = Search_Query_Model + Searching_Sentence + page_indicator + Link_Postfix;
                    Document document = Jsoup.connect(url).get();
                    elements = document.select("div[class=ant-card ant-card-bordered article-card]");
                }

                mapElementsToArticles(elements);
            }
        } catch (Exception fetchError){

        }
    }
}
