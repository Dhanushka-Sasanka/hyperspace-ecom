import { LoginComponent } from './pages/login/login.component';
import { UserComponent } from './pages/user/user.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { RegisterComponent } from './pages/register/register.component';
import { LandingPageComponent } from './pages/landing-page/landing-page.component';
import { MainNavBarComponent } from './pages/landing-page/main-nav-bar/main-nav-bar.component';
import { CategoryComponent } from './pages/landing-page/category/category.component';
import { MainSliderComponent } from './pages/landing-page/main-slider/main-slider.component';
import { FooterComponent } from './pages/landing-page/footer/footer.component';
import { AllAdsComponent } from './pages/landing-page/all-ads/all-ads.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LoginComponent,
    RegisterComponent,
    LandingPageComponent,
    MainNavBarComponent,
    CategoryComponent,
    MainSliderComponent,
    FooterComponent,
    AllAdsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
