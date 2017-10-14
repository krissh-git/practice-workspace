import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { ArticleService } from './article.service';
import { Article } from './article';


@Component({
    selector: 'app-article',
    templateUrl: './article.component.html',
    styleUrls: ['./article.component.css']
})
export class ArticleComponent {

    allArticles: Article[];
    statusCode: number;
    requestProcessing = false;
    articleIdToUpdate = null;
    processValidation = false;

    articleForm = new FormGroup({
        title: new FormControl('', Validators.required),
        category: new FormControl('', Validators.required)
    });

    constructor(private articleService: ArticleService) { }

    ngOnInit(): void {
        this.getAllArticles();
    }

    getAllArticles(): any {
        this.articleService
            .getAllArticles()
            .subscribe(
            data => this.allArticles = data,
            errorCode => this.statusCode = errorCode);
    }

}