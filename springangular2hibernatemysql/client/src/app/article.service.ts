import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';


import { Article } from './article';

@Injectable()
export class ArticleService {

    allArticleURL = "http://localhost:8080/api/article/all";
    articleURL = "http://localhost:8080/api/article";

    constructor(private http: Http) {

    }


    getArticleById(articleId: string): Observable<Article> {
        let cHeaders = new Headers({ 'Content-Type': 'application/json' });
        let cParams = new URLSearchParams();
        cParams.set('id', articleId);
        let options = new RequestOptions({ headers: cHeaders, params: cParams });
        return this.http
            .get(this.articleURL, options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    getAllArticles(): Observable<Article[]> {
        return this.http
            .get(this.allArticleURL)
            .map(this.extractData)
            .catch(this.handleError);
    }

    createArticle(article: Article): Observable<number> {
        let cHeaders = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: cHeaders });
        return this.http
            .post(this.articleURL, article, options)
            .map(success => success.status)
            .catch(this.handleError);
    }

    updateArticle(article: Article): Observable<number> {
        let cHeaders = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: cHeaders });
        return this.http
            .put(this.articleURL, article, options)
            .map(success => success.status)
            .catch(this.handleError);
    }

    deleteArticle(articleId: string): Observable<number> {
        let cHeaders = new Headers({ 'Content-Type': 'application/json' });
        let cParams = new URLSearchParams();
        cParams.set('id', articleId);
        console.log('articleId>>>>>>>>>>>>>>>>>'+articleId);
        let options = new RequestOptions({ headers: cHeaders, params: cParams });
        return this.http
            .delete(this.articleURL, options)
            .map(success => success.status)
            .catch(this.handleError);
    }


    private extractData(res: Response) {
        let body = res.json();
        return body;
    }

    private handleError(error: Response | any) {
        console.log(error.message || error);
        return Observable.throw(error.status);
    }


}
