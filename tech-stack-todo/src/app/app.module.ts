import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { StacksComponent } from './stacks/stacks.component';
import { CurrentTechStackComponent } from './current-tech-stack/current-tech-stack.component';
import { StackComponent } from './stack/stack.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  {
    path: 'dashboard',
    component: DashboardComponent
  },
  {
    path: 'stacks',
    component: StacksComponent
  }
]


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    StacksComponent,
    CurrentTechStackComponent,
    StackComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
