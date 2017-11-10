import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {RouterModule} from '@angular/router';
import {PrivateServiceModule} from './service/private/private-service.module';
import {CommonComponentsModule} from './component/common/common-component.module';
import {PrivateComponentModule} from './component/private/private-component.module';
import {PublicComponentModule} from './component/public/public-component.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    CommonComponentsModule,
    PrivateComponentModule,
    PublicComponentModule,
    PrivateServiceModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {
}
